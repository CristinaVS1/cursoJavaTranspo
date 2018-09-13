package br.com.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import br.com.farmacia.domain.Fabricante;
import br.com.farmacia.factory.ConexaoFactory;

public class FabricanteDAO {

	public void salvar(Fabricante fabricante) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES (?) ");
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, fabricante.getDescricao());
		comando.executeUpdate();

	}

	// Comando para excluir linhas no BD

	public void excluir(Fabricante fabricante) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("Delete from fabricante ");
		sql.append("WHERE codigo = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, fabricante.getCodigo());
		comando.executeQuery();

	}

	public void atualizar(Fabricante fabricante) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE fabricante  ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(2, fabricante.getCodigo());
		comando.setString(1, fabricante.getDescricao());

		comando.executeQuery();

	}

	public Fabricante buscar(Fabricante fabricante) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * ");
		sql.append("FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, fabricante.getCodigo());
		ResultSet resultado = comando.executeQuery();

		Fabricante retorno = null;

		if (resultado.next()) {

			retorno = new Fabricante();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));

		}

		return retorno;

	}

	public ArrayList<Fabricante> buscarTodos() throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * from fabricante ");
		sql.append("ORDER BY ");
		sql.append("descricao asc ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet retorno = comando.executeQuery();

		ArrayList<Fabricante> b = new ArrayList<Fabricante>();

		while (retorno.next()) {

			Fabricante novo = new Fabricante();
			novo.setCodigo(retorno.getLong("codigo"));
			novo.setDescricao(retorno.getString("descricao"));

			b.add(novo);

		}

		return b;

	}

	public ArrayList<Fabricante> buscaPorLetra(Fabricante fabricante) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * from fabricante ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append(" order by descricao asc ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + fabricante.getDescricao() + "%");
		ResultSet retorno = comando.executeQuery();

		ArrayList<Fabricante> letra = new ArrayList<Fabricante>();

		while (retorno.next()) {

			Fabricante novo = new Fabricante();
			novo.setCodigo(retorno.getLong("codigo"));
			novo.setDescricao(retorno.getString("descricao"));

			letra.add(novo);

		}
		return letra;
	}

	public static void main(String args[]) throws SQLException {

		// Fabricante f = new Fabricante();
		// f.setDescricao("fabrica II");

		// FabricanteDAO fDAO = new FabricanteDAO();
		// fDAO.salvar(f);

		// Fabricante fab = new Fabricante();
		// fab.setCodigo(1L);;

		// FabricanteDAO fabDAO = new FabricanteDAO();
		// fabDAO.excluir(fab);

		// Fabricante esd = new Fabricante();
		// esd.setCodigo(2l);
		// esd.setDescricao("jeferssonnn");

		// FabricanteDAO up1DAO = new FabricanteDAO();
		// up1DAO.atualizar(esd);

		// Fabricante busq = new Fabricante();
		// busq.setCodigo(2L);

		// FabricanteDAO busq1 = new FabricanteDAO();
		// Fabricante f = busq1.buscar(busq);

		// System.out.println("Resultado da busca " + f);

		//FabricanteDAO todos = new FabricanteDAO();
		//ArrayList<Fabricante> lista = todos.buscarTodos();

		//for (Fabricante fabricante : lista) {

			//System.out.println("Resultado de todos os fabricantes  " + fabricante);
		//}
		
		Fabricante l = new Fabricante();
		l.setDescricao("s");
		FabricanteDAO todos = new FabricanteDAO();
		ArrayList<Fabricante> lista = todos.buscaPorLetra(l);

		for (Fabricante fabricante : lista) {

			System.out.println("Resultado de todos os fabricantes  " + fabricante);
		}

	}

}

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

	public void excluir(Fabricante fabricante) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, fabricante.getCodigo());
		comando.executeUpdate();
	}

	public void editar(Fabricante fabricante) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, fabricante.getDescricao());
		comando.setLong(2, fabricante.getCodigo());
		comando.executeUpdate();
	}

	public Fabricante buscarPorCodigo(Fabricante fabricante) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
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

	public ArrayList<Fabricante> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

		while (resultado.next()) {
			Fabricante f = new Fabricante();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));
			lista.add(f);
		}

		return lista;

	}

	public ArrayList<Fabricante> buscarPorDescricao(Fabricante fabricante) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + fabricante.getDescricao() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

		while (resultado.next()) {
			Fabricante f = new Fabricante();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));
			lista.add(f);
		}

		return lista;

	}

	public static void main(String[] args) {
		// Salva
		Fabricante f1 = new Fabricante();
		f1.setDescricao("Fabricante 1");

		Fabricante f2 = new Fabricante();
		f2.setDescricao("Fabricante 2");

		FabricanteDAO fdao = new FabricanteDAO();
		try {
			fdao.salvar(f1);
			fdao.salvar(f2);
			System.out.println("Fabricante salvo com sucesso!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar salvar um Fabricante");
			e.printStackTrace();
		}

		// Exclui
		Fabricante f3 = new Fabricante();
		f3.setCodigo(1L);

		FabricanteDAO fdao2 = new FabricanteDAO();
		try {
			fdao2.excluir(f3);
			System.out.println("Fabricante excluido com sucesso!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar excluir um Fabricante");
			e.printStackTrace();
		}

		// Editar
		Fabricante f4 = new Fabricante();
		f4.setCodigo(1L);
		f4.setDescricao("Fabricante EDITADO");

		FabricanteDAO fdao3 = new FabricanteDAO();
		try {
			fdao3.editar(f4);
			System.out.println("Fabricante editado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar editar um Fabricante");
			e.printStackTrace();
		}

		// Busca por Código
		Fabricante f5 = new Fabricante();
		f5.setCodigo(1L);

		FabricanteDAO fdao4 = new FabricanteDAO();
		try {
			Fabricante resultadoBusca = fdao4.buscarPorCodigo(f5);
			System.out.println("Resultado: " + resultadoBusca);
			System.out.println("Fabricante localizado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar buscar um Fabricante");
			e.printStackTrace();
		}

		// Listar
		FabricanteDAO fdao5 = new FabricanteDAO();
		try {
			ArrayList<Fabricante> lista = fdao5.listar();
			for (Fabricante fabricante : lista) {
				System.out.println("Resultado: " + fabricante);
			}
			System.out.println("Fabricantes listados com sucesso!");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao tentar listar Fabricantes");
			e.printStackTrace();
		}

		// Busca por Descricao
		Fabricante f6 = new Fabricante();
		f6.setDescricao("1");

		FabricanteDAO fdao6 = new FabricanteDAO();
		try {
			ArrayList<Fabricante> lista = fdao6.buscarPorDescricao(f6);
			for (Fabricante fabricante : lista) {
				System.out.println("Resultado: " + fabricante);
			}
			System.out.println("Fabricantes listados com sucesso!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar listar Fabricantes");
			e.printStackTrace();
		}
	}
}

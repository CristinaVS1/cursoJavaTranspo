package br.com.apex.prova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.apex.prova.CarrosBean;
import br.com.apex.prova.Carros;
public class CarrosDAO {

	private Connection conexao;

	public CarrosDAO() throws SQLException {
		this.conexao = new NovaConexao().conectar();
	}

	public List<Carros> listarTodosCarros() throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * from carros ");
		sql.append("ORDER BY ");
		sql.append("nome,marca,ano,qtd_portas,preco ");

		Connection conexao = (Connection) NovaConexao.conectar();

		PreparedStatement comando = ((java.sql.Connection) conexao).prepareStatement(sql.toString());
		ResultSet retorno = comando.executeQuery();

		ArrayList<Carros> b = new ArrayList<Carros>();

		try {
			while (retorno.next()) {

				Carros novo = new Carros( null, null, null, 0, 0);
				novo.setNome(retorno.getString("nome"));
				novo.setMarca(retorno.getString("marca"));
				novo.setAno(retorno.getDate("ano"));
				novo.setQtd_portas(retorno.getInt("qtd_portas"));
				novo.setPreco(retorno.getDouble("preco"));

				b.add(novo);

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return b;

	}

	public static void main(String[] args) throws SQLException {

		CarrosDAO todosCarros = new CarrosDAO();
		List<Carros> lista = todosCarros.listarTodosCarros();

		for (Carros carros : lista) {
			System.out.println("Todos os resultados do BD" + carros);

		}

	}
}

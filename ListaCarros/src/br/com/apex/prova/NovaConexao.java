package br.com.apex.prova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class NovaConexao {

	static String usuario = "root";
	static String passworld = "";
	static String url = "jdbc:mysql://localhost:3306/prova";

	public static Connection conectar() throws SQLException {
		DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(url, usuario, passworld);

		return conexao;

	}

	public static void main(String args[]) {

		try {
			Connection conexao = NovaConexao.conectar();
			System.out.println("Conectou com sucesso");
		}

		catch (Exception e) {
			System.out.println("Conexão falhou");
			e.printStackTrace();
		}

	}



















}


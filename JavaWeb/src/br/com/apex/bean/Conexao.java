package br.com.apex.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	
	
	static String usuario = "root";
	static String passworld = "";
	static String url = "jdbc:mysql://localhost:3306/fabrica";

	public static Connection conectar() throws SQLException {
		DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(url, usuario, passworld);

		return conexao;

	}

	public static void main(String args[]) {

		try {
			Connection conexao = Conexao.conectar();
			System.out.println("Conectou com sucesso");
		}

		catch (Exception e) {
			System.out.println("Conex�o falhou");
			e.printStackTrace();
		}

	}
}

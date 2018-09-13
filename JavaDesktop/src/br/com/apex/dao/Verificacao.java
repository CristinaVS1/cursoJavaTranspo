package br.com.apex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.apex.classes.Usuario;
import br.com.apex.conexao.Conexao;

public class Verificacao {

	public boolean verificarUser(Usuario usuario) throws SQLException {
		boolean temUsuario = false;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * from usuario ");
		sql.append("WHERE user = ? and password = ?");

		Connection conexao = Conexao.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, usuario.getUser());
		comando.setString(2, usuario.getPassword());

		ResultSet r = comando.executeQuery();

		if (r.next()) {
			temUsuario = true;
		}

		return temUsuario;

	}

	public static void main(String[] args) {

		Usuario u = new Usuario();
		u.setUser("prof_pop1");
		u.setPassword("zxcv");

		Verificacao v = new Verificacao();
		try {
			boolean tem = v.verificarUser(u);
			if (tem) {
				System.out.println("O usuário: " + u.getUser() + " existe no banco de dados!");
			} else {
				System.err.println("O usuário: " + u.getUser() + " não existe no banco de dados!");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}

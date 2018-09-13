package br.com.apex.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.apex.bean.Clientes;
import br.com.apex.bean.Endereco;
import br.com.apex.bean.Produto;
import br.com.apex.bean.Usuario;
import br.com.apex.bean.Conexao;


public class FabricaDAO {

	public void salvarCliente(Clientes cliente, Endereco endereco) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO endereco");
		sql.append("(rua, numero, bairro, cidade, uf)");
		sql.append("VALUES (?,?,?,?,?)");
		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
		comando.setString(1, endereco.getRua());
		comando.setInt(2, endereco.getNumero());
		comando.setString(3, endereco.getBairro());
		comando.setString(4, endereco.getCidade());
		comando.setString(5, endereco.getUf());
		int idEndereco = 0;

		if (comando.executeUpdate() > 0) {

			ResultSet resultado = comando.getGeneratedKeys();
			resultado.next();
			idEndereco = resultado.getInt(1);

		}

		StringBuilder sql1 = new StringBuilder();
		sql.append("INSERT INTO clientes");
		sql.append("(nome,sobrenome,idade,cpf,endereco,ativo)");
		sql.append("VALUES (?,?,?,?,?,?)");
		Connection conexao1 = Conexao.conectar();

		PreparedStatement comando1 = conexao1.prepareStatement(sql1.toString());
		comando1.setString(1, cliente.getNome());
		comando1.setString(2, cliente.getSobrenome());
		comando1.setInt(3, cliente.getIdade());
		comando1.setInt(4, cliente.getCpf());
		comando1.setInt(5, idEndereco);
		comando1.setBoolean(6, cliente.isAtivo());
		comando1.executeUpdate();

	}

	public void salvarProduto(Produto produto) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produto");
		sql.append("(codigo, descricao, peso, preco, qtd_estoque)");
		sql.append("VALUES (?,?,?,?,?)");
		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, produto.getCodigo());
		comando.setString(2, produto.getDescricao());
		comando.setDouble(3, produto.getPeso());
		comando.setDouble(4, produto.getPreco());
		comando.setInt(5, produto.getQtd_estoque());
		comando.executeUpdate();

	}

	public void salvarUsuario(Usuario usuario) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO usuario");
		sql.append("(nome, sobrenome, user, password, superUser)");
		sql.append("VALUES (?,?,?,?,?)");
		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, usuario.getNome());
		comando.setString(2, usuario.getSobrenome());
		comando.setString(3, usuario.getUser());
		comando.setString(4, usuario.getPassword());
		comando.setBoolean(5, usuario.getSuperUser());

		comando.executeUpdate();

	}

	public ArrayList<Clientes> listarTodosClientes() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT  c.id,c.nome,c.sobrenome,c.idade,c.cpf,c.ativo,e.id,e.rua,e.numero,e.bairro,e.cidade,e.uf  ");
		sql.append("FROM clientes c, endereco e where c.endereco = e.id  ");

		Connection conexao = Conexao.conectar();

		PreparedStatement conect = conexao.prepareStatement(sql.toString());
		ResultSet resultado = conect.executeQuery();

		ArrayList<Clientes> lista = new ArrayList<Clientes>();

		while (resultado.next()) {

			Endereco e = new Endereco();
			Clientes c = new Clientes();

			e.setId(resultado.getInt("id"));
			e.setRua(resultado.getString("rua"));
			e.setNumero(resultado.getInt("numero"));
			e.setBairro(resultado.getString("bairro"));
			e.setCidade(resultado.getString("cidade"));
			e.setUf(resultado.getString("uf"));

			c.setId(resultado.getInt("id"));
			c.setNome(resultado.getString("nome"));
			c.setSobrenome(resultado.getString("sobrenome"));
			c.setIdade(resultado.getInt("idade"));
			c.setCpf(resultado.getInt("cpf"));
			c.setEndereco(e);
			c.setAtivo(resultado.getBoolean("ativo"));

			lista.add(c);

		}
		return lista;

	}

	
	public ArrayList<Produto> listarTodosProduto() throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * from produto ");
		

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet retorno = comando.executeQuery();

		ArrayList<Produto> b = new ArrayList<Produto>();

		while (retorno.next()) {

			Produto novo = new Produto();
			novo.setCodigo(retorno.getInt("codigo"));
			novo.setDescricao(retorno.getString("descricao"));
			novo.setPeso(retorno.getDouble("peso"));
			novo.setPreco(retorno.getDouble("preco"));
			novo.setQtd_estoque(retorno.getInt("qtd_estoque"));

			b.add(novo);

		}

		return b;

	}

	public ArrayList<Usuario> listarTodosUsuario() throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * from usuario ");
		sql.append("ORDER BY ");
		sql.append("nome, sobrenome, user, password, superUser ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet retorno = comando.executeQuery();

		ArrayList<Usuario> b = new ArrayList<Usuario>();

		while (retorno.next()) {

			Usuario novo = new Usuario();
			novo.setNome(retorno.getString("nome"));
			novo.setSobrenome(retorno.getString("sobrenome"));
			novo.setUser(retorno.getString("user"));
			novo.setPassword(retorno.getString("password"));
			novo.setSuperUser(retorno.getBoolean("superUser"));

			b.add(novo);

		}

		return b;

	}

	public static void main(String args[]) throws SQLException {

		/*FabricaDAO f = new FabricaDAO();

		Endereco e = new Endereco();
		e.setRua("Alice Ferreira dos Santos");
		e.setNumero(777);
		e.setBairro("Badenfurt");
		e.setCidade("Blumenau");
		e.setUf("SC");

		
		Clientes c = new Clientes();
		c.setNome("Pedro");
		c.setSobrenome("da Silva");
		c.setIdade(18);
		c.setCpf(004112345);
		c.setEndereco(e);
		c.setAtivo(false);

	
		f.salvarCliente(c, e);

		Produto p = new Produto();
		p.setCodigo(0001);
		p.setDescricao("Parafusos tamanho 2");
		p.setPeso(0.5);
		p.setPreco(0.50);
		p.setQtd_estoque(1000);

		FabricaDAO produto = new FabricaDAO();
		produto.salvarProduto(p);

		Usuario usuario = new Usuario();
		usuario.setNome("Carlos");
		usuario.setSobrenome("Schneider");
		usuario.setUser("carlos1234");
		usuario.setPassword("");
		usuario.setSuperUser(false);

		FabricaDAO u = new FabricaDAO();
		u.salvarUsuario(usuario);

		FabricaDAO todosClientes = new FabricaDAO();
		ArrayList<Clientes> lista = todosClientes.listarTodosClientes();

		for (Clientes clientes : lista) {
			System.out.println("Resultado de todos os clientes cadastrados: " + clientes);
		}

		FabricaDAO todosEndereco = new FabricaDAO();
		ArrayList<Endereco> lista1 = todosEndereco.listarTodosEndereco();

		for (Endereco endereco1 : lista1) {
			System.out.println("Resultado de todos os endereços cadastrados: " + endereco1);
		*/}

		FabricaDAO todosProdutos = new FabricaDAO();
		ArrayList<Produto> lista2 = todosProdutos.listarTodosProduto();

		for (Produto produto2 : lista2) {
			System.out.println("Resultado de todos os produtos cadastrados: " + produto2);

		}

		/*FabricaDAO todosUsuarios = new FabricaDAO();
		ArrayList<Usuario> lista3 = todosUsuarios.listarTodosUsuario();

		for (Usuario usuario2 : lista3) {
			System.out.println("Resultado de todos os usuarios cadastrados: " + usuario2);
		}
*/
	}

}

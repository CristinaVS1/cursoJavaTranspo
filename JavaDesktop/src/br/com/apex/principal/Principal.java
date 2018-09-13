package br.com.apex.principal;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.apex.classes.Clientes;
import br.com.apex.classes.Endereco;
import br.com.apex.classes.Produto;
import br.com.apex.classes.Usuario;
import br.com.apex.dao.FabricaDAO;
import br.com.apex.dao.Verificacao;

public class Principal {

	public static void main(String args[]) {

		JOptionPane.showConfirmDialog(null, "Bem-vindo a nosso sistema de cadastro");

		String user = JOptionPane.showInputDialog(null, "Digite seu login");
		String senha = JOptionPane.showInputDialog(null, "Digite sua senha");

		Usuario u = new Usuario();
		u.setUser(user);
		u.setPassword(senha);

		Verificacao v = new Verificacao();
		try {
			boolean tem = v.verificarUser(u);
			if (tem) {

				JOptionPane.showMessageDialog(null, "Usuário ja cadastrado!");
				Principal p = new Principal();
				p.menuPrincipal(u);
			} else {

				JOptionPane.showMessageDialog(null, "Usuário e senha inválidos \n Faça seu cadastro no menu principal ");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public void menuPrincipal(Usuario usuario) {

		int opcao = 0;
		while (opcao != 4) {

			int selecioneOpcao = Integer.parseInt((JOptionPane.showInputDialog(null,
					" 1 - Cadastro Usuario \n 2 - Cadastrar Cliente \n 3 - Cadastrar Produto \n 4 - Sair")));

			switch (selecioneOpcao) {
			case 1:
				if (usuario.getSuperUser() == true) {
					cadastrarUsuario();
				} else {
					JOptionPane.showMessageDialog(null, "Você não tem permissão para cadastrar Usuários!");
				}
				break;

			case 2:

				cadastrarCliente();

				break;

			case 3:
				cadastrarProduto();

				break;
			
				default:
				break;
			}

		}

	}

	private void cadastrarUsuario() {
		String nome = JOptionPane.showInputDialog(null, "Digite seu nome");
		String sobrenome = JOptionPane.showInputDialog(null, "Digite seu sobrenome");
		String user = JOptionPane.showInputDialog(null, "Digite um nome para usuario");
		String password = JOptionPane.showInputDialog(null, "Digite uma senha para seu login");
		String superUser = JOptionPane.showInputDialog(null,
				"O usuário que você está cadastrando é um super Usuário? \n Digite: \n S - para sim \n N - para não ");

		Usuario u = new Usuario();
		u.setNome(nome);
		u.setSobrenome(sobrenome);
		u.setUser(user);
		u.setPassword(password);
		if (superUser.equalsIgnoreCase("s")) {
			u.setSuperUser(true);
		} else if (superUser.equalsIgnoreCase("n")) {
			u.setSuperUser(false);
		}

		FabricaDAO f = new FabricaDAO();
		try {
			f.salvarUsuario(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void cadastrarCliente() {

		String nome = JOptionPane.showInputDialog(null, "Digite seu nome ");
		String sobrenome = JOptionPane.showInputDialog(null, "Digite seu sobrenome");
		int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite sua idade"));
		int cpf = Integer.parseInt(
				JOptionPane.showInputDialog(null, "Digite seu cpf  \n OBS: sem caracter estranho apenas números"));
		int ativo = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Este cliente está ativo? \n Digite 1 - para sim \n Digite 2 - para não"));
		String rua = JOptionPane.showInputDialog(null, "Digite seu logradouro ");
		int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da sua residência"));
		String bairro = JOptionPane.showInputDialog(null, "Digite o bairro onde você reside ");
		String cidade = JOptionPane.showInputDialog(null, "Digite a cidade onde você reside ");
		String uf = JOptionPane.showInputDialog(null, "Digite o estado onde você reside ");

		Clientes c = new Clientes();
		c.setNome(nome);
		c.setSobrenome(sobrenome);
		c.setIdade(idade);
		c.setCpf(cpf);

		if (ativo == 1) {
			c.setAtivo(true);
		}

		else if (ativo == 2) {
			c.setAtivo(false);
		}

		Endereco e = new Endereco();
		e.setRua(rua);
		e.setNumero(numero);
		e.setBairro(bairro);
		e.setCidade(cidade);
		e.setUf(uf);

		FabricaDAO f = new FabricaDAO();
		try {
			f.salvarCliente(c, e);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

	}

	private void cadastrarProduto() {

		int codigo = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Digite o código do produto que deseja cadastrar "));
		String descricao = JOptionPane.showInputDialog(null, "Insira a descrição do produto ");
		double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o peso do produto "));
		double preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o preco do produto "));
		int qtd_estoque = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a quantidade no estoque? "));

		Produto p = new Produto();
		p.setCodigo(codigo);
		p.setDescricao(descricao);
		p.setPeso(peso);
		p.setPreco(preco);
		p.setQtd_estoque(qtd_estoque);

		FabricaDAO f = new FabricaDAO();
		try {
			f.salvarProduto(p);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}

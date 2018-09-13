package br.com.apex.prova.contato;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Contato implements Serializable {

	private String nome;
	private String sobrenome;
	private String email;
	private long telefone;
	private String sexo;
	private int idade;
	public int length;


	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		String mostra = "Nome " + nome + "Sobrenome " + sobrenome + "E-mail " + email + "Telefone " + telefone + "Sexo "
				+ sexo + "Idade " + idade;
		return mostra;
	}

	public void cadastrar(String nome, String sobrenome, String email, long telefone, String sexo, int idade) {

		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.sexo = sexo;
		this.idade = idade;
		
		

	}
	
	public void Mostrar() {

		System.out.println("Nome: " + nome);
		System.out.println("Sobrenome: " + sobrenome);
		System.out.println("E-mail: " + email);
		System.out.println("Telefone: " + telefone);
		System.out.println("Sexo: " + sexo);
		System.out.println("Idade: " + idade);
		
		

	}
	
	public void Adicionar(Contato c) {

	ArrayList<Contato> contatos = new ArrayList();
   contatos.add(c);
	}
	
	public void verificar() {
		if (email.equals(email) == true) {

   			JOptionPane.showMessageDialog(null, "Usuario cadastrado com êxito", "Cadastro", 0);

   		}

   		else if (email.equals(email) == false) {

   			JOptionPane.showConfirmDialog(null, "Usuario ja cadastrado! \n Por favor digite outro nome de usuario");
   		}
	}
	
	
   
	}



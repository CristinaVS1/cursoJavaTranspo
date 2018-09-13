package br.com.apex.bean;

public class Clientes extends Pessoa {
   
	private int id;
	private Endereco endereco;
	private int idade;
	private int cpf;
	private boolean ativo;

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		String saida = nome + " - " + sobrenome +  " - " + endereco +  " - " + idade +  " - " + cpf +  " - " + ativo;
		return saida;
	}
}

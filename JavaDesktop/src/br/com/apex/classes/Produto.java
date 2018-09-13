package br.com.apex.classes;

public class Produto {

	protected int id;
	protected int codigo;
	protected String descricao;
	protected double peso;
	protected double preco;
	protected int qtd_estoque;

	public int getCodigo() {
		return codigo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtd_estoque() {
		return qtd_estoque;
	}

	public void setQtd_estoque(int qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}

	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		String saida = codigo + " - " + descricao + " - " + peso + " - " + preco + " - " + qtd_estoque ;
		return saida;
	}
	
}

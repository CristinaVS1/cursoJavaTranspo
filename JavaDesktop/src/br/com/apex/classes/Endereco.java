package br.com.apex.classes;

public class Endereco extends Clientes {

	protected String rua;
	protected int numero;
	protected String bairro;
	protected String cidade;
	protected String uf;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		String saida = rua + " - " + numero + " - " + bairro + " - " + cidade + " - " + uf ;
		return saida;
	}

}

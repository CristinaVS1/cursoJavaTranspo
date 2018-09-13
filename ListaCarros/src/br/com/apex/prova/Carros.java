package br.com.apex.prova;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.apex.prova.CarrosBean;
import br.com.apex.prova.CarrosDAO;

public class Carros {

	

	public Carros( String nome, String marca, Date ano, int qtd_portas, double preco) {
		super();
		
		this.nome = nome;
		this.marca = marca;
		this.ano = ano;
		this.qtd_portas = qtd_portas;
		this.preco = preco;
	}

	
	private String nome;
	private String marca;
	private Date ano;
	private int qtd_portas;
	private double preco;


	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getAno() {
		return ano;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}

	public int getQtd_portas() {
		return qtd_portas;
	}

	public void setQtd_portas(int qtd_portas) {
		this.qtd_portas = qtd_portas;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
    public String toString() {
        return "carros{" +
                ", Nome= " + nome + '\'' +
                ", Marca= " + marca + '\'' +
                ", Ano= " + ano + '\'' +
                ", Quantidade de portas= " + qtd_portas + '\'' +
                ", Preco= " + preco +
                '}';
    }


}

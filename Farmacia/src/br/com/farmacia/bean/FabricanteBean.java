package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.farmacia.dao.FabricanteDAO;
import br.com.farmacia.domain.Fabricante;

@ManagedBean(name = "MBFabricante")
@ViewScoped

public class FabricanteBean {

	private ListDataModel<Fabricante> itens;
	private Fabricante fabricante;

	public ListDataModel<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fabricante> itens) {
		this.itens = itens;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			ArrayList<Fabricante> lista;
			lista = dao.listar();
			itens = new ListDataModel<Fabricante>(lista);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void prepararNovo() {
		fabricante = new Fabricante();
	}

	public void novo() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);

			//Array Abaixo serve para "recaregar" a pesquisa, a lista
			ArrayList<Fabricante> lista = dao.listar();
			itens = new ListDataModel<Fabricante>(lista);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

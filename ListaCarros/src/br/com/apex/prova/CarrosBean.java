package br.com.apex.prova;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;

import br.com.apex.prova.CarrosDAO;
import br.com.apex.prova.Carros;


@SuppressWarnings("deprecation")
@ManagedBean(name = "MBProvaCarro")
@ViewScoped
public class CarrosBean {

	private ListDataModel<Carros> itensTodosCarros;
	private Carros carro;

	public ListDataModel<Carros> getItensTodosProdutos() {
		return itensTodosCarros;
	}

	public void setItensTodosProdutos(ListDataModel<Carros> itensTodosProdutos) {
		this.itensTodosCarros = itensTodosProdutos;
	}

	public Carros getCarro() {
		return carro;
	}

	public void setCarro(Carros carro) {
		this.carro = carro;
	}
	
	
	@PostConstruct
	
	public void PreparaPesquisa() {
		
		try {
			CarrosDAO c = new CarrosDAO();
			List<Carros> lista;
			lista = c.listarTodosCarros();
			itensTodosCarros = new ListDataModel<Carros>(lista);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}

package br.com.apex.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.apex.bean.Produto;
import br.com.apex.bean.FabricaDAO;

@ManagedBean(name = "MBFabricaProduto")
@ViewScoped
public class ProdutoBean {
	
	
	private ListDataModel<Produto> itensTodosProdutos;
	private Produto produto;

	public ListDataModel<Produto> getItensTodosProdutos() {
		return itensTodosProdutos;
	}

	public void setItensTodosProdutos(ListDataModel<Produto> itensTodosProdutos) {
		this.itensTodosProdutos = itensTodosProdutos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	@PostConstruct

	public void prepararPesquisaProduto() {

		try {
			FabricaDAO dao = new FabricaDAO();
			ArrayList<Produto> lista1;
			lista1 = dao.listarTodosProduto();
			itensTodosProdutos = new ListDataModel<Produto>(lista1);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	
	
	
}

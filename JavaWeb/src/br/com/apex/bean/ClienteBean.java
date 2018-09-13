package br.com.apex.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.apex.bean.FabricaDAO;

@ManagedBean(name = "MBCliente")
@ViewScoped
public class ClienteBean {

	private ListDataModel<Clientes> itensTodosClientes;
	private Clientes clientes;

	public ListDataModel<Clientes> getItensTodosClientes() {
		return itensTodosClientes;
	}

	public void setItensTodosClientes(ListDataModel<Clientes> itensTodosClientes) {
		this.itensTodosClientes = itensTodosClientes;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			FabricaDAO dao = new FabricaDAO();
			ArrayList<Clientes> lista;
			lista = dao.listarTodosClientes();
			itensTodosClientes = new ListDataModel<Clientes>(lista);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

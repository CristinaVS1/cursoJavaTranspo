package br.com.apex.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.apex.bean.Usuario;
import br.com.apex.bean.FabricaDAO;

@ManagedBean(name = "MBFabricaUser")
@ViewScoped

public class UsuarioBean {

	
	
	private ListDataModel<Usuario> itensTodosUsuarios;
	private Usuario usuario;

	public ListDataModel<Usuario> getItensTodosUsuarios() {
		return itensTodosUsuarios;
	}

	public void setItensTodosUsuarios(ListDataModel<Usuario> itensTodosUsuarios) {
		this.itensTodosUsuarios = itensTodosUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct

	public void prepararPesquisaUsuario() {

		try {
			FabricaDAO dao = new FabricaDAO();
			ArrayList<Usuario> lista1;
			lista1 = dao.listarTodosUsuario();
			itensTodosUsuarios = new ListDataModel<Usuario>(lista1);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	
	
}

package br.com.apex.classes;

public class Usuario extends Pessoa {

	protected String user;
	protected String password;
	protected Boolean superUser;

	public Boolean getSuperUser() {
		return superUser;
	}

	public void setSuperUser(Boolean superUser) {
		this.superUser = superUser;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public String toString() {
		String saida = nome + " - " + sobrenome + " - " + user + " - " + password + " - " + superUser ;
		return saida;
	}
	

}

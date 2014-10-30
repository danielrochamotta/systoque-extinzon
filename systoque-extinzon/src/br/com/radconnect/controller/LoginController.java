package br.com.radconnect.controller;

import java.io.Serializable;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import br.com.radconnect.daos.DaoUsuario;
import br.com.radconnect.entityBeans.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class LoginController implements Serializable{
	
	
	
	private Usuario usuario;
	private DaoUsuario dao;
	private String entradaNomeUsuario = "";
	private String entradaSenhaUsuario = "";
	
	@PostConstruct
	public void init(){
		
		usuario = new Usuario();
		dao =new DaoUsuario();
		
	}
	
	public String paginadeLogin(){
		return "login";
	}
	
	//METODOS DE DIRECIONAMENTO DE PAGINAS
	public String paginaLogin(){
		return "login";
	}
	
	public String login(){
		usuario = dao.validaUsuario(entradaNomeUsuario, entradaSenhaUsuario);
		if(usuario != null){			
			return "home";
		}else{
			return "login";
		}
	}
	public String logOut(){
		usuario = null;
		
		return "login";
	}
	
	
	//GETTERS E SETTERS
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public DaoUsuario getDao() {
		return dao;
	}

	public void setDao(DaoUsuario dao) {
		this.dao = dao;
	}

	public String getEntradaNomeUsuario() {
		return entradaNomeUsuario;
	}

	public void setEntradaNomeUsuario(String entradaNomeUsuario) {
		this.entradaNomeUsuario = entradaNomeUsuario;
	}

	public String getEntradaSenhaUsuario() {
		return entradaSenhaUsuario;
	}

	public void setEntradaSenhaUsuario(String entradaSenhaUsuario) {
		this.entradaSenhaUsuario = entradaSenhaUsuario;
	}
	
	
	

}

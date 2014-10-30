package br.com.radconnect.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.radconnect.daos.DaoUsuario;
import br.com.radconnect.entityBeans.Usuario;

@SuppressWarnings("serial")

@ConversationScoped
@Named
public class CadastroUsuarioController implements Serializable{
	
	private Usuario usuario;
	private DaoUsuario dao;
	
	@Inject
	Conversation conversation;
	
	@PostConstruct
	public void init(){
		usuario = new Usuario();
		dao = new DaoUsuario();
	}
	//METODOS DE DIRECIONAMENTO DE PAGINAS
	public String paginaListUsuario(){
		conversation.begin();
		return "listuser";
	}
	public String paginaEditUsuario(){
		return "edituser";
	}
	public String paginaNovoUsuario(){
		init();
		return "novouser";
		
	}
	public String paginaMenuPrincipal(){
		conversation.end();
		return "menu";
	}
	public String voltarListUsuario(){
		init();
		return "listuser";
	}
	//FIM DOS METODOS DE DIRECIONAMENTO DE PAGINAS
	
	//METODOS DE PERSISTENCIA
	public String persistirUsuario(){
		dao.persistirUsuario(usuario);
		return "listuser";
	}
	public void removerUsuario(){
		dao.removerUsuario(usuario);
	}
	//FIM DOS METODOS DE PERSISTENCIA
	
	//METODOS DE LISTAGEM
	public List<Usuario> listUsuario(){
		return dao.listUsuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}

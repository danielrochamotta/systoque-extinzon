package br.com.radconnect.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.radconnect.entityBeans.Usuario;

@SuppressWarnings("serial")

@ConversationScoped
@Named
public class CadastroUsuarioController implements Serializable{
	
	private Usuario usuario = new Usuario();
	
	@Inject
	Conversation conversation;
	
	@PostConstruct
	public void inicalizaController(){
		conversation.begin();
	}
	
	public String getListUsuario(){
		return "listuser";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}

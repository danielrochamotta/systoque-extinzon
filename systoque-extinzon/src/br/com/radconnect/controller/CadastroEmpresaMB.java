package br.com.radconnect.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.radconnect.daos.DaoSetor;
import br.com.radconnect.entityBeans.Cargo;
import br.com.radconnect.entityBeans.Setor;

import java.io.Serializable;
import java.util.List;

@Named
@ConversationScoped
public class CadastroEmpresaMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DaoSetor daoSetor;
	
	private Cargo doSetor;
	
	private Boolean addCargo = false;
	
	private Setor setor;
	
	@Inject
	Conversation conversation;
	
	@PostConstruct
	public void incializaCadastroEmpresaMB(){
		daoSetor = new DaoSetor();
		conversation.begin();
		
	}
	/*METODOS DE CADASTRO SETOR
	 * INICIO
	 */
	public String novoSetor(){
		setor = new Setor();
		doSetor = new Cargo();
		return "formsetor";
	}
	public String localizarSetor(){
		conversation.end();
		return "listsetor";
	}
	public List<Setor> getListarSetor(){
		return daoSetor.listSetor();
	}
	public String editSetor(){
		
		return "formeditsetor?faces-redirect=true";
	}
	public void removerSetor(){
		daoSetor.removerSetor(setor);
	}
	public String gravarSetor(){
		daoSetor.gravarSetor(setor);
		addCargo = false;
		conversation.end();
		return "listsetor?faces-redirect=true";
	}
	public String editarSetor(){
		daoSetor.editarSetor(setor);
		addCargo = false;
		conversation.end();
		
		return "listsetor?faces-redirect=true";
	}
	public String cancelaCadastro(){
		conversation.end();
		return "listsetor?faces-redirect=true";
	}
	public String paginaHome(){
		return "home";
	}
	/*
	 * FIM DOS METODOS CADASTRO SETOR
	 */
	
	/*METODOS CADASTRO CARGOS
	 * INICIO
	 */
	public void adicionaCargoDoSetor(){
		
		setor.adicionaCargo(doSetor);
		doSetor = new Cargo();
		
	
	}
	public void removeCargoDoSetor(){
		
		setor.removeCargo(doSetor);
		
		doSetor = new Cargo();
	}
	public void ativaFormCargo(){
		addCargo = true;
	}	
	public void desativaFormCargo(){
		addCargo = false;
	}
	/*FIM DOS METODOS CADSTRO CARGOS
	 * 	
	 */
	
	
	/*
	 * GETTERS E SETTERS
	 */
	public Setor getSetor() {
		if(setor == null){
			setor = new Setor();
		}
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public Boolean getAddCargo() {
		return addCargo;
	}
	public void setAddCargo(Boolean addCargo) {
		this.addCargo = addCargo;
	}
	public Cargo getDoSetor() {
		if(doSetor == null){
			doSetor = new Cargo();
		}
		return doSetor;
	}
	public void setDoSetor(Cargo doSetor) {
		this.doSetor = doSetor;
	}
	
	
	
}

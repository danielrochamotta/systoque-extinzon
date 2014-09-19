package br.com.radconnect.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.radconnect.daos.DaoEstoque;
import br.com.radconnect.entityBeans.EntradaDeEstoque;
import br.com.radconnect.entityBeans.Item;
import br.com.radconnect.entityBeans.ItemEntrada;

@SuppressWarnings("serial")
@Named
@ConversationScoped
public class CadastroEstoqueController implements Serializable{

	@Inject
	Conversation conversation;
	
	private Item item;
	private EntradaDeEstoque entrada;
	private ItemEntrada entradaDeItens;
	private DaoEstoque dao;
	
	@PostConstruct
	public void inicializarEstoque(){
		conversation.begin();
		dao = new DaoEstoque();
	}

	//METODOS DE PERSISTENCIA
	public String persistirItem(){
		dao.persistirItem(item);
		return "listitem?faces-redirect=true";
	}
	
	//FIM DOS METODOS DE PERSISTENCIA
	
	//METODOS DE DIRECIONAMENTO DE PAGINAS
	public String novaEntrada(){
		return "novoitem";
	}
	public String editEntrada(){
		return "edititem";
	}
	public String irParaHome(){
		return "home";
	}
	//FIM DOS METODOS DE DIRECIONAMENTO DE PAGINAS
	
	//METODOS DE LISTAGEM E PROCURA
	public List<Item> listItens(){
		return dao.listItens(null, null);
	}
	
	public List<ItemEntrada> listEntradaDeItens(){
		return dao.procurarItensEntrada(null, null);
	}

	public Item getItem() {
		if(item == null){
			item = new Item();
		}
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public EntradaDeEstoque getEntrada() {
		if(entrada == null){
			entrada = new EntradaDeEstoque();
		}
		return entrada;
	}

	public void setEntrada(EntradaDeEstoque entrada) {
		this.entrada = entrada;
	}

	public ItemEntrada getEntradaDeItens() {
		if(entradaDeItens == null){
			entradaDeItens = new ItemEntrada();
		}
		return entradaDeItens;
	}

	public void setEntradaDeItens(ItemEntrada entradaDeItens) {
		this.entradaDeItens = entradaDeItens;
	}
	
	
	
}

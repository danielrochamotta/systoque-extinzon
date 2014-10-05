package br.com.radconnect.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.radconnect.daos.DaoEstoque;
import br.com.radconnect.daos.DaoGrupoDoItem;
import br.com.radconnect.entityBeans.EntradaDeEstoque;
import br.com.radconnect.entityBeans.GrupoDoItem;
import br.com.radconnect.entityBeans.Item;
import br.com.radconnect.entityBeans.ItemEntrada;
import br.com.radconnect.entityBeans.SubGrupoN1DoGrupo;
import br.com.radconnect.entityBeans.SubGrupoN2DoN1;
import br.com.radconnect.entityBeans.SubGrupoN3DoN2;
import br.com.radconnect.entityBeans.SubGrupoN4DoN3;
import br.com.radconnect.entityBeans.SubGrupoN5DoN4;


@SuppressWarnings("serial")
@Named
@ConversationScoped
public class CadastroEstoqueController implements Serializable{


	
	private Item item;
	private EntradaDeEstoque entrada;
	private ItemEntrada entradaDeItens;
	private DaoEstoque daoEstoque;
	private DaoGrupoDoItem daoGrupo;
	
	
	//VARIAVEIS DA TELA DE CATEGORIA DO ITEM
	private Boolean categoriaN1 = false;
	private Boolean categoriaN2 = false;
	private Boolean categoriaN3 = false;
	private Boolean categoriaN4 = false;
	private Boolean categoriaN5 = false;
	
	public void verificaExistenciaDeCategorias(){
		if(item.getGrupo() != null){
			categoriaN1 = true;
		}else{
			categoriaN1 = false;
		}
		if(item.getSubGrupoN1() != null){
			categoriaN2 = true;
		}else{
			categoriaN2 = false;
		}
		if(item.getSubGrupoN3() != null){
			categoriaN3 = true;
		}else{
			categoriaN3 = false;
		}
		if(item.getSubGrupoN4() != null){
			categoriaN4 = true;
		}else{
			categoriaN4 = false;
		}
		if(item.getSubGrupoN5() != null){
			categoriaN5 = true;
		}else{
			categoriaN5 = false;
		}
	}
	
	@PostConstruct
	public void inicializarEstoque(){
		
		daoEstoque = new DaoEstoque();
		daoGrupo = new DaoGrupoDoItem();
	}

	//METODOS DE PERSISTENCIA
	public String persistirItem(){
		
		daoEstoque.persistirItem(item);
		return "listitem";
	}
	
	//FIM DOS METODOS DE PERSISTENCIA
	
	//METODOS DE DIRECIONAMENTO DE PAGINAS
	public String novoItem(){
		return "novoitem";
	}
	public String paginaEditItem(){
		return "edititem";
	}
	public String paginaMenuPrincipal(){
		return "menu";
	}
	
	public String paginaListItem(){
		return "listitem";
	}
	
	public String paginaListEntradaDeItens(){
		return "listentrada";
	}
	//FIM DOS METODOS DE DIRECIONAMENTO DE PAGINAS
	
	//METODOS DE LISTAGEM E PROCURA
	public List<Item> listItens(){
		return daoEstoque.listItens(null, null);
	}
	
	public List<ItemEntrada> listEntradaDeItens(){
		return daoEstoque.listItensEntrada();
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

	

	public Boolean getCategoriaN1() {
		return categoriaN1;
	}

	public void setCategoriaN1(Boolean categoriaN1) {
		this.categoriaN1 = categoriaN1;
	}

	public Boolean getCategoriaN2() {
		return categoriaN2;
	}

	public void setCategoriaN2(Boolean categoriaN2) {
		this.categoriaN2 = categoriaN2;
	}

	public Boolean getCategoriaN3() {
		return categoriaN3;
	}

	public void setCategoriaN3(Boolean categoriaN3) {
		this.categoriaN3 = categoriaN3;
	}

	public Boolean getCategoriaN4() {
		return categoriaN4;
	}

	public void setCategoriaN4(Boolean categoriaN4) {
		this.categoriaN4 = categoriaN4;
	}

	public Boolean getCategoriaN5() {
		return categoriaN5;
	}

	public void setCategoriaN5(Boolean categoriaN5) {
		this.categoriaN5 = categoriaN5;
	}

	

	public DaoGrupoDoItem getDaoGrupo() {
		return daoGrupo;
	}

	public void setDaoGrupo(DaoGrupoDoItem daoGrupo) {
		this.daoGrupo = daoGrupo;
	}
	
	
	
	
}

package br.com.radconnect.controller;

import java.io.Serializable;
import java.util.ArrayList;
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

	@Inject
	Conversation conversation;

	
	private Item item;
	private EntradaDeEstoque entrada;
	private ItemEntrada entradaDeItens;
	private DaoEstoque daoEstoque;
	private DaoGrupoDoItem daoGrupo;
	private GrupoDoItem grupoTemp;
	List<GrupoDoItem> listGrupoDoBanco = new ArrayList<GrupoDoItem>();
	private SubGrupoN1DoGrupo sub1Temp;
	private SubGrupoN2DoN1 sub2Temp;
	private SubGrupoN3DoN2 sub3Temp;
	private SubGrupoN4DoN3 sub4Temp;
	private SubGrupoN5DoN4 sub5Temp;
	
	
	
	//VARIAVEIS DA TELA DE CATEGORIA DO ITEM
	private Boolean categoriaN1 = true;
	private Boolean categoriaN2 = true;
	private Boolean categoriaN3 = true;
	private Boolean categoriaN4 = true;
	private Boolean categoriaN5 = true;
	
	public List<GrupoDoItem> listGrupo(){
		listGrupoDoBanco = daoGrupo.procurarGrupo(null, null);
		
		return listGrupoDoBanco;
	}
	
	@PostConstruct
	public void inicializarEstoque(){
		conversation.begin();
		daoEstoque = new DaoEstoque();
		daoGrupo = new DaoGrupoDoItem();
		
        grupoTemp = new GrupoDoItem();
		
		sub1Temp = new SubGrupoN1DoGrupo();
		sub2Temp = new SubGrupoN2DoN1();
		sub3Temp = new SubGrupoN3DoN2();
		sub4Temp = new SubGrupoN4DoN3();
		sub5Temp = new SubGrupoN5DoN4();
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
		conversation.end();
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
	public GrupoDoItem retornaGrupoDoId(Long id){
		return daoGrupo.retornaGrupo(id);
	}
	
	
	//FIM DE METODOS DE LISTAGEM E PROCURA

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

	public GrupoDoItem getGrupoTemp() {
		if(grupoTemp ==  null){
			grupoTemp = new GrupoDoItem();			
		}
		return grupoTemp;
	}

	public void setGrupoTemp(GrupoDoItem grupoTemp) {
		this.grupoTemp = grupoTemp;
	}

	public SubGrupoN1DoGrupo getSub1Temp() {
		return sub1Temp;
	}

	public void setSub1Temp(SubGrupoN1DoGrupo sub1Temp) {
		this.sub1Temp = sub1Temp;
	}

	public SubGrupoN2DoN1 getSub2Temp() {
		return sub2Temp;
	}

	public void setSub2Temp(SubGrupoN2DoN1 sub2Temp) {
		this.sub2Temp = sub2Temp;
	}

	public SubGrupoN3DoN2 getSub3Temp() {
		return sub3Temp;
	}

	public void setSub3Temp(SubGrupoN3DoN2 sub3Temp) {
		this.sub3Temp = sub3Temp;
	}

	public SubGrupoN4DoN3 getSub4Temp() {
		return sub4Temp;
	}

	public void setSub4Temp(SubGrupoN4DoN3 sub4Temp) {
		this.sub4Temp = sub4Temp;
	}

	public SubGrupoN5DoN4 getSub5Temp() {
		return sub5Temp;
	}

	public void setSub5Temp(SubGrupoN5DoN4 sub5Temp) {
		this.sub5Temp = sub5Temp;
	}

	public List<GrupoDoItem> getListGrupoDoBanco() {
		return listGrupoDoBanco;
	}

	public void setListGrupoDoBanco(List<GrupoDoItem> listGrupoDoBanco) {
		this.listGrupoDoBanco = listGrupoDoBanco;
	}
	

	
	
	
	
}

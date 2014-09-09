package br.com.radconnect.entityBeans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@SuppressWarnings("serial")
@Entity
@Table(name = "ITEM_ENTRADA")
public class ItemEntrada implements Serializable{
	@Id
	@SequenceGenerator(name = "SEQ_ITEM_ENTRADA",sequenceName = "SEQ_ITEM_ENTRADA_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_ITEM_ENTRADA")
	private Long id;
	
	@Column(name = "VALOR_ITEM_ENTRADA")
	@Index(name = "IDX_VALOR_ITEM_ENTRADA")
	private Double valorDoItem;
	
	@Column(name = "QTD_ITENS_ENTRADA")
	@Index(name = "IDX_QTD_ITENS_ENTRADA")
	private Integer qtdDeItens;
	
	@Column(name = "NUMERO_LOTE_ITEM_ENTRADA")
	@Index(name = "IDX_NUMERO_LOTE_ITEM_ENTRADA")
	private Long numeroDoLote;
	
	
	//ATRIBUTOS RELACIONAIS
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "ID_ITEM")
	private Item item = new Item();
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "ID_ENTRADA")
	private EntradaDeEstoque entrada = new EntradaDeEstoque();
	
	//GETTERS E SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getValorDoItem() {
		return valorDoItem;
	}
	public void setValorDoItem(Double valorDoItem) {
		this.valorDoItem = valorDoItem;
	}
	public Integer getQtdDeItens() {
		return qtdDeItens;
	}
	public void setQtdDeItens(Integer qtdDeItens) {
		this.qtdDeItens = qtdDeItens;
	}
	public Long getNumeroDoLote() {
		return numeroDoLote;
	}
	public void setNumeroDoLote(Long numeroDoLote) {
		this.numeroDoLote = numeroDoLote;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public EntradaDeEstoque getEntrada() {
		return entrada;
	}
	public void setEntrada(EntradaDeEstoque entrada) {
		this.entrada = entrada;
	}
	
	
	
	

}

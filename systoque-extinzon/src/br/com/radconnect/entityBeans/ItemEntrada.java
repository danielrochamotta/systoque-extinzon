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
	
	@Column(name = "VALOR_UNITARIO_ITEM_ENTRADA")
	@Index(name = "IDX_VALOR_ITEM_ENTRADA")
	private Double valorUnitarioDoItem;
	
	@Column(name = "QTD_ITEM_ENTRADA")
	@Index(name = "IDX_QTD_ITENS_ENTRADA")
	private Double qtdDeItens;
	
	@Column (name = "VALOR_FRETE_ITEM_ENTRADA")
	@Index(name = "IDX_VALOR_FRETE_ITEM_ENTRADA")
	private Double valorDoFrete;
	
	@Column(name = "VALOR_IPI_ITEM_ENTRADA")
	@Index(name = "IDX_VALOR_IPI_ITEM_ENTRADA")
	private Double valorIPI;
	
	@Column(name = "VALOR_ICMS_ITEM_ENTRADA")
	@Index(name = "IDX_VALOR_ICMS_ITEM_ENTRADA")
	private Double valorICMS;
	
	@Column(name = "VALOR_DESPESAS_EXTRAS_ITEM_ENTRADA")
	@Index(name = "IDX_VALOR_DESPESAS_EXTRAS_ITEM_ENTRADA")
	private Double valorDespesasExtras;
	
	@Column(name = "VALOR_DE_DESCONTOS_ITEM_ENTRADA")
	@Index(name = "IDX_VALOR_DE_DESCONTOS_ITEM_ENTRADA")
	private Double valorDeDescontos;
	
	
	//ATRIBUTOS RELACIONAIS
	@ManyToOne
	@JoinColumn(name = "ID_ITEM")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = "ID_ENTRADA",referencedColumnName = "ID")
	private EntradaDeEstoque entrada;
	
	//GETTERS E SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Double getValorUnitarioDoItem() {
		return valorUnitarioDoItem;
	}
	public void setValorUnitarioDoItem(Double valorUnitarioDoItem) {
		this.valorUnitarioDoItem = valorUnitarioDoItem;
	}
	public Double getQtdDeItens() {
		return qtdDeItens;
	}
	public void setQtdDeItens(Double qtdDeItens) {
		this.qtdDeItens = qtdDeItens;
	}
	public Double getValorDoFrete() {
		return valorDoFrete;
	}
	public void setValorDoFrete(Double valorDoFrete) {
		this.valorDoFrete = valorDoFrete;
	}
	public Double getValorIPI() {
		return valorIPI;
	}
	public void setValorIPI(Double valorIPI) {
		this.valorIPI = valorIPI;
	}
	public Double getValorICMS() {
		return valorICMS;
	}
	public void setValorICMS(Double valorICMS) {
		this.valorICMS = valorICMS;
	}
	public Double getValorDespesasExtras() {
		return valorDespesasExtras;
	}
	public void setValorDespesasExtras(Double valorDespesasExtras) {
		this.valorDespesasExtras = valorDespesasExtras;
	}
	public Double getValorDeDescontos() {
		return valorDeDescontos;
	}
	public void setValorDeDescontos(Double valorDeDescontos) {
		this.valorDeDescontos = valorDeDescontos;
	}
	
	
	
	

}

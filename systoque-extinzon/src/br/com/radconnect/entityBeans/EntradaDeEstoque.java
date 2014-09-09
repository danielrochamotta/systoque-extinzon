package br.com.radconnect.entityBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@SuppressWarnings("serial")
@Entity
@Table(name = "ENTRADA_ESTOQUE")
public class EntradaDeEstoque implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_ENTRADA_ESTOQUE", sequenceName = "SEQ_ENTRADA_ESTOQUE_ID",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_ENTRADA_ESTOQUE")
	private Long id;
	
	@Column(name = "TOTAL_COMPRA_ENTRADA_ESTOQUE")
	@Index(name = "IDX_TOTAL_COMPRA_ENTRADA_ESTOQUE")
	private Double totalDaCompra;
	
	@Column(name = "DATA__PEDIDO_ENTRADA_ESTOQUE")
	@Index(name = "IDX_DATA_PEDIDO_ESTOQUE")
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	
	@Column(name = "DATA_ENTRADA_ESTOQUE")
	@Index(name = "IDX_DATA_ENTRADA_ESTOQUE")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name = "VALOR_FRETE_ENTRADA_ESTOQUE")
	@Index(name = "IDX_VALOR_FRETE_ENTRADA_ESTOQUE")
	private Double valorFrete;
	
	//ATRIBUTOS RELACIONAIS
	@OneToOne(mappedBy = "entrada")
	private ItemEntrada itemEntrada;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntradaDeEstoque other = (EntradaDeEstoque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	//GETTERS E SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getTotalDaCompra() {
		return totalDaCompra;
	}
	public void setTotalDaCompra(Double totalDaCompra) {
		this.totalDaCompra = totalDaCompra;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}
	public ItemEntrada getItemEntrada() {
		return itemEntrada;
	}
	public void setItemEntrada(ItemEntrada itemEntrada) {
		this.itemEntrada = itemEntrada;
	}
	


}

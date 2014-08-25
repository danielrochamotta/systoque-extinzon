package br.com.radconnect.entityBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Daniel Rocha
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ITEM")
public class Item implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_ITEM",sequenceName = "SEQ_ITEM_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_ITEM")
	private Long id;
	
	@Index(name = "IDX_CODIGO_BARRA_ITEM")
	private String codigoDeBarra;
	
	@Index(name = "IDX_GTIN_EAN_ITEM")
	private String gtinEan;	
	
	@Index(name = "IDX_NUMERO_FABRICANTE_ITEM")
	private String numeroFabricante;
	
	@Index(name = "IDX_NOME_ITEM")
	private String nome;
	
	@Index(name = "IDX_NOME_CURTO_ITEM")
	private String nomeCurto;	
	
	@Index(name = "IDX_MARCA_FABRICANTE_ITEM")
	private String marcaFabricante;
	
	@Index(name = "IDX_QTD_IDEAL_ITEM")
	private Double qtdIdeal;
	
	@Index(name = "IDX_QTD_MINIMO_ITEM")
	private Double qtdMinimo;
	
	
	//ATRIBUTOS RELACIONAIS
	
	
	
	
	//HASHCODE
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
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}//FIM HASHCODE
	
	//TOSTRING
	@Override
	public String toString() {
		return "Item [nome=" + nome + "]";
	}//FIM TOSTRING
	
	//INICIO GETTERS E SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigoDeBarra() {
		return codigoDeBarra;
	}
	public void setCodigoDeBarra(String codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}
	public String getGtinEan() {
		return gtinEan;
	}
	public void setGtinEan(String gtinEan) {
		this.gtinEan = gtinEan;
	}
	public String getNumeroFabricante() {
		return numeroFabricante;
	}
	public void setNumeroFabricante(String numeroFabricante) {
		this.numeroFabricante = numeroFabricante;
	}
	public String getNomeIten() {
		return nome;
	}
	public void setNomeIten(String nomeItem) {
		this.nome = nomeItem;
	}
	public String getNomeCurto() {
		return nomeCurto;
	}
	public void setNomeCurto(String nomeCurto) {
		this.nomeCurto = nomeCurto;
	}
	
	public String getMarcaFabricante() {
		return marcaFabricante;
	}
	public void setMarcaFabricante(String marcaFabricante) {
		this.marcaFabricante = marcaFabricante;
	}
	public String getNomeItem() {
		return nome;
	}
	public void setNomeItem(String nomeItem) {
		this.nome = nomeItem;
	}
	public Double getQtdIdeal() {
		return qtdIdeal;
	}
	public void setQtdIdeal(Double qtdIdeal) {
		this.qtdIdeal = qtdIdeal;
	}
	public Double getQtdMinimo() {
		return qtdMinimo;
	}
	public void setQtdMinimo(Double qtdMinimo) {
		this.qtdMinimo = qtdMinimo;
	}
	
	
	//FIM GETTERS E SETTERS
	
	
	
	

	
	

}

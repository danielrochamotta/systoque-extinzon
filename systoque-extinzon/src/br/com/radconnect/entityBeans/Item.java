package br.com.radconnect.entityBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@Column(name = "CODIGO_BARRA_ITEM")
	@Index(name = "IDX_CODIGO_BARRA_ITEM")
	private String codigoDeBarra;
	
	@Column(name = "CODIGO_ITEM")
	private String codigo;
	
	@Column(name = "GETIN_EAN_ITEM")
	@Index(name = "IDX_GTIN_EAN_ITEM")
	private String gtinEan;	
	
	@Column(name = "NUMERO_FABRICANTE_ITEM")
	@Index(name = "IDX_NUMERO_FABRICANTE_ITEM")
	private String numeroFabricante;
	
	@Column(name = "NOME_ITEM")
	@Index(name = "IDX_NOME_ITEM")
	private String nome;
	
	@Column(name = "NOME_CURTO_ITEM")
	@Index(name = "IDX_NOME_CURTO_ITEM")
	private String nomeCurto;	
	
	@Column(name = "MARCA_FABRICANTE_ITEM")
	@Index(name = "IDX_MARCA_FABRICANTE_ITEM")
	private String marcaFabricante;
	
	@Column(name = "QTD_DISPONIVEL_ITEM")
	@Index(name = "IDX_QTD_DISPONIVEL_ITEM")
	private Double qtdDisponivel;
	
	@Column(name = "QTD_IDEAL_ITEM")
	@Index(name = "IDX_QTD_IDEAL_ITEM")
	private Double qtdIdeal;
	
	@Column(name = "QTD_MINIMO_ITEM")
	@Index(name = "IDX_QTD_MINIMO_ITEM")
	private Double qtdMinimo;
	
	
	//ATRIBUTOS RELACIONAIS
	
	@OneToMany(mappedBy = "item",cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<ItemEntrada> listItemEntrada = new ArrayList<ItemEntrada>();
	
	@ManyToOne
	@JoinColumn(name = "ID_GRUPO")
	private GrupoDoItem grupo;
	
	@ManyToOne
	@JoinColumn(name = "ID_LOCALIZACAO",referencedColumnName = "ID")
	private LocalizacaoItem localizacao;
	
	
	
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public GrupoDoItem getGrupo() {
		return grupo;
	}
	public void setGrupo(GrupoDoItem grupo) {
		this.grupo = grupo;
	}
	public Double getQtdDisponivel() {
		return qtdDisponivel;
	}
	public void setQtdDisponivel(Double qtdDisponivel) {
		this.qtdDisponivel = qtdDisponivel;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public List<ItemEntrada> getListItemEntrada() {
		return listItemEntrada;
	}
	public void setListItemEntrada(List<ItemEntrada> listItemEntrada) {
		this.listItemEntrada = listItemEntrada;
	}
	public LocalizacaoItem getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(LocalizacaoItem localizacao) {
		this.localizacao = localizacao;
	}
	
	
	//FIM GETTERS E SETTERS
	
	
	
	

	
	

}

package br.com.radconnect.entityBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Daniel Rocha
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ITEN")
public class Iten implements Serializable{
	
	@Id
	private Long id;
	private String codigoDeBarra;	
	private String gtinEan;	
	private String numeroFabricante;
	private String nomeIten;
	private String nomeCurto;
	private String grupo;
	private String subGrupo;
	private String marcaFabricante;
	private String unidadeMedida;
	
	//ATRIBUTOS RELACIONAIS
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "iten", orphanRemoval=true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<ItenDoFornecedor> listItenDoFornecedor = new ArrayList<ItenDoFornecedor>();
	
	
	
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
		Iten other = (Iten) obj;
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
		return "Iten [nomeIten=" + nomeIten + "]";
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
		return nomeIten;
	}
	public void setNomeIten(String nomeIten) {
		this.nomeIten = nomeIten;
	}
	public String getNomeCurto() {
		return nomeCurto;
	}
	public void setNomeCurto(String nomeCurto) {
		this.nomeCurto = nomeCurto;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getSubGrupo() {
		return subGrupo;
	}
	public void setSubGrupo(String subGrupo) {
		this.subGrupo = subGrupo;
	}
	public String getMarcaFabricante() {
		return marcaFabricante;
	}
	public void setMarcaFabricante(String marcaFabricante) {
		this.marcaFabricante = marcaFabricante;
	}
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}//FIM GETTERS E SETTERS
	
	
	
	

	
	

}

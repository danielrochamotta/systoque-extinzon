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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@SuppressWarnings("serial")
@Entity
@Table(name = "SUBLOCALIZACAO_ITEM_01")
public class SubLocalizacaoItem01 implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_SUBLOCALIZACAO_ITEM_01",
	sequenceName = "SEQ_SUBLOCALIZACAO_ITEM_01_ID",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SUBLOCALIZACAO_ITEM_01")
	private Long id;
	
	@Column(name = "NOME_SUBLOCALIZACAO_ITEM_01")
	@Index(name = "IDX_NOME_SUBLOCALIZACAO_ITEM_01")
	private String nome;
	
	//ATRIBUTOS RELACIONAIS
	@ManyToOne
	@JoinColumn(name = "ID_LOCALIZACAO",referencedColumnName = "ÏD")
	private LocalizacaoItem localizacao;
	
	@OneToMany(mappedBy = "subLocalizacao01",cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<SubLocalizacaoItem02> listSublocalizacaoItem02 = new ArrayList<SubLocalizacaoItem02>();
	
	
	
	
	//TOSTRING
	@Override
	public String toString() {
		return "SubLocalizacaoItem01 [nome=" + nome + "]";
	}//FIM DO TOSTRING
	
	
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
		SubLocalizacaoItem01 other = (SubLocalizacaoItem01) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}//FIM DO HASHCODE
	
	//GETTERS E SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	public LocalizacaoItem getLocalizacao() {
		return localizacao;
	}


	public void setLocalizacao(LocalizacaoItem localizacao) {
		this.localizacao = localizacao;
	}
	
	

}

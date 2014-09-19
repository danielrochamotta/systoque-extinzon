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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@SuppressWarnings("serial")
@Entity
@Table(name = "LOCALIZACAO_ITEM")
public class LocalizacaoItem implements Serializable{
	@Id
	@SequenceGenerator(name = "SEQ_LOCALIZACAO_ITEM",sequenceName = "SEQ_LOCALIZACAO_ITEM_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOCALIZACAO_ITEM")	
	private Long id;
	
	@Column(name = "NOME_LOCALIZACAO_ITEM")
	@Index(name = "IDX_NOME_LOCALIZACAO_ITEM")
	private String nome;
	
	
	//ATRIBUTOS RELACIONAIS
	@OneToMany(mappedBy = "localizacao",cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<SubLocalizacaoItem01> listSubLocalizacao01 = new ArrayList<SubLocalizacaoItem01>();
	
	@OneToMany(mappedBy = "localizacao",cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<Item> listItens = new ArrayList<Item>();
	
	//FIM DOS ATRIBUTOS RELACIONAIS
	
	//METODOS PARA ADICIONAR E REMOVER OBJETOS DA LISTA DE SUBLOCALIZACAO DE ITEM 01
	
	public void adicionaSubLocalizacao01(SubLocalizacaoItem01 subLocalizacao01){
		subLocalizacao01.setLocalizacao(this);
	this.listSubLocalizacao01.add(subLocalizacao01);
		
	}
	
	public void removerSubLocalizacao01(SubLocalizacaoItem01 sublocalizacao01){
		if(this.listSubLocalizacao01.contains(sublocalizacao01)){
			this.listSubLocalizacao01.remove(sublocalizacao01);
		}
		
	}
	//FIM DOS METODS ADD E REMOVE
	//TOSTRING
	@Override
	public String toString() {
		return "LocalizacaoItem [nome=" + nome + "]";
	}//FIM TOSTRING
	
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
		LocalizacaoItem other = (LocalizacaoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}//FIM HASHCODE
	
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

	
	
	

}

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
@Table(name = "SUBLOCALIZACAO_ITEM_02")
public class SubLocalizacaoItem02 implements Serializable{
	@Id
	@SequenceGenerator(name = "SEQ_SUBLOCALIZACAO_ITEM_02",
	sequenceName = "SEQ_SUBLOCALIZAO_ITEM_02_ID",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_SUBLOCALIZACAO_ITEM_02")
	private Long id;
	
	@Column(name = "NOME_SUBLOCALIZACAO_ITEM_02")
	@Index(name = "IDX_SUBLOCALIZACAO_ITEM_02")
	private String nome;
	
	//ATRIBUTOS RELACIONAIS
	@ManyToOne
	@JoinColumn(name = "ÏD_SUBLOCALIZACAO_ITEM_01",referencedColumnName = "ID")
	private SubLocalizacaoItem01 subLocalizacao01;
	
	@OneToMany(mappedBy = "sublocalizacao02",cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<SubLocalizacaoItem03> listSublocalizacaoItem03 = new ArrayList<SubLocalizacaoItem03>();
	
	
	//METODOS PARA ADICIONAR E REMOVER OBJETOS DA LISTA DE SUBLOCALIZACAO DE ITEM 03
			public void adicionaSubLocalizacao03(SubLocalizacaoItem03 subLocalizacao03){
				subLocalizacao03.setSublocalizacao02(this);
			this.listSublocalizacaoItem03.add(subLocalizacao03);
				
			}
			
			public void removerSubLocalizacao03(SubLocalizacaoItem03 sublocalizacao03){
				if(this.listSublocalizacaoItem03.contains(sublocalizacao03)){
					this.listSublocalizacaoItem03.remove(sublocalizacao03);
				}
			}//FIM DOS METODS ADD E REMOVE
	
	//TOSTRING 
	@Override
	public String toString() {
		return "SubLocalizacaoItem02 [nome=" + nome + "]";
	}
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
		SubLocalizacaoItem02 other = (SubLocalizacaoItem02) obj;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public SubLocalizacaoItem01 getSubLocalizacao01() {
		return subLocalizacao01;
	}
	public void setSubLocalizacao01(SubLocalizacaoItem01 subLocalizacao01) {
		this.subLocalizacao01 = subLocalizacao01;
	}

	public List<SubLocalizacaoItem03> getListSublocalizacaoItem03() {
		return listSublocalizacaoItem03;
	}

	public void setListSublocalizacaoItem03(
			List<SubLocalizacaoItem03> listSublocalizacaoItem03) {
		this.listSublocalizacaoItem03 = listSublocalizacaoItem03;
	}
	
	

}

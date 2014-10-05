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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@SuppressWarnings("serial")
@Entity
@Table(name = "GRUPO_DO_ITEM")
public class GrupoDoItem implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_GRUPO_DO_ITEM", sequenceName = "SEQ_GRUPO_DO_ITEM_ID",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRUPO_DO_ITEM")
	private Long id;
	
	@Column(name = "NOME_GRUPO_DO_ITEM")
	@Index(name = "IDX_NOME_GRUPO_DO_ITEM")
	private String nome;
	
	//ATRIBUTOS RELACIONAIS
	@OneToMany(mappedBy = "grupo",cascade = {CascadeType.ALL},orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<SubGrupoN1DoGrupo> listSubGrupo = new ArrayList<SubGrupoN1DoGrupo>();
	
	
	@OneToMany(mappedBy = "grupo")
	private List<Item> listItens = new ArrayList<Item>();
	//FIM
	
	//METODOS DE ADICIONAR E REMOVER NA LISTA DE SUBGRUPOS N1
	public void adicionaSubGrupoN1(SubGrupoN1DoGrupo subGrupoN1){
		subGrupoN1.setGrupo(this);
		this.listSubGrupo.add(subGrupoN1);
	}
	
	public void removeSubGrupoN1(SubGrupoN1DoGrupo subGrupoN1){
		if(this.listSubGrupo.contains(subGrupoN1)){
			this.listSubGrupo.remove(subGrupoN1);
		}
	}
	//FIM
	
	//TOSTRING
	@Override
	public String toString() {
		return nome;
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
		GrupoDoItem other = (GrupoDoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	//GETTES E SETTERS
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
	public List<SubGrupoN1DoGrupo> getListSubGrupo() {
		return listSubGrupo;
	}
	public void setListSubGrupo(List<SubGrupoN1DoGrupo> listSubGrupo) {
		this.listSubGrupo = listSubGrupo;
	}
	

}

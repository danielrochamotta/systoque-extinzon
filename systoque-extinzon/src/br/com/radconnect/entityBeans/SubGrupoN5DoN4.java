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
@Table(name = "SUBGRUPO_N5_DO_N4")
public class SubGrupoN5DoN4 implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_SUBRGRUPO_N5_DO_N4",
	sequenceName = "SEQ_SUBGRUPO_N5_DO_N4",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_SUBRGRUPO_N5_DO_N4")
	private Long id;
	
	@Column(name = "NOME_SUBRGRUPO_N5_DO_N4")
	@Index(name = "IDX_NOME_SUBGRUPO_N5_DO_N4")
	private String nome;
	
	//ATRIBUTOS RELACIONAIS
	@ManyToOne
	@JoinColumn(name = "N4_ID",referencedColumnName = "ID")
	private SubGrupoN4DoN3 subGrupoN4;
	
	@OneToMany(mappedBy = "subGrupoN5",cascade = {CascadeType.ALL},orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<Item> listItem = new ArrayList<Item>();
	//FIM
	
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
		SubGrupoN5DoN4 other = (SubGrupoN5DoN4) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	//FIM
	
	//TOSTRING
	@Override
	public String toString() {
		return nome;
	}
	//FIM
	

	//GETTERS E SETTERS
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SubGrupoN4DoN3 getSubGrupoN4() {
		return subGrupoN4;
	}

	public void setSubGrupoN4(SubGrupoN4DoN3 subGrupoN4) {
		this.subGrupoN4 = subGrupoN4;
	}
	
	

		

}

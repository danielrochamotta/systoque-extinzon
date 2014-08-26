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
@Table(name = "SUBGRUPO_N4_DO_N3")
public class SubGrupoN4DoN3 implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_SUBRGRUPO_N4_DO_N3",
	sequenceName = "SEQ_SUBGRUPO_N4_DO_N3",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_SUBRGRUPO_N4_DO_N3")
	private Long id;
	
	@Column(name = "NOME_SUBRGRUPO_N4_DO_N3")
	@Index(name = "IDX_NOME_SUBGRUPO_N4_DO_N3")
	private String nome;
	
	//ATRIBUTOS RELACIONAIS
	@ManyToOne
	@JoinColumn(name = "N3_ID",referencedColumnName = "ID")
	private SubGrupoN3DoN2 subGrupoN3;
	
	@OneToMany(mappedBy = "subGrupoN4",cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<SubGrupoN5DoN4> listSubGrupoN5 = new ArrayList<SubGrupoN5DoN4>();
	//FIM
	
	//METODOS PARA ADICIONAR E REMOVER DA LISTA DE SUBGRUPON5
	public void adicionarSubGrupoN5(SubGrupoN5DoN4 subGrupoN5){
		subGrupoN5.setSubGrupoN4(this);
		this.listSubGrupoN5.add(subGrupoN5);
	}
	public void removerSubGrupoN5(SubGrupoN5DoN4 subGrupoN5){
		if(this.listSubGrupoN5.contains(subGrupoN5)){
			this.listSubGrupoN5.remove(subGrupoN5);
		}
	}
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
		SubGrupoN4DoN3 other = (SubGrupoN4DoN3) obj;
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
		return "SubGrupoN4DoN3 [nome=" + nome + "]";
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

	public SubGrupoN3DoN2 getSubGrupoN3() {
		return subGrupoN3;
	}

	public void setSubGrupoN3(SubGrupoN3DoN2 subGrupoN3) {
		this.subGrupoN3 = subGrupoN3;
	}	
	
	
	

}

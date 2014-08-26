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
@Table(name = "SUBGRUPO_N2_DO_N1")
public class SubGrupoN2DoN1 implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_SUBRGRUPO_N2_DO_N1",
	sequenceName = "SEQ_SUBGRUPO_N2_DO_N1",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_SUBRGRUPO_N2_DO_N1")
	private Long id;
	
	@Column(name = "NOME_SUBRGRUPO_N2_DO_N1")
	@Index(name = "IDX_NOME_SUBGRUPO_N2_DO_N1")
	private String nome;
	
	//ATRIBUTOS RELACIONAIS
	@ManyToOne
	@JoinColumn(name = "N1_ID",referencedColumnName = "ID")
	private SubGrupoN1DoGrupo subGrupoN1;
	
	@OneToMany(mappedBy = "subGrupoN2",cascade = {CascadeType.ALL},orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<SubGrupoN3DoN2> listSubGrupoN3 = new ArrayList<SubGrupoN3DoN2>();
	//FIM
	
	//METODOS DE ADICIONAR  E RMEOVER DA LISTA DE SUBGRUPON3
	public void adicionaSubGrupoN3(SubGrupoN3DoN2 subGrupoN3){
		subGrupoN3.setSubGrupoN2(this);
		this.listSubGrupoN3.add(subGrupoN3);
	}
	public void removeSubGrupoN3(SubGrupoN3DoN2 subGrupoN3){
		if(this.listSubGrupoN3.contains(subGrupoN3)){
			this.listSubGrupoN3.remove(subGrupoN3);
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
		SubGrupoN2DoN1 other = (SubGrupoN2DoN1) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
	//TOSTRING
	@Override
	public String toString() {
		return "SubGrupoN2DoN1 [nome=" + nome + "]";
	}
	//FIM
	
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

	public SubGrupoN1DoGrupo getSubGrupoN1() {
		return subGrupoN1;
	}

	public void setSubGrupoN1(SubGrupoN1DoGrupo subGrupoN1) {
		this.subGrupoN1 = subGrupoN1;
	}
	
	
	
	

}

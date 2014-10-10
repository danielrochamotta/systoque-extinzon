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
@Table(name = "SUBGRUPO_N3_DO_N2")
public class SubGrupoN3DoN2 implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_SUBRGRUPO_N3_DO_N2",
	sequenceName = "SEQ_SUBGRUPO_N3_DO_N2",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_SUBRGRUPO_N3_DO_N2")
	private Long id;
	
	@Column(name = "NOME_SUBRGRUPO_N3_DO_N2")
	@Index(name = "IDX_NOME_SUBGRUPO_N2_DO_N2")
	private String nome;
	
	//ATRIBUTOS RELACIONAIS
	@ManyToOne
	@JoinColumn(name = "N2_ID",referencedColumnName = "ID")
	private SubGrupoN2DoN1 subGrupoN2 = new SubGrupoN2DoN1();
	
	@OneToMany(mappedBy = "subGrupoN3",cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<SubGrupoN4DoN3> listSubGrupoN4 = new ArrayList<SubGrupoN4DoN3>();
	
	@OneToMany(mappedBy = "subGrupoN3",cascade = {CascadeType.ALL},orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<Item> listItem = new ArrayList<Item>();
	
	//FIM
	
	//METODOS PARA ADICIONAR E REMOVER DA LISTA DO SUBGRUPO N4
	public void adicionarSubGrupoN4(SubGrupoN4DoN3 subGrupoN4){
		subGrupoN4.setSubGrupoN3(this);
		this.listSubGrupoN4.add(subGrupoN4);
	}
	public void removerSubGrupoN4(SubGrupoN4DoN3 subGrupoN4){
		if(this.listSubGrupoN4.contains(subGrupoN4)){
			this.listSubGrupoN4.remove(subGrupoN4);
		}
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
		SubGrupoN3DoN2 other = (SubGrupoN3DoN2) obj;
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

	public SubGrupoN2DoN1 getSubGrupoN2() {
		return subGrupoN2;
	}

	public void setSubGrupoN2(SubGrupoN2DoN1 subGrupoN2) {
		this.subGrupoN2 = subGrupoN2;
	}
	public List<SubGrupoN4DoN3> getListSubGrupoN4() {
		return listSubGrupoN4;
	}
	public void setListSubGrupoN4(List<SubGrupoN4DoN3> listSubGrupoN4) {
		this.listSubGrupoN4 = listSubGrupoN4;
	}
	

}

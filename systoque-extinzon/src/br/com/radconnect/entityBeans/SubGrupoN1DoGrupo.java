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
@Table(name = "SUBGRUPO_N1_DO_GRUPO")
public class SubGrupoN1DoGrupo implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_SUBRGRUPO_N1_DO_GRUPO",
	sequenceName = "SEQ_SUBGRUPO_N1_DO_GRUPO",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_SUBRGRUPO_N1_DO_GRUPO")
	private Long id;
	
	@Column(name = "NOME_SUBRGRUPO_N1_DO_GRUPO")
	@Index(name = "IDX_NOME_SUBGRUPO_N1_DO_GRUPO")
	private String nome;
	
	//ATRIBUTOS RELACIONAIS
	@ManyToOne
	@JoinColumn(name = "GRUPO_ID",referencedColumnName = "ID")
	private GrupoDoItem grupo;
	
	@OneToMany(mappedBy = "subGrupoN1",cascade = {CascadeType.ALL},orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<SubGrupoN2DoN1> listSubGrupoN2 = new ArrayList<SubGrupoN2DoN1>();
	//FIM
	
	//METODOS PARA ADICIONAR E RMEOVER DA LISTA DE SUBGRUPO N2
	public void adicionaSubGrupoN2(SubGrupoN2DoN1 subGrupoN2){
		subGrupoN2.setSubGrupoN1(this);
		this.listSubGrupoN2.add(subGrupoN2);
	}
	public void removerSubGrupoN2(SubGrupoN2DoN1 subGrupoN2){
		if(this.listSubGrupoN2.contains(subGrupoN2)){
			this.listSubGrupoN2.remove(subGrupoN2);
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
		SubGrupoN1DoGrupo other = (SubGrupoN1DoGrupo) obj;
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
		return "SubGrupoN1DoGrupo [nome=" + nome + "]";
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

	public GrupoDoItem getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoDoItem grupo) {
		this.grupo = grupo;
	}
	
	

}

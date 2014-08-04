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
@Table(name = "SETOR")
public class Setor implements Serializable {
	
	@Id
	@SequenceGenerator(name = "SEQ_SETOR", sequenceName = "SEQ_SETOR_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SETOR")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NOME")
	@Index(name = "IDX_NOME_SETOR")
	private String nome;

	/*
	 * ATRIBUTOS RELACIONADOS
	 * A ENTIDADE
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "setor",orphanRemoval=true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<Cargo> listCargo = new ArrayList<Cargo>();
	
	public void adicionaCargo(Cargo cargo){
		cargo.setSetor(this);
		this.listCargo.add(cargo);
	}
	public void removeCargo(Cargo cargo){
		cargo.setSetor(this);
		for(int i = 0;i<this.listCargo.size();i++){
			if(cargo.getNome() == this.listCargo.get(i).getNome() && cargo.getCbo() ==
					this.listCargo.get(i).getCbo()){
				this.listCargo.remove(i);
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nome;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
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
		Setor other = (Setor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

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

	public List<Cargo> getListCargo() {
		return listCargo;
	}

	public void setListCargo(List<Cargo> listCargo) {
		this.listCargo = listCargo;
	}
	
	

}

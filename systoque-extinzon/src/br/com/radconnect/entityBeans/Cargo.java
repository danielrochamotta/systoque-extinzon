package br.com.radconnect.entityBeans;

import java.io.Serializable;
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

@SuppressWarnings("serial")
@Entity
@Table(name = "CARGO")
public class Cargo implements Serializable{

@Id
@SequenceGenerator(name = "SEQ_CARGO", sequenceName = "SEQ_CARGO_ID", allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CARGO")
@Column(name = "ID")
private Long id;

@Column(name = "NOME")
@Index(name = "IDX_NOME_CARGO")
private String nome;

@Column(name = "CBO")
@Index(name = "IDX_CBO_CARGO")
private Long cbo;

/*
 * ATRIBUTOS RELACIONADOS
 * A ENTIDADE
 */

//ATRIBUTO RELACIONAL DE SETOR
@ManyToOne
@JoinColumn(name = "ID_SETOR")
private Setor setor = new Setor();

//ATRIBUTO RALACIONAL DE FUNCONARIO
@OneToMany(cascade = CascadeType.ALL, mappedBy = "cargo")
private List<Funcionario> listFuncionarioCargo;

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
	Cargo other = (Cargo) obj;
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

public Setor getSetor() {
	return setor;
}

public void setSetor(Setor setor) {
	this.setor = setor;
}

public List<Funcionario> getListFuncionarioCargo() {
	return listFuncionarioCargo;
}

public void setListFuncionarioCargo(List<Funcionario> listFuncionarioCargo) {
	this.listFuncionarioCargo = listFuncionarioCargo;
}

public Long getCbo() {
	return cbo;
}

public void setCbo(Long cbo) {
	this.cbo = cbo;
}


}

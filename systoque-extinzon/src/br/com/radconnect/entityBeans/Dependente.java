package br.com.radconnect.entityBeans;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPENDENTE_FUNCIONARIO")
public class Dependente implements Serializable {
	
	@Id
	@SequenceGenerator(name = "SEQ_DEPENDENTE", sequenceName = "SEQ_DEPENDENTE_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DEPENDENTE")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DEPENDENTE_NOME")
	@Index(name = "IDX_DEPENDENTE_NOME")
	private String nome;
	
	@Column(name = "DEPENDENTE_DATA_NASC")
	@Index(name = "IDX_DEPENDENTE_DATA_NASC")
	private Date dataNascimento;
	
	@Column(name = "DEPENDENTE_PARENTESCO")
	@Index(name = "IDX_DEPENDENTE_PARENTESCO")
	private String parentesco;
	
	
	 
	@ManyToOne
	@JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName="ID")	
	private Funcionario funcionario;
	
/*
 * (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((id == null) ? 0 : id.hashCode());
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
		Dependente other = (Dependente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
/*
 * 	(non-Javadoc)
 * @see java.lang.Object#toString()
 */
	@Override
	public String toString() {
		return "Dependente [nome="
				+ nome + "]";
	}

	
	/*
	 * GETTERS E SETTERS
	 */

	
	public Funcionario getFuncionario() {
		return funcionario;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	

}

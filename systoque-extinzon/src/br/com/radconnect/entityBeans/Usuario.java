package br.com.radconnect.entityBeans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@SuppressWarnings("serial")
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_USUARIO",sequenceName = "SEQ_USUARIO_ID",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_USUARIO")
	private Long id;
	
	@Column(name = "NOME_USUARIO")
	@Index(name = "IDX_NOME_USUARIO")
	private String nome;
	
	@Column(name = "SENHA_USUARIO")
	@Index(name = "IDX_SENHA_USUARIO")
	private String senha;
	
	
	//HASH CODE
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
		Usuario other = (Usuario) obj;
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
		return nome;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}

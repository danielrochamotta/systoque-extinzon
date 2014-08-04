package br.com.radconnect.entityBeans;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@SuppressWarnings("serial")
@Entity
@Table(name = "FUNCIONARIO_ENDERECO")
public class FuncionarioEndereco implements Serializable{
	
	/*
	 * ATRIBUTOS DA CLASSE
	 * DE ENDEREÇOS DOS FUNCIONÁRIOS
	 */
	
	@Id
	@SequenceGenerator(name = "SEQ_FUNC_ENDERECO", sequenceName = "SEQ_FUNC_ENDERECO_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_FUNC_ENDERECO")
	@Column(name = "ID_FUNC_ENDERECO")
	private Long idFuncEndereco;
	
	@Column(name ="FUNC_END_LOGRADOURO")
	@Index(name = "IDX_FUNC_END_LOGRADOURO")
	private String logradouro;
	
	@Column(name = "FUNC_END_BAIRRO")
	@Index(name = "IDX_FUNC_END_BAIRRO")
	private String bairro;
	
	@Column(name = "FUNC_END_CIDADE")
	@Index(name = "IDX_FUNC_END_CIDADE")
	private String cidade;
	
	@Column(name = "FUNC_END_UF", length = 2)
	@Index(name = "IDX_FUN_END_UF")	
	private String uf;
	
	@Column(name = "FUN_END_CEP")
	@Index(name = "IDX_FUNC_END_CEP")
	private String cep;
	
	/*
	 * ATRIBUTOS RELACIONAIS
	 * 
	 */
	
	//ATRIBUTO RELACIONAL DE FUNCIONARIO
	@OneToOne(mappedBy = "funcEndereco")	
	private Funcionario funcionario;
	
	

	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idFuncEndereco == null) ? 0 : idFuncEndereco.hashCode());
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
		FuncionarioEndereco other = (FuncionarioEndereco) obj;
		if (idFuncEndereco == null) {
			if (other.idFuncEndereco != null)
				return false;
		} else if (!idFuncEndereco.equals(other.idFuncEndereco))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FuncionarioEndereco [logradouro=" + logradouro + "]";
	}

	/*
	 * METODOS GETTERS E SETTERS
	 */
	public Long getIdFuncEndereco() {
		return idFuncEndereco;
	}

	public void setIdFuncEndereco(Long idFuncEndereco) {
		this.idFuncEndereco = idFuncEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	
	
	

}

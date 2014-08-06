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
@Table(name = "ENDERECO")
public class Endereco implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_ENDERECO", sequenceName = "SEQ_ENDERECO_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ENDERECO")
	private Long id;
	
	@Column(name = "LOGRADOURO_ENDERECO")
	@Index(name = "IDX_LOGRDOURO_ENDERECO")
	private String logradouro;
	
	@Column(name = "BAIRRO_ENDERECO")
	@Index(name = "IDX_BAIRRO_ENDERECO")
	private String bairro;
	
	@Column(name = "CIDADE_ENDERECO")
	@Index(name = "IDX_CIDADE_ENDERECO")
	private String cidade;
	
	@Column(name = "UF_ENDERECO")
	@Index(name = "IDX_UF_ENDERECO")
	private String uf;
	
	@Column(name = "CEP_ENDERECO")
	@Index(name = "IDX_CEP_ENDERECO")
	private String cep;
	
	@Column(name = "NUMERO_ENDERECO")
	@Index(name = "IDX_NUMERO_ENDERECO")
	private String numero;
	
	@Column(name = "COMPLEMENTO_ENDERECO")
	@Index(name = "IDX_COMPLEMENTO_ENDERECO")
	private String complemento;
	
	@OneToOne(mappedBy = "endereco")
	private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}

package br.com.radconnect.entityBeans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Index;

@SuppressWarnings("serial")
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
	private Long id;
	
	@Column(name="CODIGO_CLIENTE")
	@Index(name = "IDX_CODIGO_CLIENTE")
	private String codigoCliente;
	
	@Column(name="NOME_RZSOCIAL_CLIENTE")
	@Index(name = "IDX_NOME_RZSOCIAL_CLIENTE")
	private String nomeRazaoSocial;
	
	@Column(name="SOBRENOME_NOMEFANTASIA_CLIENTE")
	@Index(name = "IDX_SOBRENOME_NOMEFANTASIA_CLIENTE")
	private String nomeFantasia;
	
	@Column(name="CONTATO_CLIENTE")
	@Index(name = "IDX_CONTATO_CLIENTE")
	private String contato;
	
	@Column(name="GRUPO_CLIENTE")
	@Index(name = "IDX_GRUPO_CLIENTE")
	private String grupo;
	
	@Column(name="RG_INSCESTADUAL_CLIENTE")
	@Index(name = "IDX_RG_INSCESTADUAL_CLIENTE")
	private String rgInsEstadual;
	
	@Column(name="CPF_CNPJ_CLIENTE")
	@Index(name = "IDX_CPF_CNPJ_CLIENTE")
	private String cpfCnpj;
	
	@Column(name="TELEFONE_CLIENTE")
	@Index(name = "IDX_TELEFONE_CLIENTE")
	private String telefone;
	
	@Column(name="CELULAR_CLIENTE")
	@Index(name = "IDX_CELULAR_CLIENTE")
	private String celular;
	
	@Column(name="ATIVO_CLIENTE")
	@Index(name = "IDX_ATIVO_CLIENTE")
	private Boolean ativo = true;
	
	@Column(name="EMAIL_CLIENTE")
	@Index(name = "IDX_EMAIL_CLIENTE")
	private String email;
	
	@Column(name="EMAIL_CONTATO_CLIENTE")
	@Index(name = "IDX_EMAIL_CONTATO_CLIENTE")
	private String emailDoContato;
	
	@Column(name="NOME_PRIMREFBANCARIA_CLIENTE")
	@Index(name = "IDX_NOME_PRIMREFBANCARIA_CLIENTE")
	private String nomePrimeiraReferenciaBancaria;
	
	@Column(name="TELEFONE_PRIMREFBANCARIA_CLIENTE")
	@Index(name = "IDX_TELEFONE_PRIMREFBANCARIA_CLIENTE")
	private String telefonePrimeiraReferenciaBancaria;
	
	@Column(name="NOME_SEGREFBANCARIA_CLIENTE")
	@Index(name = "IDX_NOME_SEGREFBANCARIA_CLIENTE")
	private String nomeSegundaReferenciaBancaria;
	
	@Column(name="TELEFONE_SEGREFBANCARIA_CLIENTE")
	@Index(name = "IDX_TELEFONE_SEGREFBANCARIA_CLIENTE")
	private String telefoneSegundaReferenciaBancaria;
	
	@Column(name="NOME_TERCREFBANCARIA_CLIENTE")
	@Index(name = "IDX_NOME_TERCREFBANCARIA_CLIENTE")
	private String nomeTerceiraReferenciaBancaria;
	
	@Column(name="TELEFONE_TERCREFBANCARIA_CLIENTE")
	@Index(name = "IDX_TELEFONE_TERCREFBANCARIA_CLIENTE")
	private String telefoneTerceiraReferenciaBancaria;
	
	@Column(name="NOME_PRIMREFCOMERCIAL_CLIENTE")
	@Index(name = "IDX_NOME_PRIMREFCOMERCIAL_CLIENTE")
	private String nomePrimeiraReferenciaComercial;
	
	@Column(name="TELEFONE_PRIMREFCOMERCIAL_CLIENTE")
	@Index(name = "IDX_TELEFONE_PRIMREFCOMERCIAL_CLIENTE")
	private String telefonePrimeiraReferenciaComercial;
	
	@Column(name="NOME_SEGREFCOMERCIAL_CLIENTE")
	@Index(name = "IDX_NOME_SEGREFCOMERCIAL_CLIENTE")
    private String nomeSegundaReferenciaComercial;
	
	@Column(name="TELEFONE_SEGREFCOMERCIAL_CLIENTE")
	@Index(name = "IDX_TELEFONE_SEGREFCOMERCIAL_CLIENTE")
	private String telefoneSegundaReferenciaComercial;
	
	@Column(name="NOME_TERCREFCOMERCIAL_CLIENTE")
	@Index(name = "IDX_NOME_TERCREFCOMERCIAL_CLIENTE")
    private String nomeTerceiraReferenciaComercial;
	
	@Column(name="TELEFONE_TERCREFCOMERCIAL_CLIENTE")
	@Index(name = "IDX_TELEFONE_TERCREFCOMERCIAL_CLIENTE")
	private String telefoneTerceiraReferenciaComercial;
	
	
	//ATRIBUTOS RELACIONAIS
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco = new Endereco();
	
	
	
	
	//INICIO HASHCODE
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	//FIM HASCODE
	
	//INICIO TOSTRING
	@Override
	public String toString() {
		return "Cliente [nomeRazaoSocial=" + nomeRazaoSocial + "]";
	}
	
	//FIM TOSTRING
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}
	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRgInsEstadual() {
		return rgInsEstadual;
	}
	public void setRgInsEstadual(String rgInsEstadual) {
		this.rgInsEstadual = rgInsEstadual;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomePrimeiraReferenciaBancaria() {
		return nomePrimeiraReferenciaBancaria;
	}
	public void setNomePrimeiraReferenciaBancaria(
			String nomePrimeiraReferenciaBancaria) {
		this.nomePrimeiraReferenciaBancaria = nomePrimeiraReferenciaBancaria;
	}
	public String getTelefonePrimeiraReferenciaBancaria() {
		return telefonePrimeiraReferenciaBancaria;
	}
	public void setTelefonePrimeiraReferenciaBancaria(
			String telefonePrimeiraReferenciaBancaria) {
		this.telefonePrimeiraReferenciaBancaria = telefonePrimeiraReferenciaBancaria;
	}
	public String getNomeSegundaReferenciaBancaria() {
		return nomeSegundaReferenciaBancaria;
	}
	public void setNomeSegundaReferenciaBancaria(
			String nomeSegundaReferenciaBancaria) {
		this.nomeSegundaReferenciaBancaria = nomeSegundaReferenciaBancaria;
	}
	public String getTelefoneSegundaReferenciaBancaria() {
		return telefoneSegundaReferenciaBancaria;
	}
	public void setTelefoneSegundaReferenciaBancaria(
			String telefoneSegundaReferenciaBancaria) {
		this.telefoneSegundaReferenciaBancaria = telefoneSegundaReferenciaBancaria;
	}
	public String getNomeTerceiraReferenciaBancaria() {
		return nomeTerceiraReferenciaBancaria;
	}
	public void setNomeTerceiraReferenciaBancaria(
			String nomeTerceiraReferenciaBancaria) {
		this.nomeTerceiraReferenciaBancaria = nomeTerceiraReferenciaBancaria;
	}
	public String getTelefoneTerceiraReferenciaBancaria() {
		return telefoneTerceiraReferenciaBancaria;
	}
	public void setTelefoneTerceiraReferenciaBancaria(
			String telefoneTerceiraReferenciaBancaria) {
		this.telefoneTerceiraReferenciaBancaria = telefoneTerceiraReferenciaBancaria;
	}
	public String getNomePrimeiraReferenciaComercial() {
		return nomePrimeiraReferenciaComercial;
	}
	public void setNomePrimeiraReferenciaComercial(
			String nomePrimeiraReferenciaComercial) {
		this.nomePrimeiraReferenciaComercial = nomePrimeiraReferenciaComercial;
	}
	public String getTelefonePrimeiraReferenciaComercial() {
		return telefonePrimeiraReferenciaComercial;
	}
	public void setTelefonePrimeiraReferenciaComercial(
			String telefonePrimeiraReferenciaComercial) {
		this.telefonePrimeiraReferenciaComercial = telefonePrimeiraReferenciaComercial;
	}
	public String getNomeSegundaReferenciaComercial() {
		return nomeSegundaReferenciaComercial;
	}
	public void setNomeSegundaReferenciaComercial(
			String nomeSegundaReferenciaComercial) {
		this.nomeSegundaReferenciaComercial = nomeSegundaReferenciaComercial;
	}
	public String getTelefoneSegundaReferenciaComercial() {
		return telefoneSegundaReferenciaComercial;
	}
	public void setTelefoneSegundaReferenciaComercial(
			String telefoneSegundaReferenciaComercial) {
		this.telefoneSegundaReferenciaComercial = telefoneSegundaReferenciaComercial;
	}
	public String getNomeTerceiraReferenciaComercial() {
		return nomeTerceiraReferenciaComercial;
	}
	public void setNomeTerceiraReferenciaComercial(
			String nomeTerceiraReferenciaComercial) {
		this.nomeTerceiraReferenciaComercial = nomeTerceiraReferenciaComercial;
	}
	public String getTelefoneTerceiraReferenciaComercial() {
		return telefoneTerceiraReferenciaComercial;
	}
	public void setTelefoneTerceiraReferenciaComercial(
			String telefoneTerceiraReferenciaComercial) {
		this.telefoneTerceiraReferenciaComercial = telefoneTerceiraReferenciaComercial;
	}
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getEmailDoContato() {
		return emailDoContato;
	}
	public void setEmailDoContato(String emailDoContato) {
		this.emailDoContato = emailDoContato;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	


}

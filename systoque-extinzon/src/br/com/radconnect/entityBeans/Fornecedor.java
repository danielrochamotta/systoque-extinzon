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
@Table(name = "FORNECEDOR")
public class Fornecedor implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_FORNECEDOR", sequenceName = "SEQ_FORNECEDOR_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FORNECEDOR")
	private Long id;
	
	@Column(name="CODIGO_FORNECEDOR")
	@Index(name = "IDX_CODIGO_FORNECEDOR")
	private String codigo;
	
	@Column(name="NOME_RZSOCIAL_FORNECEDOR")
	@Index(name = "IDX_NOME_RZSOCIAL_FORNECEDOR")
	private String nomeRazaoSocial;
	
	@Column(name="SOBRENOME_NOMEFANTASIA_FORNECEDOR")
	@Index(name = "IDX_SOBRENOME_NOMEFANTASIA_FORNECEDOR")
	private String nomeFantasia;
	
	@Column(name="CONTATO_FORNECEDOR")
	@Index(name = "IDX_CONTATO_FORNECEDOR")
	private String contato;
	
	@Column(name="GRUPO_FORNECEDOR")
	@Index(name = "IDX_GRUPO_FORNECEDOR")
	private String grupo;
	
	@Column(name="RG_INSCESTADUAL_FORNECEDOR")
	@Index(name = "IDX_RG_INSCESTADUAL_FORNECEDOR")
	private String rgInsEstadual;
	
	@Column(name="CPF_CNPJ_FORNECEDOR")
	@Index(name = "IDX_CPF_CNPJ_FORNECEDOR")
	private String cpfCnpj;
	
	@Column(name="TELEFONE_FORNECEDOR")
	@Index(name = "IDX_TELEFONE_FORNECEDOR")
	private String telefone;
	
	@Column(name="CELULAR_CLIENTE")
	@Index(name = "IDX_CELULAR_FORNECEDOR")
	private String celular;
	
	@Column(name="ATIVO_CLIENTE")
	@Index(name = "IDX_ATIVO_FORNECEDOR")
	private Boolean ativo = true;
	
	@Column(name="EMAIL_FORNECEDOR")
	@Index(name = "IDX_EMAIL_FORNECEDOR")
	private String email;
	
	@Column(name="EMAIL_CONTATO_FORNECEDOR")
	@Index(name = "IDX_EMAIL_CONTATO_FORNECEDOR")
	private String emailDoContato;
	
	
	@Column(name="BANCO_1_FORNECEDOR")
	@Index(name = "IDX_BANCO_1_FORNECEDOR")
	private String BancoNome1;
	
	@Column(name="BANCO_2_FORNECEDOR")
	@Index(name = "IDX_BANCO_2_FORNECEDOR")
	private String BancoNome2;
	
	@Column(name="BANCO_3_FORNECEDOR")
	@Index(name = "IDX_BANCO_3_FORNECEDOR")
	private String BancoNome3;
	
	@Column(name="BANCO_NOME_TITULAR_1_FORNECEDOR")
	@Index(name = "IDX_BANCO_NOME_TITULAR_1_FORNECEDOR")
	private String bancoNomeTitular1;
	
	@Column(name="BANCO_NOME_TITULAR_2_FORNECEDOR")
	@Index(name = "IDX_BANCO_NOME_TITULAR_2_FORNECEDOR")	
	private String bancoNomeTitular2;
	
	@Column(name="BANCO_NOME_TITULAR_3_FORNECEDOR")
	@Index(name = "IDX_BANCO_NOME_TITULAR_3_FORNECEDOR")
	private String bancoNomeTitular3;
	
	@Column(name="BANCO_CONTA_1_FORNECEDOR")
	@Index(name = "IDX_BANCO_CONTA_1_FORNECEDOR")
	private String bancoConta1;
	
	@Column(name="BANCO_CONTA_2_FORNECEDOR")
	@Index(name = "IDX_BANCO_CONTA_2_FORNECEDOR")
	private String bancoConta2;
	
	@Column(name="BANCO_CONTA_3_FORNECEDOR")
	@Index(name = "IDX_BANCO_CONTA_3_FORNECEDOR")
	private String bancoConta3;
	
	@Column(name="BANCO_CPF_CNPJ_TITULAR_1_FORNECEDOR")
	@Index(name = "IDX_BANCO_CPF_CNPJ_TITULAR_1__FORNECEDOR")
	private String bancoCpfTitular1;
	
	@Column(name="BANCO_CPF_CNPJ_TITULAR_2_FORNECEDOR")
	@Index(name = "IDX_BANCO_CPF_CNPJ_TITULAR_2__FORNECEDOR")
	private String bancoCpfTitular2;
	
	@Column(name="BANCO_CPF_CNPJ_TITULAR_3_FORNECEDOR")
	@Index(name = "IDX_BANCO_CPF_CNPJ_TITULAR_3__FORNECEDOR")
	private String bancoCpfTitular3;
	
	
	
	
	
	
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
		Fornecedor other = (Fornecedor) obj;
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
		return "Fornecedor [nomeRazaoSocial=" + nomeRazaoSocial + "]";
	}
	
	//FIM TOSTRING
	
	//METODOS GETTERS E SETTERS
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public String getEmailDoContato() {
		return emailDoContato;
	}
	public void setEmailDoContato(String emailDoContato) {
		this.emailDoContato = emailDoContato;
	}		
	
	public String getBancoNome1() {
		return BancoNome1;
	}
	public void setBancoNome1(String bancoNome1) {
		BancoNome1 = bancoNome1;
	}
	public String getBancoNome2() {
		return BancoNome2;
	}
	public void setBancoNome2(String bancoNome2) {
		BancoNome2 = bancoNome2;
	}
	public String getBancoNome3() {
		return BancoNome3;
	}
	public void setBancoNome3(String bancoNome3) {
		BancoNome3 = bancoNome3;
	}
	public String getBancoNomeTitular1() {
		return bancoNomeTitular1;
	}
	public void setBancoNomeTitular1(String bancoNomeTitular1) {
		this.bancoNomeTitular1 = bancoNomeTitular1;
	}
	public String getBancoNomeTitular2() {
		return bancoNomeTitular2;
	}
	public void setBancoNomeTitular2(String bancoNomeTitular2) {
		this.bancoNomeTitular2 = bancoNomeTitular2;
	}
	public String getBancoNomeTitular3() {
		return bancoNomeTitular3;
	}
	public void setBancoNomeTitular3(String bancoNomeTitular3) {
		this.bancoNomeTitular3 = bancoNomeTitular3;
	}
	public String getBancoConta1() {
		return bancoConta1;
	}
	public void setBancoConta1(String bancoConta1) {
		this.bancoConta1 = bancoConta1;
	}
	public String getBancoConta2() {
		return bancoConta2;
	}
	public void setBancoConta2(String bancoConta2) {
		this.bancoConta2 = bancoConta2;
	}
	public String getBancoConta3() {
		return bancoConta3;
	}
	public void setBancoConta3(String bancoNomeConta3) {
		this.bancoConta3 = bancoNomeConta3;
	}
	public String getBancoCpfTitular1() {
		return bancoCpfTitular1;
	}
	public void setBancoCpfTitular1(String bancoCpfTitular1) {
		this.bancoCpfTitular1 = bancoCpfTitular1;
	}
	public String getBancoCpfTitular2() {
		return bancoCpfTitular2;
	}
	public void setBancoCpfTitular2(String bancoCpfTitular2) {
		this.bancoCpfTitular2 = bancoCpfTitular2;
	}
	public String getBancoCpfTitular3() {
		return bancoCpfTitular3;
	}
	public void setBancoCpfTitular3(String bancoCpfTitular3) {
		this.bancoCpfTitular3 = bancoCpfTitular3;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

}

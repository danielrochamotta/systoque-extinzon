package br.com.radconnect.entityBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Index;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@SuppressWarnings("serial")
@Entity
@Table (name = "FUNCIONARIO")

public class Funcionario implements Serializable{

	@Id
	@SequenceGenerator(name = "SEQ_FUNCIONARIO", sequenceName = "SEQ_FUNCIONARIO_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FUNCIONARIO")
	@Column(name = "ID")
	private Long id;
	
	@Column(name="MATRICULA_FUNCIONARIO")
	@Index(name = "IDX_MATRICULA_FUNCIONARIO")
	private String matricula;
	
	@Column(name = "NOME_FUNCIONARIO")
	@Index(name = "IDX_NOME_FUNCIONARIO")
	private String nome;
	
	@Column(name = "NOME_PAI__FUNCIONARIO")
	@Index(name = "IDX_NOME_PAI_FUNCIONARIO")
	private String nomePai;
	
	@Column(name = "NOME_MAE_FUNCIONARIO")
	@Index(name = "IDX_NOME_MAE_FUNCIONARIO")
	private String nomeMae;
	
	@Column(name = "CPF_FUNCIONARIO")
	@Index(name = "IDX_CPF_FUNCIONARIO")
	private String cpf;
	
	@Column(name = "DATA_NASCIMENTO_FUNCIONARIO")
	@Index(name = "IDX_DATA_NASCIMENTO_FUNCIONARIO")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Column(name = "TELEFONE_FUNCIONARIO")
	@Index(name = "IDX_TELEFONE_FUNCIONARIO")
	private String telefone;
	
	@Column(name = "CELULAR_FUNCIONARIO")
	@Index(name = "IDX_CELULAR_FUNCIONARIO")
	private String celular;
	
	@Column(name = "EMAIL_FUNCIONARIO")
	@Index(name = "IDX_EMAIL_FUNCIONARIO")
	private String email;
	
	@Column(name = "UF_NATURALIDADE_FUNCIONARIO")
	@Index(name = "IDX_UF_NATURALIDADE_FUNCIONARIO")
	private String ufNaturalidade;
	
	@Column(name = "NATURALIDADE_FUNCIONARIO")
	@Index(name = "IDX_NATURALIDADE_FUNCIONARIO")
	private String naturalidade;
	
	@Column(name = "NACIONALIDADE_FUNCIONARIO")
	@Index(name = "IDX_NACIONALIDADE_FUNCIONARIO")
	private String nacionalidade;
	
	@Column(name = "SEXO_FUNCIONARIO")
	@Index(name = "IDX_SEXO_FUNCIONARIO")
	private Boolean sexo;
	
	@Column(name = "ESTADO_CIVIL_FUNCIONARIO")
	@Index(name = "IDX_ESTADO_CIVIL_FUNCIONARIO")
	private String estadoCivil;
	
	@Column(name = "RACA_FUNCIONARIO")
	@Index(name = "IDX_RACA_FUNCIONARIO")
	private String raca;
	
	@Column(name = "GRAU_INSRUCAO_FUNCIONARIO")
	@Index(name = "IDX_GRAU_INSTRUCAO_FUNCIONARIO")
	private String grauInstrucao;
	
	@Column(name = "NUMERO_HABILITACAO_FUNCIONARIO")
	@Index(name = "IDX_NUMERO_HABILITACAO_FUNCIONARIO")
	private String numeroHabilitacao;
	
	@Column(name = "NUMERO_PIS_PASEP_FUNCIONARIO")
	@Index(name = "IDX_NUMERO_PIS_PASEP_FUNCIONARIO")
	private String numeroPisPasep;
	
	@Column(name = "NUMERO_CTPS_FUNCIONARIO")
	@Index(name = "IDX_NUMERO_CTPS_FUNCIONARIO")
	private String ctpsNumero;
	
	@Column(name = "SERIE_CTPS_FUNCIONARIO")
	@Index(name = "IDX_CTPS_SERIE_FUNCIONARIO")
	private String ctpsSerie;
	
	@Column(name = "DV_CTPS_FUNCIONARIO")
	@Index(name = "IDX_DV_CTPS_FUNCIONARIO")
	private String ctpsDV;
	
	@Column(name = "DATA_EMISSAO_CTPS_FUNCIONARIO")
	@Index(name = "IDX_DATA_EMISSAO_CTPS_FUNCIONARIO")
	private Date ctpsDataEmissao;
	
	@Column(name = "SERIE_CERTIFICADO_MILITAR_FUNCIONARIO")
	@Index(name = "IDX_SERIE_CERTIFICADO_MILITAR_FUNCIONARIO")
	private String certMilitarSerie;
	
	@Column(name = "TIPO_CERTIFICADO_MILITAR_FUNCIONARIO")
	@Index(name = "IDX_TIPO_CERTIFICADO_MILITAR_FUNCIONARIO")
	private String certMilitarTipo;
	
	@Column(name = "CATEGORIA_CERTIFICADO_MILITAR_FUNCIONARIO")
	@Index(name = "IDX_CATEGORIA_CERTIFICADO_MILITAR_FUNCIONARIO")
	private String certMilitarCategoria;
	
	@Column(name = "CSM_OAM_CERTIFICADO_MILITAR_FUNCIONARIO")
	@Index(name = "IDX_CSM_OAM_CERTIFICADO_MILITAR_FUNCIONARIO")
	private String certMilitarCsmOam;
	
	@Column(name = "RM_DN_COMAR_CERTIFICADO_MILITAR_FUNCIONARIO")
	@Index(name = "IDX_RM_DN_COMAR_CERTIFICADO_MILITAR_FUNCIONARIO")
	private String certMilitarRmDnComar;
	
	@Column(name = "NUMERO_TITULO_ELEITOR_FUNCIONARIO")
	@Index(name = "IDX_NUMERO_TITULO_ELEITOR_FUNCIONARIO")
	private Long tituloEleitorNumero;
	
	@Column(name = "SECAO_TITULO_ELEITOR_FUNCIONARIO")
	@Index(name = "IDX_SECAO_TITULO_ELEITOR_FUNCIONARIO")
	private String tituloEleitorSecao;
	
	@Column(name = "ZONA_TITULO_ELEITOR_FUNCIONARIO")
	@Index(name = "IDX_ZONA_TITULO_ELEITOR_FUNCIONARIO")
	private String tituloEleitorZona;
	
	@Column(name = "NUMERO_RG_FUNCIONARIO")
	@Index(name = "IDX_NUMERO_RG_FUNCIONARIO")
	private String rgNumero;
	
	@Column(name = "DATA_EMISSAO_RG_FUNCIONARIO")
	@Index(name = "IDX_DATA_EMISSAO_RG_FUNCIONARIO")
	private Date rgDataEmissao;
	
	@Column(name = "ORGAO_EMISSOR_RG_FUNCIONARIO")
	@Index(name = "IDX_ORGAO_EMISSOR_RG_FUNCIONARIO")
	private String rgOrgaoEmissor;
	
	@Column(name = "DATA_CHEGADA_IMIGRACAO_FUNCIONARIO")
	@Index(name = "IDX_DATA_CHEGADA_IMIGRACAO_FUNCIONARIO")
	private Date imigracaoDataChegada;
	
	@Column(name = "TIPO_VISTO_IMIGRACAO_FUNCIONARIO")
	@Index(name = "IDX_TIPO_VISTO_IMIGRACAO_FUNCIONARIO")
	private String imigracaoTipoVisto;
	
	@Column(name = "VALIDADE_RG_IMIGRACAO_FUNCIONARIO")
	@Index(name = "IDX_VALIDADE_RG_IMIGRACAO_FUNCIONARIO")
	private Date imigracaoRgValidade;
	
	@Column(name = "VALIDADE_CTPS_IMIGRACAO_FUNCIONARIO")
	@Index(name = "IDX_VALIDADE_CTPS_IMIGRACAO_FUNCIONARIO")
	private Date imigracaoCtpsValidade;
	
	@Column(name = "DATA_ADMISSAO_FUNCIONARIO")
	@Index(name = "IDX_DATA_ADMISSAO_FUNCIONARIO")
	private Date dataAdmissao;
	
	@Column(name = "FORMA_PAGAMENTO_FUNCIONARIO")
	@Index(name = "IDX_FORMA_PAGAMENTO_FUNCIONARIO")
	private String formaPagamento;
	
	@Column(name = "HORARIO_TRABALHO_FUNCIONARIO")
	@Index(name = "IDX_HORARIO_TRABALHO_FUNCIONARIO")
	private String horarioTrabalho;
	
	@Column(name = "PARTICIPACAO_CIPA_FUNCIONARIO")
	@Index(name = "IDX_PARTICIPACAO_CIPA_FUNCIONARIO")
	private Boolean participacaoCipa;
	
	
	
	/*
	 * ATRIBUTOS RELACIONAIS
	 * 
	 */
	//ATRIBUTO RELACIONAL DE ENDERECO
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_FUNC_ENDERECO")
	private FuncionarioEndereco funcEndereco = new FuncionarioEndereco();
	
	//ATRIBUTO RELACIONAL DE DEPENDENTES
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario", orphanRemoval=true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<Dependente> listDependente = new ArrayList<Dependente>();
	
	//ATRIBUTO RELACIONAL DO HISTORICO DE CARGO DO FUNCIONARIO
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario", orphanRemoval=true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<HistoricoDeCargos> listHistoricoDeCargo = new ArrayList<HistoricoDeCargos>();
	
	//ATRIBUTO RELACIONAL DO HISTORICO DE SALARIO DO FUNCIONARIO
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario", orphanRemoval=true)
		@LazyCollection(LazyCollectionOption.EXTRA)
		private List<HistoricoDeSalario> listHistoricoDeSalario = new ArrayList<HistoricoDeSalario>();
		
	//ATRIBUTO RELACIONAL DO HISTORICO DE CONTRIBUICAO SINDICAL DO FUNCIONARIO
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario", orphanRemoval=true)
		@LazyCollection(LazyCollectionOption.EXTRA)
		private List<HistoricoContribuicaoSindical> listHistoricoDeContribuicao =
		new ArrayList<HistoricoContribuicaoSindical>();
		
    //ATRIBUTO RELACIONAL DO HISTORICO DE LICENCAS E AFASTAMENTOS DO FUNCIONARIO
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario", orphanRemoval=true)
		@LazyCollection(LazyCollectionOption.EXTRA)
		private List<HistoricoLicencaAfastamento> listHistoricoLicenca = 
		new ArrayList<HistoricoLicencaAfastamento>();
		
   //ATRIBUTO RELACIONAL DO HISTORICO DE FERIAS DO FUNCIONARIO
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario", orphanRemoval=true)
		@LazyCollection(LazyCollectionOption.EXTRA)
		private List<HistoricoDeFerias> listHistoricoFerias = 
		new ArrayList<HistoricoDeFerias>();
	
	//ATRIBUTO RELACIONAL DE CARGO
	@ManyToOne
	@JoinColumn(name ="ID_CARGO")
	private Cargo cargo;
	
	
	
	//COMECA METODOS DE ADD E REMOVE DO DEPENDENTE DO CLEINTE
	public void adicionaDependente(Dependente doFuncionario){
		doFuncionario.setFuncionario(this);
		this.listDependente.add(doFuncionario);
	}
	public void removeDependente(Dependente doFuncionario){
		doFuncionario.setFuncionario(this);
		this.listDependente.remove(doFuncionario);
	}	
	//TERMINA METODOS ADD E REMOVE DEPENDENTES
	
	//COMECA METODOS DE ADD HISTORICO DE CARGO DO FUNCIONARIO	
	public void adicionaHistoricoDeCargo(HistoricoDeCargos registro){
		registro.setFuncionario(this);		
		this.listHistoricoDeCargo.add(registro);
	}
	
	public void removeHistoricoDeCargo(HistoricoDeCargos registro){
		registro.setFuncionario(this);
		this.listHistoricoDeCargo.remove(registro);
	}
	//TERMINA METODOS DE ADD E REMOVE REGISTRO DO HISTORICO DE CARGOS DO FUNCIONARIO
	
	//COMECA METODOS DE ADD HISTORICO DE SALARIO DO FUNCIONARIO	
		public void adicionaHistoricoDeSalario(HistoricoDeSalario registro){
			registro.setFuncionario(this);		
			this.listHistoricoDeSalario.add(registro);
		}
		
		public void removeHistoricoDeSalario(HistoricoDeSalario registro){
			registro.setFuncionario(this);
			this.listHistoricoDeSalario.remove(registro);
		}
	//TERMINA METODOS DE ADD E REMOVE REGISTRO DO HISTORICO DE SALARIO DO FUNCIONARIO
		
	//COMECA METODOS DE ADD HISTORICO DE CONTRIBUICAO SINDICAL DO FUNCIONARIO	
		public void adicionaHistoricoDeContribuicao(HistoricoContribuicaoSindical registro){
			 registro.setFuncionario(this);		
			 this.listHistoricoDeContribuicao.add(registro);
		}
				
		public void removeHistoricoContribuicao(HistoricoContribuicaoSindical registro){
			 registro.setFuncionario(this);
			 this.listHistoricoDeContribuicao.remove(registro);
		}
	//TERMINA METODOS DE ADD E REMOVE REGISTRO DO HISTORICO DE CONTRIBUICAO SINDICAL DO FUNCIONARIO


	//COMECA METODOS DE ADD HISTORICO DE LICENCA E AFASTAMENTO DO FUNCIONARIO	
		public void adicionaHistoricoLicenca(HistoricoLicencaAfastamento registro){
				 registro.setFuncionario(this);		
				 this.listHistoricoLicenca.add(registro);
		}
						
		public void removeHistoricoDeLicenca(HistoricoLicencaAfastamento registro){
				 registro.setFuncionario(this);
				 this.listHistoricoLicenca.remove(registro);
		}
	//TERMINA METODOS DE ADD E REMOVE REGISTRO DO HISTORICO DE LICENCA E AFASTAMENTO DO FUNCIONARIO
		
	//COMECA METODOS DE ADD HISTORICO DE FERIAS DO FUNCIONARIO	
		public void adicionaHistoricoDeFerias(HistoricoDeFerias registro){
					 registro.setFuncionario(this);		
					 this.listHistoricoFerias.add(registro);
		}
								
		public void removeHistoricoDeFerias(HistoricoDeFerias registro){
					 registro.setFuncionario(this);
					 this.listHistoricoFerias.remove(registro);
		}
    //TERMINA METODOS DE ADD E REMOVE REGISTRO DO HISTORICO DE FERIAS DO FUNCIONARIO

    
	
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
	
	
/*
 * (non-Javadoc)
 * @see java.lang.Object#toString()
 */
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/*
	 * GETTERS E SETTERS
	 */

	
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

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	

	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public FuncionarioEndereco getFuncEndereco() {
		return funcEndereco;
	}



	public void setFuncEndereco(FuncionarioEndereco funcEndereco) {
		this.funcEndereco = funcEndereco;
	}



	public List<Dependente> getListDependente() {
		return listDependente;
	}



	public void setListDependente(List<Dependente> listDependente) {
		this.listDependente = listDependente;
	}

	public List<HistoricoDeCargos> getListHistoricoDeCargo() {
		return listHistoricoDeCargo;
	}
	public void setListHistoricoDeCargo(List<HistoricoDeCargos> listHistoricoDeCargo) {
		this.listHistoricoDeCargo = listHistoricoDeCargo;
	}
	
	public List<HistoricoDeSalario> getListHistoricoDeSalario() {
		return listHistoricoDeSalario;
	}
	public void setListHistoricoDeSalario(
			List<HistoricoDeSalario> listHistoricoDeSalario) {
		this.listHistoricoDeSalario = listHistoricoDeSalario;
	}
	public Cargo getCargoFuncionario() {
		return cargo;
	}


	public void setCargoFuncionario(Cargo cargo) {
		this.cargo = cargo;
	}


	public String getNumeroHabilitacao() {
		return numeroHabilitacao;
	}


	public void setNumeroHabilitacao(String numeroHabilitacao) {
		this.numeroHabilitacao = numeroHabilitacao;
	}


	public String getNumeroPisPasep() {
		return numeroPisPasep;
	}


	public void setNumeroPisPasep(String numeroPisPasep) {
		this.numeroPisPasep = numeroPisPasep;
	}

	public String getCtpsSerie() {
		return ctpsSerie;
	}


	public void setCtpsSerie(String ctpsSerie) {
		this.ctpsSerie = ctpsSerie;
	}


	public String getCtpsDV() {
		return ctpsDV;
	}


	public void setCtpsDV(String ctpsDV) {
		this.ctpsDV = ctpsDV;
	}


	public Date getCtpsDataEmissao() {
		return ctpsDataEmissao;
	}


	public void setCtpsDataEmissao(Date ctpsDataEmissao) {
		this.ctpsDataEmissao = ctpsDataEmissao;
	}


	public String getCertMilitarSerie() {
		return certMilitarSerie;
	}


	public void setCertMilitarSerie(String certMilitarSerie) {
		this.certMilitarSerie = certMilitarSerie;
	}


	public String getCertMilitarTipo() {
		return certMilitarTipo;
	}


	public void setCertMilitarTipo(String certMilitarTipo) {
		this.certMilitarTipo = certMilitarTipo;
	}


	public String getCertMilitarCategoria() {
		return certMilitarCategoria;
	}


	public void setCertMilitarCategoria(String certMilitarCategoria) {
		this.certMilitarCategoria = certMilitarCategoria;
	}


	public String getCertMilitarCsmOam() {
		return certMilitarCsmOam;
	}


	public void setCertMilitarCsmOam(String certMilitarCsmOam) {
		this.certMilitarCsmOam = certMilitarCsmOam;
	}


	public String getCertMilitarRmDnComar() {
		return certMilitarRmDnComar;
	}


	public void setCertMilitarRmDnComar(String certMilitarRmDnComar) {
		this.certMilitarRmDnComar = certMilitarRmDnComar;
	}


	public Long getTituloEleitorNumero() {
		return tituloEleitorNumero;
	}


	public void setTituloEleitorNumero(Long tituloEleitorNumero) {
		this.tituloEleitorNumero = tituloEleitorNumero;
	}


	public String getTituloEleitorSecao() {
		return tituloEleitorSecao;
	}


	public void setTituloEleitorSecao(String tituloEleitorSecao) {
		this.tituloEleitorSecao = tituloEleitorSecao;
	}


	public String getTituloEleitorZona() {
		return tituloEleitorZona;
	}


	public void setTituloEleitorZona(String tituloEleitorZona) {
		this.tituloEleitorZona = tituloEleitorZona;
	}	

	public Date getRgDataEmissao() {
		return rgDataEmissao;
	}


	public void setRgDataEmissao(Date rgDataEmissao) {
		this.rgDataEmissao = rgDataEmissao;
	}


	public String getRgOrgaoEmissor() {
		return rgOrgaoEmissor;
	}


	public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
		this.rgOrgaoEmissor = rgOrgaoEmissor;
	}


	public Date getImigracaoDataChegada() {
		return imigracaoDataChegada;
	}


	public void setImigracaoDataChegada(Date imigracaoDataChegada) {
		this.imigracaoDataChegada = imigracaoDataChegada;
	}


	public String getImigracaoTipoVisto() {
		return imigracaoTipoVisto;
	}


	public void setImigracaoTipoVisto(String imigracaoTipoVisto) {
		this.imigracaoTipoVisto = imigracaoTipoVisto;
	}


	public Date getImigracaoRgValidade() {
		return imigracaoRgValidade;
	}


	public void setImigracaoRgValidade(Date imigracaoRgValidade) {
		this.imigracaoRgValidade = imigracaoRgValidade;
	}


	public Date getImigracaoCtpsValidade() {
		return imigracaoCtpsValidade;
	}


	public void setImigracaoCtpsValidade(Date imigracaoCtpsValidade) {
		this.imigracaoCtpsValidade = imigracaoCtpsValidade;
	}


	public Date getDataAdmissao() {
		return dataAdmissao;
	}


	public void setDataAdmissaoFuncionario(Date dataAdmissaoFuncionario) {
		this.dataAdmissao = dataAdmissaoFuncionario;
	}


	public String getFormaPagamentoFuncionario() {
		return formaPagamento;
	}


	public void setFormaPagamentoFuncionario(String formaPagamentoFuncionario) {
		this.formaPagamento = formaPagamentoFuncionario;
	}


	public String getHorarioTrabalhoFuncionario() {
		return horarioTrabalho;
	}


	public void setHorarioTrabalhoFuncionario(String horarioTrabalhoFuncionario) {
		this.horarioTrabalho = horarioTrabalhoFuncionario;
	}


	public Boolean getParticipacaoCipaFuncionario() {
		return participacaoCipa;
	}


	public void setParticipacaoCipaFuncionario(Boolean participacaoCipaFuncionario) {
		this.participacaoCipa = participacaoCipaFuncionario;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public String getHorarioTrabalho() {
		return horarioTrabalho;
	}
	public void setHorarioTrabalho(String horarioTrabalho) {
		this.horarioTrabalho = horarioTrabalho;
	}
	public Boolean getParticipacaoCipa() {
		return participacaoCipa;
	}
	public void setParticipacaoCipa(Boolean participacaoCipa) {
		this.participacaoCipa = participacaoCipa;
	}
	public List<HistoricoContribuicaoSindical> getListHistoricoDeContribuicao() {
		return listHistoricoDeContribuicao;
	}
	public void setListHistoricoDeContribuicao(
			List<HistoricoContribuicaoSindical> listHistoricoDeContribuicao) {
		this.listHistoricoDeContribuicao = listHistoricoDeContribuicao;
	}
	public List<HistoricoLicencaAfastamento> getListHistoricoLicenca() {
		return listHistoricoLicenca;
	}
	public void setListHistoricoLicenca(
			List<HistoricoLicencaAfastamento> listHistoricoLicenca) {
		this.listHistoricoLicenca = listHistoricoLicenca;
	}
	public List<HistoricoDeFerias> getListHistoricoFerias() {
		return listHistoricoFerias;
	}
	public void setListHistoricoFerias(List<HistoricoDeFerias> listHistoricoFerias) {
		this.listHistoricoFerias = listHistoricoFerias;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCtpsNumero() {
		return ctpsNumero;
	}
	public void setCtpsNumero(String ctpsNumero) {
		this.ctpsNumero = ctpsNumero;
	}
	public String getRgNumero() {
		return rgNumero;
	}
	public void setRgNumero(String rgNumero) {
		this.rgNumero = rgNumero;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public Boolean getSexo() {
		return sexo;
	}
	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getGrauInstrucao() {
		return grauInstrucao;
	}
	public void setGrauInstrucao(String grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}
	public String getUfNaturalidade() {
		return ufNaturalidade;
	}
	public void setUfNaturalidade(String ufNaturalidade) {
		this.ufNaturalidade = ufNaturalidade;
	}
	
	
	
	
	
	
	
}

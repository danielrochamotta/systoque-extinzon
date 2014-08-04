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
@Table(name="HISTORICO_CARGOS")
public class HistoricoDeCargos implements Serializable {
	
	@Id
	@SequenceGenerator(name = "SEQ_HIST_CARGO", sequenceName = "SEQ_HIST_CARGO_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HIST_CARGO")
	@Column(name = "ID")
	private Long id;
	
	@Column(name="DATA_ATUACAO")
	@Index(name = "IDX_DATA_ATUACAO")
	private Date dtDaAtuacao;
	
	@Column(name="NOME_CARGO")
	@Index(name = "IDX_NOME_CARGO")
	private String cargo;
	
	@Column(name="NUMERO_CBO")
	@Index(name = "IDX_NUMERO_CBO")
	private Long cbo;
	
	@ManyToOne
	@JoinColumn(name="ID_FUNCIONARIO")
	private Funcionario funcionario = new Funcionario();
	
	/*
	 * GETTERS E SETTERS
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDtDaAtuacao() {
		return dtDaAtuacao;
	}

	public void setDtDaAtuacao(Date dtDaAtuacao) {
		this.dtDaAtuacao = dtDaAtuacao;
	}
	
	

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Long getCbo() {
		return cbo;
	}

	public void setCbo(Long cbo) {
		this.cbo = cbo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	

}

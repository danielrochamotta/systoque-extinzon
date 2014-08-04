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
@Table(name="HISTORICO_LICENCAS")
public class HistoricoLicencaAfastamento implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_HIST_LICENCAS", sequenceName = "SEQ_HIST_LICENCAS_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HIST_LICENCAS")
	@Column(name = "ID")
	private Long id;
	
	@Column(name="DT_INICIAL")
	@Index(name = "IDX_DT_INICIAL")
	private Date dtInicial;
	
	@Column(name="DT_FINAL")
	@Index(name = "IDX_DT_FINAL")
	private Date dtFinal;
	
	@Column(name="CAUSA")
	@Index(name = "IDX_CAUSA")
	private String causa;
	
	
	
	@ManyToOne
	@JoinColumn(name="ID_FUNCIONARIO")
	private Funcionario funcionario = new Funcionario();
	
	//HASHCODE

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
		HistoricoLicencaAfastamento other = (HistoricoLicencaAfastamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	//GETTERS E SETTERS

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getDtInicial() {
		return dtInicial;
	}



	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}



	public Date getDtFinal() {
		return dtFinal;
	}



	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}



	public String getCausa() {
		return causa;
	}



	public void setCausa(String causa) {
		this.causa = causa;
	}



	public Funcionario getFuncionario() {
		return funcionario;
	}



	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	

}

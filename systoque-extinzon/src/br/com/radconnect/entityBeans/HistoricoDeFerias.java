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
@Table(name="HISTORICO_FERIAS")
public class HistoricoDeFerias implements Serializable{
	

	@Id
	@SequenceGenerator(name = "SEQ_HIST_FERIAS", sequenceName = "SEQ_HIST_FERIAS_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HIST_FERIAS")
	@Column(name = "ID")
	private Long id;
	
	@Column(name="DT_INICIAL_GOZO")
	@Index(name = "IDX_DT_INICIAL_GOZO")
	private Date dtInicialGozo;
	
	@Column(name="DT_FINAL_GOZO")
	@Index(name = "IDX_DT_FINAL_GOZO")
	private Date dtFinalGozo;
	
	@Column(name="DT_INICIAL_AQUISITIVA")
	@Index(name = "IDX_DT_INICIAL_AQUISITIVA")
	private Date dtInicialAquisitiva;
	
	@Column(name="DT_FINAL_AQUISITIVA")
	@Index(name = "IDX_DT_FINAL_AQUISITIVA")
	private Date dtFinalAquisitiva;
	
	
	
	
	
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
		HistoricoDeFerias other = (HistoricoDeFerias) obj;
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
	

	public Date getDtInicialGozo() {
		return dtInicialGozo;
	}



	public void setDtInicialGozo(Date dtInicialGozo) {
		this.dtInicialGozo = dtInicialGozo;
	}



	public Date getDtFinalGozo() {
		return dtFinalGozo;
	}



	public void setDtFinalGozo(Date dtFinalGozo) {
		this.dtFinalGozo = dtFinalGozo;
	}



	public Date getDtInicialAquisitiva() {
		return dtInicialAquisitiva;
	}



	public void setDtInicialAquisitiva(Date dtInicialAquisitiva) {
		this.dtInicialAquisitiva = dtInicialAquisitiva;
	}



	public Date getDtFinalAquisitiva() {
		return dtFinalAquisitiva;
	}



	public void setDtFinalAquisitiva(Date dtFinalAquisitiva) {
		this.dtFinalAquisitiva = dtFinalAquisitiva;
	}



	public Funcionario getFuncionario() {
		return funcionario;
	}



	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}

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
@Table(name="HISTORICO_CONTRIBUICAO_SINDICAL")
public class HistoricoContribuicaoSindical implements Serializable {
	

	@Id
	@SequenceGenerator(name = "SEQ_HIST_CONTRIB_SINDICAL", sequenceName = "SEQ_HIST_CONTRIB_SINDICAL_ID",
	allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HIST_CONTRIB_SINDICAL")
	@Column(name = "ID")
	private Long id;
	
	@Column(name="MES_ANO")
	@Index(name = "IDX_MES_ANO")
	private Date mesAno;
	
	@Column(name="VALOR_PAGO")
	@Index(name = "IDX_VALOR_PAGO")
	private Float valorPago;
	
	
	
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
		HistoricoContribuicaoSindical other = (HistoricoContribuicaoSindical) obj;
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

	public Date getMesAno() {
		return mesAno;
	}

	public void setMesAno(Date mesAno) {
		this.mesAno = mesAno;
	}	

	public Float getValorPago() {
		return valorPago;
	}

	public void setValorPago(Float valorPago) {
		this.valorPago = valorPago;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	

}






package br.com.radconnect.entityBeans;

import java.io.Serializable;

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
@Table(name = "SUBLOCALIZACAO_ITEM_04")
public class SubLocalizacaoItem04 implements Serializable{
	@Id
	@SequenceGenerator(name = "SEQ_SUBLOCALIZACAO_ITEM_04",
	sequenceName = "SEQ_SUBLOCALIZACAO_ITEM_04_ID",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_SUBLOCALIZACAO_ITEM_04")
	private Long id;
	
	@Column(name = "NOME_SUBLOCALIZACAO_ITEM_04")
	@Index(name = "IDX_NOME_SUBLOCALIZACAO_ITEM_04")
	private String nome;
	
	@Column(name= "CODIGO_REFERENTE_SUBLOCALIZACAO_ITEM_04")
	@Index(name = "IDX_CODIGO_REFERENTE_SUBLOCALIZACAO_ITEM_04")
	private String codigoReferente;
	
	//ATRIBUTOS RELACIONAIS
	@ManyToOne
	@JoinColumn(name = "ID_SUBLOCALIZACAO_ITEM_03",referencedColumnName = "ID")	
	private SubLocalizacaoItem03 sublocalizacao03;
	
	
	//TOSTRING
	@Override
	public String toString() {
		return "SubLocalizacaoItem04 [nome=" + nome + "]";
	}
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
		SubLocalizacaoItem04 other = (SubLocalizacaoItem04) obj;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigoReferente() {
		return codigoReferente;
	}
	public void setCodigoReferente(String codigoReferente) {
		this.codigoReferente = codigoReferente;
	}
	public SubLocalizacaoItem03 getSublocalizacao03() {
		return sublocalizacao03;
	}
	public void setSublocalizacao03(SubLocalizacaoItem03 sublocalizacao03) {
		this.sublocalizacao03 = sublocalizacao03;
	}
	
	
	


}

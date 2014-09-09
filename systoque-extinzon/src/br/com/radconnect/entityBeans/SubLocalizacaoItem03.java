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
@Table(name = "SUBLOCALIZACAO_ITEM_03")
public class SubLocalizacaoItem03 implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_SUBLOCALIZACAO_ITEM_03",
	sequenceName = "SEQ_SUBLOCALIZACAO_ITEM_03_ID",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_SUBLOCALIZACAO_ITEM_03")
	private Long id;
	
	@Column(name = "NOME_SUBLOCALIZACAO_ITEM_03")
	@Index(name = "IDX_NOME_SUBLOCALIZACAO_ITEM_03")
	private String nome;
	
	
	//ATRIBUTOS RELACIONAIS
	@ManyToOne
	@JoinColumn(name = "ID_SUBLOCALIZACAO_ITEM_02",referencedColumnName = "ID")
	private SubLocalizacaoItem02 sublocalizacao02;
	
	//TOSTRING
	@Override
	public String toString() {
		return "SubLocalizacaoItem03 [nome=" + nome + "]";
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
		SubLocalizacaoItem03 other = (SubLocalizacaoItem03) obj;
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
	public SubLocalizacaoItem02 getSublocalizacao02() {
		return sublocalizacao02;
	}
	public void setSublocalizacao02(SubLocalizacaoItem02 sublocalizacao02) {
		this.sublocalizacao02 = sublocalizacao02;
	}
	
	

}

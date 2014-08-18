package br.com.radconnect.entityBeans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name = "ITEN_FORNECEDOR")
public class ItenDoFornecedor implements Serializable {
	@Id
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_ITEN", referencedColumnName = "ID")
	private Iten iten;
}

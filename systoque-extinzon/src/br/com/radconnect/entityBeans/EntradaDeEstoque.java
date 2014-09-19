package br.com.radconnect.entityBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "ENTRADA_ESTOQUE")
public class EntradaDeEstoque implements Serializable{
	
	@Id
	@SequenceGenerator(name = "SEQ_ENTRADA_ESTOQUE", sequenceName = "SEQ_ENTRADA_ESTOQUE_ID",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_ENTRADA_ESTOQUE")
	private Long id;
	
	
	@Column(name = "DATA_NOTA_FISCAL_ENTRADA_ESTOQUE")
	@Index(name = "IDX_DATA_NOTA_FISCAL_ENTRADA_ESTOQUE")
	@Temporal(TemporalType.DATE)
	private Date dataDaNotaFiscal;
	
	@Column(name = "DATA_ENTRADA_ESTOQUE")
	@Index(name = "IDX_DATA_ENTRADA_ESTOQUE")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name = "NUMERO_NF_ENTRADA_ESTOQUE")
	@Index(name = "IDX_NUMERO_NF_ENTRADA_ESTOQUE")
	private String numeroNF;
	
	@Column(name = "SERIE_NF_ENTRADA_ESTOQUE")
	@Index(name = "IDX_SERIE_NF_ENTRADA_ESTOQUE")
	private String serieNF;
	
	@Column(name = "CHAVE_DE_ACESSO_NFE_ENTRADA_ESTOQUE")
	@Index(name = "IDX_CHAVE_DE_ACESSO_NFE_ENTRADA_ESTOQUE")
	private String chaveDeAcessoNFE;
	
	@Column(name = "OBSERVACAO_ENTRADA_ESTOQUE")
	@Index(name = "IDX_OBSERVACAO_ENTRADA_ESTOQUE")
	private String observacao;
	
	//ATRIBUTOS RELACIONAIS
	@OneToMany(mappedBy = "entrada",cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<ItemEntrada> listItensDeEntrada = new ArrayList<ItemEntrada>();
	
	//FIM DOS ATRIBUTOS RELACIONAIS
	
	//METODOS PARA ADICOINAR OU REMOVER ITENS DE ENTRADA
	public void adicionaItensdeEntrada(ItemEntrada itemDeEntrada){
		itemDeEntrada.setEntrada(this);
		this.listItensDeEntrada.add(itemDeEntrada);
	}
	
	public void removerItensDeEntrada(ItemEntrada itemEntrada){
		if(this.listItensDeEntrada.contains(itemEntrada)){
			this.listItensDeEntrada.remove(itemEntrada);
		}
	}
	//FIM DOS METODOS PARA ADICIONAR  E REMOVER ITENS DE ENTRADA
	
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
		EntradaDeEstoque other = (EntradaDeEstoque) obj;
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
	public Date getDataDaNotaFiscal() {
		return dataDaNotaFiscal;
	}
	public void setDataDaNotaFiscal(Date dataDaNotaFiscal) {
		this.dataDaNotaFiscal = dataDaNotaFiscal;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getNumeroNF() {
		return numeroNF;
	}
	public void setNumeroNF(String numeroNF) {
		this.numeroNF = numeroNF;
	}
	public String getSerieNF() {
		return serieNF;
	}
	public void setSerieNF(String serieNF) {
		this.serieNF = serieNF;
	}
	public String getChaveDeAcessoNFE() {
		return chaveDeAcessoNFE;
	}
	public void setChaveDeAcessoNFE(String chaveDeAcessoNFE) {
		this.chaveDeAcessoNFE = chaveDeAcessoNFE;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public List<ItemEntrada> getListItensDeEntrada() {
		return listItensDeEntrada;
	}
	public void setListItensDeEntrada(List<ItemEntrada> listItensDeEntrada) {
		this.listItensDeEntrada = listItensDeEntrada;
	}
	
	


}

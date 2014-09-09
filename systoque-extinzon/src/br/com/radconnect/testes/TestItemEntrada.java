package br.com.radconnect.testes;

import javax.persistence.EntityManager;

import com.sun.xml.internal.fastinfoset.algorithm.IEEE754FloatingPointEncodingAlgorithm;

import br.com.radconnect.daos.DaoEstoque;
import br.com.radconnect.entityBeans.EntradaDeEstoque;
import br.com.radconnect.entityBeans.Item;
import br.com.radconnect.entityBeans.ItemEntrada;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

public class TestItemEntrada {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		ItemEntrada iE = new ItemEntrada();
		Item it = new Item();
		EntradaDeEstoque eE = new EntradaDeEstoque();
		DaoEstoque dao = new DaoEstoque();
		
		it.setNomeCurto("TELA");
		it.setNomeItem("MONITOR");
		it.setMarcaFabricante("SONY");
		
		eE.setTotalDaCompra(1000D);
		eE.setValorFrete(10000D);
		
		iE.setEntrada(eE);
		iE.setItem(it);
		iE.setNumeroDoLote(1200000L);
		iE.setQtdDeItens(1000);
		iE.setValorDoItem(1000D);
		
		dao.persistirItemEntrada(iE);
		
		System.out.println("CADASTRADO COM DAO OK!!!!");
		
		
		
		
	
		

	}

}

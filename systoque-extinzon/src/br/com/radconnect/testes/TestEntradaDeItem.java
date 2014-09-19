package br.com.radconnect.testes;





import br.com.radconnect.daos.DaoEstoque;
import br.com.radconnect.entityBeans.EntradaDeEstoque;
import br.com.radconnect.entityBeans.Item;
import br.com.radconnect.entityBeans.ItemEntrada;


public class TestEntradaDeItem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DaoEstoque dao = new DaoEstoque();
		EntradaDeEstoque entradaDeItem = new EntradaDeEstoque();
		ItemEntrada itemEntrada = new ItemEntrada();	
		Item item = new Item();
		
		itemEntrada.setQtdDeItens(40D);
		itemEntrada.setValorDeDescontos(4D);
		itemEntrada.setValorUnitarioDoItem(400D);
		/*
		item.setCodigo("10001");
		item.setGtinEan("ean");
		item.setMarcaFabricante("EXTINPO");
		item.setNome("PO QUIMICO");
		item.setNomeCurto("CO2");
		item.setNumeroFabricante("1092883");
		
		*/
		item = dao.retornoItem(1L);
		/*
		
		
		itemEntrada.setItem(item);	
		
		entradaDeItem.setChaveDeAcessoNFE("1111111111");
		entradaDeItem.setNumeroNF("11111111");
		entradaDeItem.setObservacao("1111111111");
		entradaDeItem.adicionaItensdeEntrada(itemEntrada);
		
		dao.persistirEntradaDeItem(entradaDeItem);
		
		System.out.println("CADASTRADO COM DAO OK!!!!");
		*/
		for(int i = 0; i < item.getListItemEntrada().size();i++){
			System.out.println("NUMERO DO ID DE ENTRADA : "+item.getListItemEntrada().get(i).getEntrada().getId());
			System.out.println("CHAVE DE ACESSO DA NFE : "+
			item.getListItemEntrada().get(i).getEntrada().getChaveDeAcessoNFE());
			System.out.println("\n"+"\n");
		}
		

	}

}

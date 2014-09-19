package br.com.radconnect.daos.interfaces;

import java.util.List;

import br.com.radconnect.entityBeans.EntradaDeEstoque;
import br.com.radconnect.entityBeans.Item;
import br.com.radconnect.entityBeans.ItemEntrada;

public interface IEstoque {
	public void persistirEntradaDeItem(EntradaDeEstoque entrada);
	public void persistirItem(Item item);
	public void removerEntradaDeItem(EntradaDeEstoque entrada);
	public List<ItemEntrada> procurarItensEntrada (String pesquisa,String filtro);
	public List<ItemEntrada> listItensEntrada();
	public List<Item> listItens(String pesquisa,String Filtro);

}

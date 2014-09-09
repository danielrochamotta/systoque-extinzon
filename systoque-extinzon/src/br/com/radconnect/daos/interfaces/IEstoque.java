package br.com.radconnect.daos.interfaces;

import java.util.List;

import br.com.radconnect.entityBeans.EntradaDeEstoque;
import br.com.radconnect.entityBeans.ItemEntrada;

public interface IEstoque {
	public void persistirItemEntrada(ItemEntrada itemEntrada);
	public void removerItemEntrada(ItemEntrada itemEntrada);
	public List<ItemEntrada> procurarItensEntrada (String pesquisa,String filtro);
	public List<ItemEntrada> listItensEntrada();

}

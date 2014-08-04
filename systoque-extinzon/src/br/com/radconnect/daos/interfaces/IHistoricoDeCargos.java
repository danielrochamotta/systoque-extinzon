package br.com.radconnect.daos.interfaces;


import br.com.radconnect.entityBeans.HistoricoDeCargos;

public interface IHistoricoDeCargos {

	public void gravar(HistoricoDeCargos registro);
	
	public void excluir(HistoricoDeCargos registro);
	
	
}

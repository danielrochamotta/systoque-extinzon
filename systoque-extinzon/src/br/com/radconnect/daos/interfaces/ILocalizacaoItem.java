package br.com.radconnect.daos.interfaces;

import java.util.List;

import br.com.radconnect.entityBeans.LocalizacaoItem;

public interface ILocalizacaoItem {
	public void persistirLocalizacao(LocalizacaoItem localizacao);
	public void removerLocalizacao(LocalizacaoItem localizacao);
	public List<LocalizacaoItem> procurarLocalizacao(String pesquisa,String Filtro);

}

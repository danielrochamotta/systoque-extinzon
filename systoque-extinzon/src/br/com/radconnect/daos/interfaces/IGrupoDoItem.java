package br.com.radconnect.daos.interfaces;

import java.util.List;

import br.com.radconnect.entityBeans.GrupoDoItem;

public interface IGrupoDoItem {
	public void persistirGrupo(GrupoDoItem grupo);
	public void removerGrupo(GrupoDoItem grupo);
	public List<GrupoDoItem> procurarGrupo(String pesquisa,String filtro);

}

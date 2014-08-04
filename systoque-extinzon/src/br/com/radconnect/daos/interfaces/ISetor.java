package br.com.radconnect.daos.interfaces;

import java.util.List;

import br.com.radconnect.entityBeans.Setor;

public interface ISetor {
	
	public void gravarSetor(Setor setor);
	
	public void editarSetor(Setor setor);
	
	public void removerSetor(Setor setor);
	
	public List<Setor> listSetor();
	
	
}

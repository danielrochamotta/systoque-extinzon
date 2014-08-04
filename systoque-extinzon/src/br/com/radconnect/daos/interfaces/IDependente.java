package br.com.radconnect.daos.interfaces;

import java.util.List;

import br.com.radconnect.entityBeans.Dependente;

public interface IDependente {
	
	public void cadastraDependente(Dependente dependente);
	
	public void editaDependente(Dependente dependente);
	
	public void excluiDependente(Dependente dependente);
	
	public Dependente localizaDependenteId(Long id);
	
	public List<Dependente> listDependente();

}

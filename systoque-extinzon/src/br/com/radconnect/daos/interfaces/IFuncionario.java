package br.com.radconnect.daos.interfaces;

import java.util.List;

import br.com.radconnect.entityBeans.Funcionario;

public interface IFuncionario {

	public void cadastrarFuncionario(Funcionario funcionario);
	
	public void removerFuncionario(Funcionario funcionario);
	
	public void editarFuncionario(Funcionario funcionario);
	
	public List<Funcionario> listFuncionario();
	
	public Funcionario listFuncionarioEspecifico(Long matricula);
}

package br.com.radconnect.daos.interfaces;

import java.util.List;

import br.com.radconnect.entityBeans.Cliente;
import br.com.radconnect.entityBeans.Fornecedor;

public interface IFornecedor {
	
	public void persistirFornecedor(Fornecedor fornecedor);
	
	public void removerFornecedor(Fornecedor fornecedor);
	
	public List<Fornecedor> procurarFornecedor(String pesquisa,String filtro);

}

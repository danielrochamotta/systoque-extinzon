package br.com.radconnect.daos.interfaces;

import java.util.List;

import br.com.radconnect.entityBeans.Cliente;

public interface ICliente {
	
	public void persistirCliente(Cliente cliente);
	
	public void removerCliente(Cliente cliente);
	
	public List<Cliente> procurarCliente(String pesquisa,String filtro);

}

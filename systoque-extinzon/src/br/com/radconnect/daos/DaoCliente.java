package br.com.radconnect.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radconnect.daos.interfaces.ICliente;
import br.com.radconnect.entityBeans.Cliente;
import br.com.radconnect.jpaUtil.EntityManagerUtil;


public class DaoCliente implements ICliente{
	
	private EntityManager em;
	
	public DaoCliente(){
		em = EntityManagerUtil.getEntityManager();
	}

	@Override
	public void cadastrarCliente(Cliente cliente) {
		try{
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
		}catch(Exception e){
			if(em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void removerCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}
	
	public String limpaPesquisa(String pesquisa){
		pesquisa = pesquisa.replaceAll("[';-]", "");
		
		return pesquisa;
	}

	@Override
	public List<Cliente> procurarCliente(String pesquisa, String filtro) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

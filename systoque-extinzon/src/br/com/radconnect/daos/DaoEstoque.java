package br.com.radconnect.daos;

import java.util.List;

import javax.persistence.EntityManager;



import br.com.radconnect.daos.interfaces.IEstoque;
import br.com.radconnect.entityBeans.EntradaDeEstoque;
import br.com.radconnect.entityBeans.ItemEntrada;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

public class DaoEstoque implements IEstoque{
	private EntityManager em;
	
	public DaoEstoque(){
		em = EntityManagerUtil.getEntityManager();
	}	
	
	@Override
	public void persistirItemEntrada(ItemEntrada itemEntrada) {
		try{
			em.getTransaction().begin();
			if(itemEntrada.getId() == null){
				em.persist(itemEntrada);
			}else{
				em.merge(itemEntrada);
			}
			em.getTransaction().commit();
			
		}catch(Exception e){
			if(em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
		}
		
	}
	@Override
	public void removerItemEntrada(ItemEntrada itemEntrada) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public List<ItemEntrada> procurarItensEntrada(String pesquisa, String filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemEntrada> listItensEntrada() {
		
		return em.createQuery("from ItemEntrada order by id").getResultList();
	}

}

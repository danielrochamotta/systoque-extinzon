package br.com.radconnect.daos;

import java.util.List;

import javax.persistence.EntityManager;



import br.com.radconnect.daos.interfaces.IEstoque;
import br.com.radconnect.entityBeans.EntradaDeEstoque;
import br.com.radconnect.entityBeans.Item;
import br.com.radconnect.entityBeans.ItemEntrada;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

public class DaoEstoque implements IEstoque{
	private EntityManager em;
	
	public DaoEstoque(){
		em = EntityManagerUtil.getEntityManager();
	}	
	
	@Override
	public void persistirEntradaDeItem(EntradaDeEstoque entrada) {
		try{
			em.getTransaction().begin();
			if(entrada.getId() == null || entrada.getId() == 0L){
				em.persist(entrada);
			}else{
				em.merge(entrada);
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
	public void persistirItem(Item item) {
		try{
			em.getTransaction().begin();
			if(item.getId() == null || item.getId() == 0L){
				em.persist(item);
			}else{
				em.merge(item);
			}
			em.getTransaction().commit();
			
		}catch(Exception e){
			if(em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
		}
		
	}
	
	public Item retornoItem(Long id){
		return em.find(Item.class, id);
	}
	
	@Override
	public void removerEntradaDeItem(EntradaDeEstoque entrada) {
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

	@Override
	public List<Item> listItens(String pesquisa, String Filtro) {
		
		return em.createQuery("from Item order by id").getResultList();
	}

}

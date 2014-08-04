package br.com.radconnect.daos;

import javax.persistence.EntityManager;

import br.com.radconnect.daos.interfaces.IHistoricoDeCargos;
import br.com.radconnect.entityBeans.HistoricoDeCargos;
import br.com.radconnect.jpaUtil.EntityManagerUtil;



public class DaoHistDeCargos {
	
	private EntityManager em;
	
	public DaoHistDeCargos(){
		em = EntityManagerUtil.getEntityManager();
	}
/*
	@Override
	public void gravar(HistoricoDeCargos registro) {
		// TODO Auto-generated method stub 
		try{
			if(registro.getId() == 0L || registro.getId() == null){
				em.getTransaction().begin();
				em.persist(registro);
				em.getTransaction().commit();
			}else{
				em.getTransaction().begin();
				em.merge(registro);
				em.getTransaction().commit();
			}
			
		}catch(Exception e){
			if(em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			
		}
		
	}

	@Override
	public void excluir(HistoricoDeCargos registro) {
		// TODO Auto-generated method stub
		try{
			em.getTransaction().begin();
			em.remove(registro);
			em.getTransaction().commit();
			
		}catch(Exception e){
			if(em.getTransaction().isActive() == false){
				em.getTransaction().rollback();
			}
		}
		
	}
	

	
*/
}

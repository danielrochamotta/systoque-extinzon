package br.com.radconnect.daos;

import java.util.List;

import javax.persistence.EntityManager;



import br.com.radconnect.daos.interfaces.ISetor;
import br.com.radconnect.entityBeans.Setor;
import br.com.radconnect.jpaUtil.EntityManagerUtil;




public class DaoSetor implements ISetor{
	
	private EntityManager em;
	
	public DaoSetor(){
		em = EntityManagerUtil.getEntityManager();
	}
	
	public void gravarSetor(Setor setor){
		try{
			
				em.getTransaction().begin();
				em.persist(setor);
				em.getTransaction().commit();
			
			
		}catch(Exception e){
			if(em.getTransaction().isActive() ==  false){
				em.getTransaction().rollback();
			}
		}
		
		
	}
	@Override
	public void editarSetor(Setor setor) {
		try{
			em.getTransaction().begin();
			em.merge(setor);
			em.getTransaction().commit();
		}catch(Exception e){
			if(em.getTransaction().isActive() == false){
				em.getTransaction().rollback();
			}
		}
		
	}

	@Override
	public void removerSetor(Setor setor) {
		// TODO Auto-generated method stub
		
		try{
			em.getTransaction().begin();
			em.remove(setor);
			em.getTransaction().commit();
			
		}catch(Exception e){
			if(em.getTransaction().isActive() == false){
				em.getTransaction().rollback();
			}
		}
				
	}

	@Override
	public List<Setor> listSetor() {
		// TODO Auto-generated method stub
		
		
		return (List<Setor>) em.createQuery("from Setor order by nome").getResultList();
	}

	

	
	
	
}

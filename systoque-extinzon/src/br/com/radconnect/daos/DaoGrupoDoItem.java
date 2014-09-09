package br.com.radconnect.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radconnect.daos.interfaces.IGrupoDoItem;
import br.com.radconnect.entityBeans.GrupoDoItem;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

public class DaoGrupoDoItem implements IGrupoDoItem{
	
	private EntityManager em;
	
	public DaoGrupoDoItem(){
		em = EntityManagerUtil.getEntityManager();
	}

	@Override
	public void persistirGrupo(GrupoDoItem grupo) {
		
		try{
			em.getTransaction().begin();
			if(grupo.getId() == null){
				em.persist(grupo);
			}else{
				em.merge(grupo);
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
	public void removerGrupo(GrupoDoItem grupo) {
		try{
			em.getTransaction().begin();
			em.remove(grupo);
			em.getTransaction().commit();
			
		}catch(Exception e){
			if(em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public List<GrupoDoItem> procurarGrupo(String pesquisa, String filtro) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

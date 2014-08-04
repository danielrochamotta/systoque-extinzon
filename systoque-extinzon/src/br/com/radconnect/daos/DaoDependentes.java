package br.com.radconnect.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radconnect.daos.interfaces.IDependente;
import br.com.radconnect.entityBeans.Dependente;
import br.com.radconnect.entityBeans.Funcionario;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

public class DaoDependentes implements IDependente {
	
	private EntityManager em;
	
	public DaoDependentes(){
		em = EntityManagerUtil.getEntityManager();
	}

	@Override
	public void cadastraDependente(Dependente dependente) {
		try{
			em.getTransaction().begin();
			em.persist(dependente);
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
	public void editaDependente(Dependente dependente) {
		try{
			em.getTransaction().begin();
			em.merge(dependente);
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
	public void excluiDependente(Dependente dependente) {
		try{
			em.getTransaction().begin();
			em.remove(dependente);
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
	public Dependente localizaDependenteId(Long id) {
		
		
		return em.find(Dependente.class, id);
	}

	@Override
	public List<Dependente> listDependente() {
		// TODO Auto-generated method stub
		return (List<Dependente>) em.createQuery("from Dependente order by idDependente");
	}
	
	public List<Dependente> listDependeteDoFuncionario(Funcionario funcionario){
		if (funcionario.getId() != null || funcionario.getId() != 0L){
		return  (List<Dependente>) 
				em.createQuery("from Dependente where funcionario.id = "+
		":id").setParameter("id", funcionario.getId()).getResultList();
		
		}else{
			return null;
		}
		
	}

}

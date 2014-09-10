package br.com.radconnect.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radconnect.daos.interfaces.ILocalizacaoItem;
import br.com.radconnect.entityBeans.LocalizacaoItem;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

public class DaoLocalizacaoDeItem implements ILocalizacaoItem{
	
	private EntityManager em;
	
	public DaoLocalizacaoDeItem(){
		em = EntityManagerUtil.getEntityManager();
	}

	@Override
	public void persistirLocalizacao(LocalizacaoItem localizacao) {
		em.getTransaction().begin();
		try{
			
			if(localizacao.getId() == null){
				
				em.persist(localizacao);
			}else{
				em.merge(localizacao);
				
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
	public void removerLocalizacao(LocalizacaoItem localizacao) {
		try{
			em.getTransaction().begin();
			em.remove(localizacao);
			em.getTransaction().commit();
			
		}catch(Exception e){
			if(em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public List<LocalizacaoItem> procurarLocalizacao(String pesquisa,
			String Filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}

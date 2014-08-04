package br.com.radconnect.jpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	private static EntityManagerFactory factory;
	
	private static EntityManager em;
	
	public static EntityManager getEntityManager(){
		if(factory == null){
			factory = Persistence.createEntityManagerFactory("systoque-extinzon");
		}
		if(em == null){
			em = factory.createEntityManager();
		}
		return em;
	}

}

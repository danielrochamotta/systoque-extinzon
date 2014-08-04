package br.com.radconnect.testes;

import javax.persistence.EntityManager;

import br.com.radconnect.entityBeans.Funcionario;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		Funcionario fc = new Funcionario();
		
		fc.setNome("lais");
		
		em.getTransaction().begin();		
		em.persist(fc);
		em.getTransaction().commit();

	}

}

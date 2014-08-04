package br.com.radconnect.testes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.radconnect.entityBeans.Cargo;
import br.com.radconnect.entityBeans.Setor;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

public class TestSetor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = EntityManagerUtil.getEntityManager();
		Setor st = new Setor();
		/*TESTE DE 
		 * INCLUSAO DE REGISTROS
		 * 
		
		List<String> listNomeSetor = new ArrayList<String>();
		listNomeSetor.add("PRODUÇÃO");
		listNomeSetor.add("ADMINISTRATIVO");
		listNomeSetor.add("FINANCEIRO");
		listNomeSetor.add("COLETAS");
		listNomeSetor.add("DIRETORIA");
		
		for(int i = 0; i < listNomeSetor.size();i++){
			
			st = new Setor();
						
			st.setNomeSetor(listNomeSetor.get(i).toString());
			
			em.getTransaction().begin();
			em.persist(st);
			em.getTransaction().commit();
			
		}
		*/
		
		st = em.find(Setor.class, 4L);
		
		Cargo cg = new Cargo();
		//cg = em.find(Cargo.class, 4L);
		//cg.setSetorCargo(null);
		cg.setNome("MOTORISTA");
		cg.setSetor(st);
		
		
		
		/*
		 * 
		 
		for(int i = 0 ; i < cg.getListFuncionarioCargo().size(); i++){
			cg.getListFuncionarioCargo().get(i).setCargoFuncionario(null);
			
			em.getTransaction().begin();
			em.merge(cg.getListFuncionarioCargo().get(i));
			em.getTransaction().commit();
			
		}
	*/
		//cg.setListFuncionarioCargo(null);
		em.getTransaction().begin();
		em.persist(cg);
		em.getTransaction().commit();
		
		

	}

}

package br.com.radconnect.testes;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;
import javax.persistence.EntityManager;
import br.com.radconnect.entityBeans.Dependente;
import br.com.radconnect.entityBeans.Funcionario;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

public class TestFuncionarioDependente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = EntityManagerUtil.getEntityManager();
		Dependente fcDep = new Dependente();
		
		/*
		 * INCLUSAO DE DEPENDENTES
		 
				
		
		fcDep.setFuncDependenteNome("GUSTAVO");
		fcDep.setFuncDependenteParentesco("FILHA");
		
		
		try{
			//DATE FORMAT
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			//DATE CONVERTER
		
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		//fcDep = em.find(Dependente.class, 3L);
		//fcDep.setFuncionario(null);
		*/
		
		
		//dao.cadastraDependente(fcDep);
		 Funcionario func = new Funcionario();
		 
		 //func = em.find(Funcionario.class,1L);
		 
		 func.setNome("Daniel");
		 func.setRgNumero("20019921002121");
		 func.setCpf("20012399021");
		 
		Dependente dependente1 = new Dependente();
		Dependente dependente2 = new Dependente();
		Dependente dependente3 = new Dependente();
		
		dependente1.setFuncionario(func);
		dependente2.setFuncionario(func);
		dependente3.setFuncionario(func);
		
		dependente1.setNome("JOAO");
		dependente1.setParentesco("Pai");
		
		dependente2.setNome("JOSE");
		dependente2.setParentesco("FILHO");
		
		dependente3.setNome("MARIA");
		dependente3.setParentesco("MAE");
		
		func.adicionaDependente(dependente1);
		func.adicionaDependente(dependente2);
		func.adicionaDependente(dependente3);
		
		em.getTransaction().begin();
		em.persist(func);
		em.getTransaction().commit();
		 
		 //listDependentes = dao.listDependeteDoFuncionario(func);
		 
		 /*
		  * 
		  
		 
		 for(int i = 0; i < listDependentes.size(); i++){
			 System.out.println(listDependentes.get(i).getFuncDependenteNome());
		 }
	   */
	}

}

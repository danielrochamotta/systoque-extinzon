package br.com.radconnect.testes;

import javax.persistence.EntityManager;


import br.com.radconnect.entityBeans.Cliente;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

public class TesteCliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		Cliente teste = new Cliente();
		
		
		teste.setNomeRazaoSocial("JOSE");
		
		teste.setRgInsEstadual("21321321");
		teste.setCpfCnpj("988982133");
		teste.setTelefone("3432432432");
		teste.setCelular("898989899");
		teste.setEmail("jose@gmail.com");
		
		em.getTransaction().begin();
		em.persist(teste);
		em.getTransaction().commit();

	}

}

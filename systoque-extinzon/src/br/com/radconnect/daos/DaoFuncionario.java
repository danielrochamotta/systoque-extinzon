package br.com.radconnect.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radconnect.daos.interfaces.IFuncionario;
import br.com.radconnect.entityBeans.Dependente;
import br.com.radconnect.entityBeans.Funcionario;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

public class DaoFuncionario implements IFuncionario {
	
	private EntityManager em;
	private int maximoObjetos = 5;
	private int posicao = 0;
	private int totalObjetos = 0;
	
	public DaoFuncionario(){
		em = EntityManagerUtil.getEntityManager();
	}

	@Override
	public void persistirFuncionario(Funcionario funcionario) {
		
		try{
			em.getTransaction().begin();
			if(funcionario.getId() == null){
				em.persist(funcionario);
			}else{
				em.merge(funcionario);
			}
			
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
	public void removerFuncionario(Funcionario funcionario) {
		try{
			em.getTransaction().begin();
			em.remove(funcionario);
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
	public void editarFuncionario(Funcionario funcionario) {
		
		try{			
			
			
			em.getTransaction().begin();
			em.merge(funcionario);
			em.getTransaction().commit();
			
			
			
		}catch(Exception e){
			if(em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> listFuncionario() {
		
		return (List<Funcionario>) em.createQuery("from Funcionario order by matricula").getResultList();
	}

	@Override
	public Funcionario listFuncionarioEspecifico(Long id) {

		return em.find(Funcionario.class, id);
	}
	
	public String limpaPesquisa(String pesquisa){
		pesquisa = pesquisa.replaceAll("[';-]", "");
		
		return pesquisa;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> procuraFuncionario(String pesquisa,String filtro){
		String jpql = "";		
		String where = "";	
		
		if(pesquisa != null && pesquisa.length() > 0){
			pesquisa= limpaPesquisa(pesquisa);
			if(filtro.equals("id")){
				try{
				Long.parseLong(pesquisa);
				where = " where "+ filtro +" like '"+ pesquisa +"%' ";
				}catch(Exception e){
					
				}
			}else{
				
				where = " where upper("+ filtro +") like '"+pesquisa.toUpperCase()+"%' ";
		}
			jpql = "from Funcionario "+ where +" order by "+filtro;	
		}else{
			jpql = "from Funcionario";
		}
		
		     
		totalObjetos = em.createQuery(jpql).
				getResultList().size();
		if(posicao > totalObjetos){
			posicao = 0;
		}
		
		return em.createQuery(jpql).setFirstResult(posicao).setMaxResults(maximoObjetos).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> imprimirTodos(String pesquisa,String filtro){
		String jpql = "";		
		String where = "";	
		
		if(pesquisa != null && pesquisa.length() > 0){
			pesquisa= limpaPesquisa(pesquisa);
			if(filtro.equals("id")){
				try{
				Long.parseLong(pesquisa);
				where = " where "+ filtro +" like '"+ pesquisa +"%' ";
				}catch(Exception e){
					
				}
			}else{
				
				where = " where upper("+ filtro +") like '"+pesquisa.toUpperCase()+"%' ";
		}
			jpql = "from Funcionario "+ where +" order by "+filtro;	
		}else{
			jpql = "from Funcionario";
		}
		
		     
		totalObjetos = em.createQuery(jpql).
				getResultList().size();
		if(posicao > totalObjetos){
			posicao = 0;
		}
		
		return em.createQuery(jpql).getResultList();
	}
	
	public void primeiro(){
		posicao = 0;
	}
	
	public void anterior(){
		posicao -= maximoObjetos;
		if (posicao < 0){
			posicao = 0;
		}
	}
	
	public void proximo(){
		if (posicao + maximoObjetos < totalObjetos){
			posicao += maximoObjetos;
		}
	}
	
	public void ultimo(){
		if(totalObjetos == 0 || posicao > totalObjetos){
			posicao = 0;
		}else{
		int resto = totalObjetos % maximoObjetos;
		if (resto > 0){
			posicao = totalObjetos - resto;
		} else{
			posicao = totalObjetos - maximoObjetos;
		}
	  }	  
	}
	
	public String getMensagemNavegacao(){
		int ate = posicao + maximoObjetos;
		if (ate > totalObjetos){
			ate = totalObjetos;
		}
		return "Listando de " + (posicao + 1)+
				" até "+ ate + " de " +totalObjetos+ " registros";
	}
	
	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	public int getMaximoObjetos() {
		return maximoObjetos;
	}

	public void setMaximoObjetos(int maximoObjetos) {
		this.maximoObjetos = maximoObjetos;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public int getTotalObjetos() {
		return totalObjetos;
	}

	public void setTotalObjetos(int totalObjetos) {
		this.totalObjetos = totalObjetos;
	}

	
}

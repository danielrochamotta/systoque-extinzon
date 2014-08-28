package br.com.radconnect.daos;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.radconnect.daos.interfaces.IFornecedor;
import br.com.radconnect.entityBeans.Fornecedor;
import br.com.radconnect.jpaUtil.EntityManagerUtil;


public class DaoFornecedor implements IFornecedor{
	
	private EntityManager em;
	private int maximoObjetos = 5;
	private int posicao = 0;
	private int totalObjetos = 0;
	
	public DaoFornecedor(){
		em = EntityManagerUtil.getEntityManager();
	}

	@Override
	public void persistirFornecedor(Fornecedor fornecedor) {
		try{			
			em.getTransaction().begin();
			if(fornecedor.getId() == null){
				em.persist(fornecedor);
			}else{
				em.merge(fornecedor);
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
	public void removerFornecedor(Fornecedor fornecedor) {
		try{
			em.getTransaction().begin();
			em.remove(fornecedor);
			em.getTransaction().commit();
		}catch(Exception e){
			if(em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
		}
		
	}
	
	public String limpaPesquisa(String pesquisa){
		pesquisa = pesquisa.replaceAll("[';-]", "");
		
		return pesquisa;
	}

	@Override
	public List<Fornecedor> procurarFornecedor(String pesquisa, String filtro) {
		String jpql = "";		
		String where = "";	
		
		if(pesquisa != null && pesquisa.length() > 0){
			pesquisa = limpaPesquisa(pesquisa);
			if(filtro.equals("id")){
				try{
				Long.parseLong(pesquisa);
				where = " where "+ filtro +" like '"+ pesquisa +"%' ";
				}catch(Exception e){
					
				}
			}else{
				
				where = " where upper("+ filtro +") like '"+pesquisa.toUpperCase()+"%' ";
		}
			jpql = "from Fornecedor "+ where +" order by "+filtro;	
		}else{
			jpql = "from Fornecedor";
		}
		
		     
		totalObjetos = em.createQuery(jpql).
				getResultList().size();
		if(posicao > totalObjetos){
			posicao = 0;
		}
		
		return em.createQuery(jpql).setFirstResult(posicao).setMaxResults(maximoObjetos).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> imprimirTodos(String pesquisa,String filtro){
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
			jpql = "from Fornecedor "+ where +" order by "+filtro;	
		}else{
			jpql = "from Fornecedor";
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

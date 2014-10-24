package br.com.radconnect.daos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.radconnect.daos.interfaces.IUsuario;
import br.com.radconnect.entityBeans.Usuario;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

public class DaoUsuario implements IUsuario{
	
	private EntityManager em;
	
	public DaoUsuario(){
		em = EntityManagerUtil.getEntityManager();
	}

	@Override
	public void persistirUsuario(Usuario usuario) {		
		
		try{
			em.getTransaction().begin();
			if(usuario.getId() == null){
				em.persist(usuario);
			}else{
				em.merge(usuario);
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
	public void removerUsuario(Usuario usuario) {
		try{
			em.getTransaction().begin();
			em.remove(usuario);			
			em.getTransaction().commit();
			
		}catch(Exception e){
			if(em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public List<Usuario> listUsuario() {
		
		return em.createQuery("from Usuario order by nome").getResultList();
	}

	@Override
	public Boolean validaUsuario(String nomeUsuario, String senhaUsuario) {
		Query query = em.createQuery("from Usuario where nome =: nomeUsuario "+
	       "and senha =: senhaUsuario");
		query.setParameter("nomeUsuario", nomeUsuario);
		query.setParameter("senhaUsuario", senhaUsuario);
		if(!query.getResultList().isEmpty()){
			return true;
		}else{
			return false;
		}
		
		
	}

	@Override
	public Usuario localizaUsuario(Long id) {
		
		return em.find(Usuario.class, id);
	}

	@Override
	public Usuario localizaUsuarioPorNome(String nomeUsuario) {
		
		return (Usuario) em.createQuery("from Usuario where nome =: nomeUsuario").
				setParameter("nomeUsuario", nomeUsuario).
				getSingleResult();
	}

}

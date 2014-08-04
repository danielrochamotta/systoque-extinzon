package br.com.radconnect.daos;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.radconnect.daos.interfaces.ICargo;
import br.com.radconnect.entityBeans.Cargo;
import br.com.radconnect.entityBeans.Dependente;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

public class DaoCargo implements ICargo {
	
	private EntityManager em;
	
	public DaoCargo(){
		em = EntityManagerUtil.getEntityManager();
	}

	@Override
	public List<Cargo> localizadoPorNome(String nomeCargo) {
		if (nomeCargo == null || nomeCargo.equals("")){
			return  (List<Cargo>) 
					em.createQuery("from Cargo where cargo.nome = "+
			        ":nome").setParameter("nome", nomeCargo).getResultList();
			
			}else{
				return null;
			}
	}
	
	public Cargo doId(Long id){
		return (Cargo) em.find(Cargo.class, id);
	}

}

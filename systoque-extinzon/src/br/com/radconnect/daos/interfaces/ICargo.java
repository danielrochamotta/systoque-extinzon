package br.com.radconnect.daos.interfaces;

import java.util.List;

import br.com.radconnect.entityBeans.Cargo;

public interface ICargo {
	
	public List<Cargo> localizadoPorNome(String nomeCargo);

}

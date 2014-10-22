package br.com.radconnect.testes;

import br.com.radconnect.daos.DaoUsuario;
import br.com.radconnect.entityBeans.Usuario;

public class TesteUsuario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Usuario user = new Usuario();
		DaoUsuario dao = new DaoUsuario();
		
		user.setNome("Daniel");
		user.setSenha("123");
		
		dao.persistirUsuario(user);

	}

}

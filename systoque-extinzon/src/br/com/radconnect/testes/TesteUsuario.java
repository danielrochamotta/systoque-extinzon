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
	
	
	
	
	System.out.println(dao.validaUsuario("daniel", "123"));
	System.out.println();

	}

}

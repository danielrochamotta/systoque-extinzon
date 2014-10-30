package br.com.radconnect.daos.interfaces;

import java.util.List;

import br.com.radconnect.entityBeans.Usuario;

public interface IUsuario {
	
	public void persistirUsuario(Usuario usuario);
	
	public void removerUsuario(Usuario usuario);
	
	public List<Usuario> listUsuario();
	
	public Usuario validaUsuario(String nomeUsuario, String senhaUsuario);
	
	public Usuario localizaUsuario(Long id);
	
	public Usuario localizaUsuarioPorNome(String nomeUsuario);

}

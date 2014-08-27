package br.com.radconnect.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.radconnect.daos.DaoCliente;
import br.com.radconnect.entityBeans.Cliente;

@SuppressWarnings("serial")
@Named
@ConversationScoped
public class CadastroClienteController implements Serializable{
	
	@Inject
	Conversation conversation;
	
	private Cliente doCadastroController;
	private DaoCliente dao;
	private String filtroPesquisaCli;
	private String atributoPesquisaCli;
	
	@PostConstruct
	public void iniciaCadastroClienteMB(){
		conversation.begin();
		dao = new DaoCliente();
		
	}
	
	//METODOS PARA NAVEGAÇÃO DE PÁGINAS
	
	public String novoCliente(){//METODO PARA IR PARA PÁGINA DO FORM DE CLIENTE
		doCadastroController = new Cliente();
		return "novocli";
	}
	
	public String voltarParaHome(){//METODO PARA IR PARA PÁGINA HOME
		return "home";
	}
	
	public String opcaoParaCliente(){//METODO PARA IR PARA PAGINA DE OPCOES DO CLIENTE
		return "opcaocli";
	}
	
	public String irParaEdicaoDeCliente(){//METODO PARA IR PARA FORM  DE EDICAO COM CLIENTE DA TELA
		
		return "editcli";
	}
	
	public String irParaListagemDeClientes(){
		return "listcli";
	}
	
	//METODOS DE PERSISTENCIA
	
	public String persistirCliente(){//METODO PARA GRAVAR UM NOVO CLIENTE
		conversation.end();
		dao.persistirCliente(doCadastroController);
		return "listcli?faces-redirect=true";
	}
	
	
	public void removerClienteDoBanco(){//METODO PARA REMOVER CLIENTE DO BANCO
		dao.removerCliente(doCadastroController);
	}
	
	//METODOS PARA PESQUISA E LISTAGEM
	
	public List<Cliente> getListCliente(){//METODO QUE RETORNA LSITA DE CLIENTES DO BANCO
		return dao.procurarCliente(atributoPesquisaCli, filtroPesquisaCli);
	}
	
	
	/*
	 * METODOS DOS BOTOES DE PAGINACAO DA LISTAGEM DOS FUNCIONÁRIOS
	 */
	public void primeiro(){//executa metodo que vai para primeira pagina
		dao.primeiro();
	}//fim do metodo primerio
	
	public void anterior(){//executa metodo que volta pagina de regitro de funcionarios
		dao.anterior();
	}//fim do metodo anteriror
	
	public void proximo(){//executa metodo que passa para proxima pagina de registro de funcioanrios
		dao.proximo();
	}//fim do metodo proximo
	
	public void ultimo(){//executa metodo para ultima pagina de registro de funcionarios
		dao.ultimo();
	}//fim do metodo ultimo
	
	public String mensagemDeRegistros(){//METODO QUE DIZ INICIO E FIM DOS REGISTROS LISTADOS
		return dao.getMensagemNavegacao();
	}//FIM DO METODO MENSAGEM DE REGISTROS
	
	
	
	//METODOS GETTERS E SETTERS
	public Cliente getDoCadastroController() {
		if(doCadastroController == null){
			doCadastroController = new Cliente();
		}
		return doCadastroController;
	}

	public void setDoCadastroMB(Cliente doCadastroMB) {
		this.doCadastroController = doCadastroMB;
	}

	public String getFiltroPesquisaCli() {
		return filtroPesquisaCli;
	}

	public void setFiltroPesquisaCli(String filtroPesquisaCli) {
		this.filtroPesquisaCli = filtroPesquisaCli;
	}

	public String getAtributoPesquisaCli() {
		return atributoPesquisaCli;
	}

	public void setAtributoPesquisaCli(String atributoPesquisaCli) {
		this.atributoPesquisaCli = atributoPesquisaCli;
	}

	

	
	
	

}

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
public class CadastroClienteMB implements Serializable{
	
	@Inject
	Conversation conversation;
	
	private Cliente doCadastroMB;
	private DaoCliente dao;
	private String filtroPesquisaCli;
	private String atributoPesquisaCli;
	
	@PostConstruct
	public void iniciaCadastroClienteMB(){
		conversation.begin();
		dao = new DaoCliente();
		
	}
	
	//METODOS PARA NAVEGA플O DE P핯INAS
	
	public String novoCliente(){//METODO PARA IR PARA P핯INA DO FORM DE CLIENTE
		return "novocli";
	}
	
	public String voltarParaHome(){//METODO PARA IR PARA P핯INA HOME
		return "home";
	}
	
	public String opcaoParaCliente(){//METODO PARA IR PARA PAGINA DE OPCOES DO CLIENTE
		return "opcaocli";
	}
	
	public String irParaEdicaoDeCliente(){//METODO PARA IR PARA FORM  DE EDICAO COM CLIENTE DA TELA
		
		return "editcli";
	}
	
	//METODOS DE PERSISTENCIA
	
	public String persistirNovoCliente(){//METODO PARA GRAVAR UM NOVO CLIENTE
		conversation.end();
		dao.cadastrarCliente(doCadastroMB);
		return "listcli?face-redirect=true";
	}
	
	public String persistirClienteExistente(){//METODO PARA ATUALIZAR CLIENTTE DO BANCO
		conversation.end();
		dao.editarCliente(doCadastroMB);
		return "listcli?face-redirect=true";
	}
	
	public void removerClienteDoBanco(){//METODO PARA REMOVER CLIENTE DO BANCO
		dao.removerCliente(doCadastroMB);
	}
	
	//METODOS PARA PESQUISA E LISTAGEM
	
	public List<Cliente> getListCliente(){//METODO QUE RETORNA LSITA DE CLIENTES DO BANCO
		return dao.procurarCliente(atributoPesquisaCli, filtroPesquisaCli);
	}
	
	
	
	//METODOS GETTERS E SETTERS
	public Cliente getDoCadastroMB() {
		if(doCadastroMB == null){
			doCadastroMB = new Cliente();
		}
		return doCadastroMB;
	}

	public void setDoCadastroMB(Cliente doCadastroMB) {
		this.doCadastroMB = doCadastroMB;
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

package br.com.radconnect.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.radconnect.daos.DaoFornecedor;
import br.com.radconnect.entityBeans.Fornecedor;

@SuppressWarnings("serial")
@Named
@ConversationScoped
public class CadastroFornecedorController implements Serializable{
	
	@Inject
	Conversation conversation;
	
	private Fornecedor doCadastroController;
	private DaoFornecedor dao;
	private String filtroPesquisaForn;
	private String atributoPesquisaForn;
	
	@PostConstruct
	public void iniciaCadastroFornecedorController(){
		
		dao = new DaoFornecedor();
		
	}
	
	//METODOS PARA NAVEGAÇÃO DE PÁGINAS
	
	public String novoFornecedor(){//METODO PARA IR PARA PÁGINA DO FORM DE CLIENTE
		doCadastroController = new Fornecedor();
		return "novoforn";
	}
	
	public String paginaMenuPrincipal(){//METODO PARA IR PARA PÁGINA HOME
		conversation.end();
		return "menu";
	}
	
	public String paginaEditFornecedor(){//METODO PARA IR PARA FORM  DE EDICAO COM CLIENTE DA TELA
		
		return "editforn";
	}
	
	public String paginaListFornecedor(){
		conversation.begin();
		return "listfornecedor";
	}
	
	public String voltarParaListagem(){
		return "listfornecedor";
	}
	
	//METODOS DE PERSISTENCIA
	
	public String persistirFornecedor(){//METODO PARA GRAVAR UM NOVO CLIENTE
		
		dao.persistirFornecedor(doCadastroController);
		return "listfornecedor";
	}	
	
	public void removerFornecedorDoBanco(){//METODO PARA REMOVER CLIENTE DO BANCO
		dao.removerFornecedor(doCadastroController);
	}
	
	//METODOS PARA PESQUISA E LISTAGEM
	
	public List<Fornecedor> getListFornecedor(){//METODO QUE RETORNA LSITA DE CLIENTES DO BANCO
		return dao.procurarFornecedor(atributoPesquisaForn, filtroPesquisaForn);
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
	public Fornecedor getDoCadastroController() {
		if(doCadastroController == null){
			doCadastroController = new Fornecedor();
		}
		return doCadastroController;
	}

	public void setDoCadastroController(Fornecedor doCadastro) {
		this.doCadastroController = doCadastro;
	}

	public String getFiltroPesquisaForn() {
		return filtroPesquisaForn;
	}

	public void setFiltroPesquisaForn(String filtroPesquisaForn) {
		this.filtroPesquisaForn = filtroPesquisaForn;
	}

	public String getAtributoPesquisaForn() {
		return atributoPesquisaForn;
	}

	public void setAtributoPesquisaForn(String atributoPesquisaForn) {
		this.atributoPesquisaForn = atributoPesquisaForn;
	}

	

	
	
	

}

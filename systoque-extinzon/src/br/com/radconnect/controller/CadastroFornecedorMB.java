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
public class CadastroFornecedorMB implements Serializable{
	
	@Inject
	Conversation conversation;
	
	private Fornecedor doCadastroMB;
	private DaoFornecedor dao;
	private String filtroPesquisaForn;
	private String atributoPesquisaForn;
	
	@PostConstruct
	public void iniciaCadastroFornecedorMB(){
		conversation.begin();
		dao = new DaoFornecedor();
		
	}
	
	//METODOS PARA NAVEGAÇÃO DE PÁGINAS
	
	public String novoFornecedor(){//METODO PARA IR PARA PÁGINA DO FORM DE CLIENTE
		return "novoforn";
	}
	
	public String voltarParaHome(){//METODO PARA IR PARA PÁGINA HOME
		return "home";
	}
	
	public String opcaoParaFornecedor(){//METODO PARA IR PARA PAGINA DE OPCOES DO CLIENTE
		return "opcaoforn";
	}
	
	public String irParaEdicaoDeFornecedor(){//METODO PARA IR PARA FORM  DE EDICAO COM CLIENTE DA TELA
		
		return "editforn";
	}
	
	public String irParaListagemDeFornecedor(){
		return "listforn";
	}
	
	//METODOS DE PERSISTENCIA
	
	public String persistirNovoFornecedor(){//METODO PARA GRAVAR UM NOVO CLIENTE
		conversation.end();
		dao.cadastrarFornecedor(doCadastroMB);
		return "listforn?faces-redirect=true";
	}
	
	public String persistirFornecedorExistente(){//METODO PARA ATUALIZAR CLIENTTE DO BANCO
		conversation.end();
		dao.editarFornecedor(doCadastroMB);
		return "listforn?faces-redirect=true";
	}
	
	public void removerFornecedorDoBanco(){//METODO PARA REMOVER CLIENTE DO BANCO
		dao.removerFornecedor(doCadastroMB);
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
	public Fornecedor getDoCadastroMB() {
		if(doCadastroMB == null){
			doCadastroMB = new Fornecedor();
		}
		return doCadastroMB;
	}

	public void setDoCadastroMB(Fornecedor doCadastroMB) {
		this.doCadastroMB = doCadastroMB;
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

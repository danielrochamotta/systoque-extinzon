package br.com.radconnect.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.text.StyledEditorKit.BoldAction;

import br.com.radconnect.daos.DaoCargo;
import br.com.radconnect.daos.DaoDependentes;
import br.com.radconnect.daos.DaoFuncionario;
import br.com.radconnect.daos.DaoSetor;
import br.com.radconnect.entityBeans.Cargo;
import br.com.radconnect.entityBeans.Dependente;
import br.com.radconnect.entityBeans.Funcionario;
import br.com.radconnect.entityBeans.HistoricoContribuicaoSindical;
import br.com.radconnect.entityBeans.HistoricoDeCargos;
import br.com.radconnect.entityBeans.HistoricoDeFerias;
import br.com.radconnect.entityBeans.HistoricoDeSalario;
import br.com.radconnect.entityBeans.HistoricoLicencaAfastamento;
import br.com.radconnect.entityBeans.Setor;
import br.com.radconnect.relatorioUtil.RelatorioUtil;

import java.io.Serializable;

@Named
@ConversationScoped
public class CadastroFuncionarioController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	Conversation conversation;
	
	private Funcionario funcionario;//ATRIBUTO CORRESPONDE A CLASSE FUNCIONARIO
	private Dependente doFuncionario;//ATRIBUTO QUE CORRESPONDE AO DEPENDENTE QUE IRA SE RELACIONAR COM FUNCIONARIO
	private HistoricoDeCargos registroDeCargo;//ATRIBUTO CORRESPONDE O NOVO REGISTRO DE HISTORICO DE CARGO DO FUNCIONARIO
	private HistoricoDeSalario registroDeSalario;//ATRIBUTO CORRESPONDE O NOVO REGISTRO DE HISTORICO DE SALARIO DO FUNCIONARIO
	private HistoricoContribuicaoSindical registroDeContribuicao;//ATRIBUTO CORRESPONDE O NOVO REGISTRO DE HISTORICO DE SALARIO DO FUNCIONARIO
	private HistoricoLicencaAfastamento  registroDeLicenca;//ATRIBUTO QUE CORRESPONDE O NOVO REGISTRO DE HISTORICO DE LICENCAS E AFASTAMETNOS
	private HistoricoDeFerias  registroDeFerias;//ATRIBUTO QUE CORRESPONDE O NOVO REGISTRO DE HISTORICO DE FERIAS
	private Setor doSelecOneMenuHistCargo;
	private Setor doSelecOneMenuDaTabDocEmpresa;
	private Cargo doSelectOneMenu;
	private Long campoDePesquisa;//ATRIBUTO QUE SERA USADO NA PESQUISA DESEJADA DO FUNCIONARIO	
	private DaoFuncionario dao;//ATRIBUTO PARA PERSISTENCIO DO FUUNCIONARIO
		
	private DaoSetor daoSetor;//ATRIBUTO PARA PERSISTENCIA DOS SETORES
	private Boolean addHistCargos = false;//ATRIBUTO PARA ORIENTACAO DE COMPONENSTES DO PAINEL DE HISTORICO DE CARGOS
	private Boolean addDependente = false;//ATRIBUTO PARA ORIENTACAO DE COMPONENSTES DO PAINEL DE DEPENDENTES
	private Boolean addHistSalario = false;//ATRIBUTO PARA ORIENTACAO DE COMPONENSTES DO PAINEL DE HISTORICO DE SALARIOS
	private Boolean addHistContribuicao = false;//ATRIBUTO PARA ORIENTACAO DE COMPONENSTES DO PAINEL DE HISTORICO DE SALARIOS
	private Boolean addHistLicenca = false;//ATRIBUTO PARA ORIENTACAO DE COMPONENSTES DO PAINEL DE HISTORICO DE LICENCAS E AFASTAMENTOS
	private Boolean addHistFerias = false;//ATRIBUTO PARA ORIENTACAO DE COMPONENSTES DO PAINEL DE HISTORICO DE FERIAS
	private String filtroPesqFuncionario;
	private String atributoDePesquisa;
	/*
	 * 
    */
	@PostConstruct
	public void iniciaCadastroMB(){//INCIO DO CONSTRUTOR
		conversation.begin();
		dao = new  DaoFuncionario();		
		daoSetor = new DaoSetor();
		registroDeCargo = new HistoricoDeCargos();
		registroDeSalario = new HistoricoDeSalario();
		registroDeContribuicao = new HistoricoContribuicaoSindical();
		registroDeLicenca = new HistoricoLicencaAfastamento();
		registroDeFerias = new HistoricoDeFerias();
		atributoDePesquisa = "";
		
	}//FIM DO CONSTRUTOR
	
	public String cadastrarFuncionario(){//INICIO DE PERSISTENCIA DO FUNCIONARIO
		conversation.end();
		dao.cadastrarFuncionario(funcionario);
		return "listfunc?faces-redirect=true";
	
	}//FIM DO METODO DE PERSISTENCIA DO FUNCIONARIO
	
	
	
	
	public String paginaNovo(){//INICIO METODO QUE DIRECIONA PARA A PAGINA DO FORMULARIO NOVO FUNCIONARIO
		funcionario = new Funcionario();
		registroDeCargo = new HistoricoDeCargos();
		return "novofunc?faces-redirect=true";
	}//FIM DO METODO QEU DIRECIONA PARA A PAGINA DO FORM NOVO FUNCIONARIO
	
	public String paginaHome(){// INICIO DO METODO QUE DIRECIONA PARA A PAGINA HOME
		conversation.end();
		return "home";
	}//FIM DO METODO QUE DIRECIONA PARA PAGINA HOME
	
	public String paginaOpcoesFuncionario(){
		
		return "opcaofunc";
	}
	
	public List<Funcionario> getListFuncionario(){//INICIO DO METODO QUE CHAMA A LISTA COMPLETA DA TABELA DE FUNCIONARIO
		return dao.listFuncionario();
	}//FIM DO METODO QUE CHAMA LISTA COMPLETA DA TABELA FUNCIONARIO
	
	public String paginaEditar(){//INICIO DO METODO QUE DIRECIONA PARA PAGINA DE EDICAO DO FUNCIONARIO
		
		return "editfunc";
	}//FIM DO METODO QUE DIRECIONA PARA PAGINA DE EDICAO DO FUNCIONARIO
	
	public String editarFuncionario(){//INICIO DO METODO QUE ALTERA INFORMACOES DO FUNCIONARIO E PERSISTE NO BANCO
		conversation.end();
		dao.editarFuncionario(funcionario);
		
		return "list?faces-redirect=true";
	}//FIM DO METODO QUE ALTERA INFORMACOES DO FUNCIONARIO
	
	public String removerFuncionario(){//INICIO DO METODO QUE REMOVE DO BANCO O FUNCIONARIO DESEJADO
		//conversation.end();
		dao.removerFuncionario(funcionario);
		return "list?faces-redirect=true";
	}//FIM DO METODO QUE REMOVE DO BANCO O FUNCIONARIO DESEJADO
	
	public void detalhesFuncionario(){//INICIO DO METODO QUE GERA O RELATORIO DO FUNCIONARIO
		
		HashMap parametros = new HashMap();
		List<Object> funcionarios;
		funcionarios = new ArrayList();
		funcionarios.add(funcionario);
		RelatorioUtil.imprimeRelatorio("templateFuncionarios", parametros, funcionarios);
	}//FIM DO METODO QUE GERA O RELATORIO DO FUNCIONARIO
	
	public void imprimirTodos(){//INICIO DO METODO QUE GERA O RELATORIO DO FUNCIONARIO
		
		HashMap parametros = new HashMap();
		RelatorioUtil.imprimeRelatorio("templateFuncionarios", parametros, impressaDeTodosFuncionarios());
	}//FIM DO METODO QUE GERA O RELATORIO DO FUNCIONARIO
	
	public String localizarFuncionario(){//INICIO DO METODO QUE LISTA FUNCONARIO DO BANCO
		conversation.end();
		return "listfunc?faces-redirect=true";
	}//FIM DO METODO QUE LISTA FUNCIONARIOS DO BANCO
	
	public void addDepenteDoNovoFuncionario(){//INICIO DO METODO QUE ADICONA DEPENDENTE A LISTA DO OBJETO FUNCIONARIO
		doFuncionario.setFuncionario(funcionario);
		funcionario.adicionaDependente(doFuncionario);
		
		doFuncionario = new Dependente();
		
		desativaFormDependente();
	
	}//FIM DO METODO QUE ADIOCIONA DEPENDENTE A LISTA DE DEPENDENTES DO OBJETO FUNCIONARIO
	
	public void removeDependenteDoNovoFuncionario(Dependente daTela){//INICIO DO METODO QUE EXCLUI DEPENDENTE DA LISTA
		daTela.setFuncionario(funcionario);
		funcionario.removeDependente(daTela);
		
		daTela = new Dependente();
	}//FIM DO MEETODO QUE EXCLUI DEPENDETE DA LISTA DE DEPENTES DO OBJETO FUNCIONARIO

	
	
	public void addRegistroDeCargo(){
		
		for(int i = 0; i < doSelecOneMenuHistCargo.getListCargo().size(); i++){
			if(doSelecOneMenuHistCargo.getListCargo().get(i).getNome() == doSelectOneMenu.getNome()){
				registroDeCargo.setCargo(doSelecOneMenuHistCargo.getListCargo().get(i).getNome());
				registroDeCargo.setCbo(doSelecOneMenuHistCargo.getListCargo().get(i).getCbo());
			}
		}
		
		funcionario.adicionaHistoricoDeCargo(registroDeCargo);
		
		
		registroDeCargo = new  HistoricoDeCargos();
		doSelecOneMenuHistCargo = new Setor();
		
		desativaFormHistoricoCargo();
	}
	
	public void removeRegistroDeCargo(HistoricoDeCargos registro){
		funcionario.removeHistoricoDeCargo(registro);
		
		registro = new HistoricoDeCargos();
	}
	//ADICONA REGISTRO DE HISTORICO DE SALARIO DO FUNCIONARIO
	public void addHistoricoDeSalario(){
		funcionario.adicionaHistoricoDeSalario(registroDeSalario);
		
		registroDeSalario = new HistoricoDeSalario();
		
		desativaFormHistoricoSalario();
	}
	//REMOVE REGISTRO DE HISTORICO DE SALARIO DO FUNCIONARIO
	public void removeHistoricoDeSalario(HistoricoDeSalario registro){
		funcionario.removeHistoricoDeSalario(registro);
	}
	
	//ADICONA REGISTRO DE HISTORICO DE CONTRIBUICAO SINDICAL DO FUNCIONARIO
		public void addHistoricoDeContribuicao(){
			funcionario.adicionaHistoricoDeContribuicao(registroDeContribuicao);
			
			registroDeContribuicao = new HistoricoContribuicaoSindical();
			
			desativaFormHistoricoContribuicaoSindical();
		}
		//REMOVE REGISTRO DE HISTORICO DE CONTRIBUICAO SINDICAL DO FUNCIONARIO
		public void removeHistoricoDeContribuicao(HistoricoContribuicaoSindical registro){
			funcionario.removeHistoricoContribuicao(registro);
		}
		
		//ADICONA REGISTRO DE HISTORICO DE LICENCA E AFASTAMENTO DO FUNCIONARIO
		public void addHistoricoDeLicenca(){
			funcionario.adicionaHistoricoLicenca(registroDeLicenca);
					
			registroDeLicenca = new HistoricoLicencaAfastamento();
			
			desativaFormHistoricoLicenca();
		}
		//REMOVE REGISTRO DE HISTORICO DE LICENCA E AFASTAMENTO DO FUNCIONARIO
		public void removeHistoricoDeLicenca(HistoricoLicencaAfastamento registro){
			funcionario.removeHistoricoDeLicenca(registro);
		}
		
		//ADICONA REGISTRO DE HISTORICO DE FERIAS DO FUNCIONARIO
		public void addHistoricoDeFerias(){
			funcionario.adicionaHistoricoDeFerias(registroDeFerias);
							
			registroDeFerias = new HistoricoDeFerias();
					
			desativaFormHistoricoFerias();
		}
		//REMOVE REGISTRO DE HISTORICO DE FERIAS DO FUNCIONARIO
		public void removeHistoricoDeFerias(HistoricoDeFerias registro){
			 funcionario.removeHistoricoDeFerias(registro);
		}
	
	public void localizaFuncionarioId(){//METODO PRECISA DE ALTERACOES!!!!!!!!!!!!!!
		
	funcionario = dao.listFuncionarioEspecifico(campoDePesquisa);
	
	addDependente = false;
	
	campoDePesquisa = null;
	
	
	}//FIM DO METODO DE PESQUISA QUE PRECISA ALTERACOES!!!!!!!!!!!
	
	public void ativaFormDependente(){//INICIO DO METODO QUE ATIVA COMPONETNE DE FORMULARIO DO DEPENDETE
		addDependente = true;		
		
	}//FIM DO METODO QUE ATIVA COMPONENTE DE FORMULARIO DO DEPENDENTE
	
	public void desativaFormDependente(){//INCIO DO METODO QUE DESATIVA COMPONENTE DE FORMULARIO DO DEPENDENTE
		addDependente = false;
	}//FIM DO METODO QUE DESATIVA COMPONENTE DE FORMULARIO DO DEPENDENTE
	
	public void ativaFormHistoricoCargo(){//INICIO DO METODO QUE ATIVA FORMULARIO DE REGISTRO DE CARGO DO FUNCIONARIO
		addHistCargos = true;
	}//FIM DO METODO QUE ATIVA FORMULARIO DE REGISTRO DE HISTORICO DE CARGO DO FUNCIONARIO
	
	public void desativaFormHistoricoCargo(){//INCIO DO METODO QUE DESATIVA COMPONENTE DE FORMULARIO DO REGISTRO DE CARGOS DO FUNCIONARIO
		addHistCargos = false;
	}//FIM DO METODO QEU DESTIVA FOMRULARIO DE REGISTRO DE HISTORICO DE CARGO DO FUNCIONARIO
	
	public void ativaFormHistoricoSalario(){//INICIO DO METODO QUE ATIVA FORMULARIO DE REGISTRO DE SALARIO DO FUNCIONARIO
		addHistSalario = true;
	}//FIM DO METODO QUE ATIVA FORMULARIO DE REGISTRO DE HISTORICO DE SALARIO DO FUNCIONARIO
	
	public void desativaFormHistoricoSalario(){//INCIO DO METODO QUE DESATIVA COMPONENTE DE FORMULARIO DO REGISTRO DE SALARIO DO FUNCIONARIO
		addHistSalario = false;
	}//FIM DO METODO QEU DESTIVA FOMRULARIO DE REGISTRO DE HISTORICO DE SALARIO DO FUNCIONARIO
	
	public void ativaFormHistoricoContribuicaoSindical(){//INICIO DO METODO QUE ATIVA FORMULARIO DE REGISTRO DE CONTRIBUICAO SINDICAL DO FUNCIONARIO
		addHistContribuicao = true;
	}//FIM DO METODO QUE ATIVA FORMULARIO DE REGISTRO DE HISTORICO DE SALARIO DO FUNCIONARIO
	
	public void desativaFormHistoricoContribuicaoSindical(){//INCIO DO METODO QUE DESATIVA COMPONENTE DE FORMULARIO DO REGISTRO DE CONTRIBUICAO SINDICAL DO FUNCIONARIO
		addHistContribuicao = false;
	}//FIM DO METODO QEU DESTIVA FOMRULARIO DE REGISTRO DE HISTORICO DE CONTRIBUICAO SINDICAL DO FUNCIONARIO
	
	public void ativaFormHistoricoLicenca(){//INICIO DO METODO QUE ATIVA FORMULARIO DE REGISTRO DE LICENCAS E AFASTAMENTO DO FUNCIONARIO
		addHistLicenca = true;
	}//FIM DO METODO QUE ATIVA FORMULARIO DE REGISTRO DE HISTORICO DE SALARIO DO FUNCIONARIO
	
	public void desativaFormHistoricoLicenca(){//INCIO DO METODO QUE DESATIVA COMPONENTE DE FORMULARIO DO REGISTRO DE LICENCAS E AFASTAMENTOS DO FUNCIONARIO
		addHistLicenca = false;
	}//FIM DO METODO QEU DESTIVA FOMRULARIO DE REGISTRO DE HISTORICO DE CONTRIBUICAO SINDICAL DO FUNCIONARIO
	
	public void ativaFormHistoricoFerias(){//INICIO DO METODO QUE ATIVA FORMULARIO DE REGISTRO DE FERIAS
		addHistFerias = true;
	}//FIM DO METODO QUE ATIVA FORMULARIO DE REGISTRO DE HISTORICO DE FERIAS DO FUNCIONARIO
	
	public void desativaFormHistoricoFerias(){//INCIO DO METODO QUE DESATIVA COMPONENTE DE FORMULARIO DO REGISTRO DE FERIAS DO FUNCIONARIO
		addHistFerias = false;
	}//FIM DO METODO QEU DESTIVA FOMRULARIO DE REGISTRO DE HISTORICO DE FERIASL DO FUNCIONARIO
	
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
	
	
	
	public List<Funcionario> listagemFuncinario(){
		
		return dao.procuraFuncionario(atributoDePesquisa, filtroPesqFuncionario);
	}
	
    public List<Funcionario> impressaDeTodosFuncionarios(){
		
		return dao.imprimirTodos(atributoDePesquisa, filtroPesqFuncionario);
	}
	

	
	
	
	

	/** GETTES E SETTERS
	 * 
	 * @return the funcionario
	 */
	
	public Funcionario getFuncionario() {
		if(funcionario == null){
			funcionario = new Funcionario();
		}
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public Dependente getDoFuncionario() {
		if(doFuncionario == null){
			doFuncionario = new Dependente();
		}
		return doFuncionario;
		
	}

	public void setDoFuncionario(Dependente doFuncionario) {
		this.doFuncionario = doFuncionario;
	}

	public Long getCampoDePesquisa() {
		return campoDePesquisa;
	}

	public void setCampoDePesquisa(Long campoDePesquisa) {
		this.campoDePesquisa = campoDePesquisa;
	}

	public Boolean getAddDependente() {
		return addDependente;
	}

	public void setAddDependente(Boolean addDependente) {
		this.addDependente = addDependente;
	}

	public Boolean getAddHistCargos() {
		return addHistCargos;
	}

	public void setAddHistCargos(Boolean addHistCargos) {
		this.addHistCargos = addHistCargos;
	}
	
	

	public Boolean getAddHistSalario() {
		return addHistSalario;
	}

	public void setAddHistSalario(Boolean addHistSalario) {
		this.addHistSalario = addHistSalario;
	}

	public HistoricoDeCargos getRegistroDeCargo() {
		if(registroDeCargo == null){
			registroDeCargo = new HistoricoDeCargos();
		}
		return registroDeCargo;
	}

	public void setRegistroDeCargo(HistoricoDeCargos registroDeCargo) {
		this.registroDeCargo = registroDeCargo;
	}	

	public DaoSetor getDaoSetor() {
		return daoSetor;
	}

	public void setDaoSetor(DaoSetor daoSetor) {
		this.daoSetor = daoSetor;
	}

	public Setor getDoSelecOneMenu() {
		return doSelecOneMenuHistCargo;
	}

	public void setDoSelecOneMenu(Setor doSelecOneMenu) {
		this.doSelecOneMenuHistCargo = doSelecOneMenu;
	}

	public Cargo getDoSelectOneMenu() {
		return doSelectOneMenu;
	}

	public void setDoSelectOneMenu(Cargo doSelectOneMenu) {
		this.doSelectOneMenu = doSelectOneMenu;
	}

	public Boolean getAddHistContribuicao() {
		return addHistContribuicao;
	}

	public void setAddHistContribuicao(Boolean addHistContribuicao) {
		this.addHistContribuicao = addHistContribuicao;
	}

	public HistoricoDeSalario getRegistroDeSalario() {
		return registroDeSalario;
	}

	public void setRegistroDeSalario(HistoricoDeSalario registroDeSalario) {
		this.registroDeSalario = registroDeSalario;
	}

	public HistoricoContribuicaoSindical getRegistroDeContribuicao() {
		return registroDeContribuicao;
	}

	public void setRegistroDeContribuicao(
			HistoricoContribuicaoSindical registroDeContribuicao) {
		this.registroDeContribuicao = registroDeContribuicao;
	}

	public HistoricoLicencaAfastamento getRegistroDeLicenca() {
		return registroDeLicenca;
	}

	public void setRegistroDeLicenca(HistoricoLicencaAfastamento registroDeLicenca) {
		this.registroDeLicenca = registroDeLicenca;
	}

	public Boolean getAddHistLicenca() {
		return addHistLicenca;
	}

	public void setAddHistLicenca(Boolean addHistLicenca) {
		this.addHistLicenca = addHistLicenca;
	}

	public HistoricoDeFerias getRegistroDeFerias() {
		return registroDeFerias;
	}

	public void setRegistroDeFerias(HistoricoDeFerias registroDeFerias) {
		this.registroDeFerias = registroDeFerias;
	}

	public Boolean getAddHistFerias() {
		return addHistFerias;
	}

	public void setAddHistFerias(Boolean addHistFerias) {
		this.addHistFerias = addHistFerias;
	}

	public String getFiltroPesqFuncionario() {
		return filtroPesqFuncionario;
	}

	public void setFiltroPesqFuncionario(String filtroPesqFuncionario) {
		this.filtroPesqFuncionario = filtroPesqFuncionario;
	}

	public String getAtributoDePesquisa() {
		return atributoDePesquisa;
	}

	public void setAtributoDePesquisa(String atributoDePesquisa) {
		this.atributoDePesquisa = atributoDePesquisa;
	}

	public Setor getDoSelecOneMenuDaTabDocEmpresa() {
		return doSelecOneMenuDaTabDocEmpresa;
	}

	public void setDoSelecOneMenuDaTabDocEmpresa(Setor doSelecOneMenuDaTabDocEmpresa) {
		this.doSelecOneMenuDaTabDocEmpresa = doSelecOneMenuDaTabDocEmpresa;
	}
	
	
	
	
	

}

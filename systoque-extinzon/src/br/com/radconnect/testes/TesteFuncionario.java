package br.com.radconnect.testes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import javax.persistence.EntityManager;

import br.com.radconnect.entityBeans.Cargo;
import br.com.radconnect.entityBeans.Dependente;
import br.com.radconnect.entityBeans.Funcionario;
import br.com.radconnect.entityBeans.FuncionarioEndereco;
import br.com.radconnect.jpaUtil.EntityManagerUtil;



public class TesteFuncionario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		Funcionario funcionarioTest = new Funcionario();
		
		/*
		 * TESTE DE INCLUSÃO
		 
		funcionarioTest.setNome("Daniel Rocha");		
		funcionarioTest.setNomeMae("Marta");	
		funcionarioTest.setNomePai("Ricardo");
		funcionarioTest.setCpf("21313213213");
		funcionarioTest.setTelefone("21312-3123");
		funcionarioTest.setCelular("9888998-9898");
		funcionarioTest.setEmail("fdf@uiol");
		String data = "28/02/1984";
		
		try {
			//DATE FORMAT
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			//DATE CONVERTER
			Date dtNasc = df.parse(data);
			
			funcionarioTest.setDataNascimento(dtNasc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		em.getTransaction().begin();
		em.persist(funcionarioTest);
		em.getTransaction().commit();
      */
		
		/*
		 * TESTE DE CONSULTA
		 
		
		funcionarioTest = em.find(Funcionario.class, 4L);
		
		String dataNascimentoFormatada = "";
		try{
			//DATE FORMAT
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			//DATE CONVERTER
			dataNascimentoFormatada = df.format(funcionarioTest.getDataNascimento());
			
		}catch(Exception e){
			
		}
		
		System.out.println("DADOS DO FUNCIONARIO"+"/n");
		System.out.println("Nome : "+funcionarioTest.getNome()+"/n");
		System.out.println("Nome do Pai : "+funcionarioTest.getNomePai()+"/n");
		System.out.println("Nome da Mae : "+funcionarioTest.getNomeMae()+"/n");
		System.out.println("Data de Nascimento : "+dataNascimentoFormatada+"/n");
		System.out.println("Cpf : "+funcionarioTest.getCpf()+"/n");
		System.out.println("Telefone : "+funcionarioTest.getTelefone()+"/n");
		System.out.println("Celular : "+funcionarioTest.getCelular()+"/n");
		System.out.println("Email : "+funcionarioTest.getEmail()+"/n");
		
		*/
		
		/*
		 * TESTE DE EDICAO COM IMPRESSAO DA VARIAVEL EDITADA
		
		funcionarioTest.setId(4L);
		
		
		String dataNascimentoRecebida = "29/02/1983";
		try{
			//DATE FORMAT
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			//DATE CONVERTER
			Date dtNasc = df.parse(dataNascimentoRecebida);
			
			funcionarioTest.setDataNascimento(dtNasc);
			
		}catch(Exception e){
			
		}
		
		em.getTransaction().begin();
		em.merge(funcionarioTest);
		em.getTransaction().commit();
		 */
		
		/*
		 * TESTE DE INCLUSÃO DO FUNCIONARIO JÁ 
		 * COM O RELACIOANMETOS
		*/
		//funcionarioTest.setMatricula("2424");
		//funcionarioTest.setNome("TALITA");		
		//funcionarioTest.setNomeMae("MARIA");	
		//funcionarioTest.setNomePai("TAXISTA");
		//funcionarioTest.setCpf("111-2555");
		//funcionarioTest.setTelefone("111-3123");
		//funcionarioTest.setCelular("11111-6668");
		//funcionarioTest.setEmail("EDR@DRD");
		//funcionarioTest.setCpf("123.123.123-90");
		//funcionarioTest.setRgNumero("123231232131");
		
		
		//String data = "24/01/1982";
		
		//try {
			//DATE FORMAT
		//	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			//DATE CONVERTER
			
			
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		
		//FuncionarioEndereco end = new FuncionarioEndereco();
		/*
		 * 
		 
		end.setBairro("Barra");
		end.setCep("4324-234");
		end.setCidade("Fortaleza");
		end.setUf("CE");
		end.setLogradouro("Rua G , 49");
		
		
		
		//end = em.find(FuncionarioEndereco.class, 2L);
		
		//funcionarioTest.setFuncEndereco(end);
		
		
		//funcionarioTest = em.find(Funcionario.class,2L);
		
		
		/*
		 */
		//funcionarioTest.getFuncEndereco().setBairro("SERRINHA");
		//funcionarioTest.getFuncEndereco().setLogradouro("RUA DEDE BRASIL, 42400");
		//funcionarioTest.getFuncEndereco().setCidade("FORTALEZA");
		//funcionarioTest.getFuncEndereco().setUf("CE");
		
	
		/*
		
		*/
		//funcionarioTest = em.find(Funcionario.class, 1000L);
		/*
		
		System.out.println("NOME DO FUNCIONARIO :"+funcionarioTest.getNome()+" :");
		System.out.println("CARGO DO FUNCIONARIO :"+funcionarioTest.getCargoFuncionario().getNomeCargo());
		System.out.println("SETOR DO FUNCIONARIO :"+funcionarioTest
				.getCargoFuncionario()
				.getSetorCargo().getNomeSetor());
		System.out.println("ENDERECO DO FUNCIONARIO :");
		System.out.println("LOGRADOURO :"+funcionarioTest
				.getFuncEndereco().getLogradouro()+"BAIRRO :"+funcionarioTest
				.getFuncEndereco().getBairro());
		System.out.println("CIDADE :"+funcionarioTest
				.getFuncEndereco().getCidade()+"UF :"+funcionarioTest
				.getFuncEndereco().getUf());
		System.out.println("NOME DOS DEPENDENTES :");
		for(int i = 0; i < funcionarioTest.getListDependente().size(); i++){
			System.out.println(funcionarioTest.getListDependente().get(i).getFuncDependenteNome());
		}
		*/	
		/*
		 * 
		*/ 
		//Cargo cg = new Cargo();
		
		//cg = em.find(Cargo.class, 5L);
		
		//funcionarioTest.setCargoFuncionario(cg);
		
		//Dependente doFuncionarioTest = new Dependente();
		//Dependente doFuncionarioTest2 = new Dependente();
		
		//doFuncionarioTest.setNome("LUCAS");
		//doFuncionarioTest.setParentesco("FILHO");
		
		//doFuncionarioTest2.setNome("JOSEFINA");
		//doFuncionarioTest2.setParentesco("FILHA");
		
		//funcionarioTest.adicionaDependente(doFuncionarioTest);
		//funcionarioTest.adicionaDependente(doFuncionarioTest2);
		for(int i = 1; i < 100; i++){
			funcionarioTest = new Funcionario();
			
			funcionarioTest.setMatricula(Integer.toString(i));
			funcionarioTest.setRgNumero(Integer.toString(i));
			funcionarioTest.setNome("FUNCIOANRIO"+Integer.toString(i));
			
			em.getTransaction().begin();
			em.persist(funcionarioTest);
			em.getTransaction().commit();
		}
			
			
			
			
		
		
	}

}

package br.com.radconnect.testes;

import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List;  

import br.com.radconnect.entityBeans.Funcionario;
import net.sf.jasperreports.engine.JRException; 
import net.sf.jasperreports.engine.JasperCompileManager; 
import net.sf.jasperreports.engine.JasperExportManager; 
import net.sf.jasperreports.engine.JasperFillManager; 
import net.sf.jasperreports.engine.JasperPrint; 
import net.sf.jasperreports.engine.JasperReport; 
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;  
import net.sf.jasperreports.view.JasperViewer;

public class TesteRelatorio { 
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws JRException, SQLException {  
		System.out.println("Gerando relatório..."); // lista com os nossos clientes 
		List<Funcionario> lista = new ArrayList<Funcionario>();
		Funcionario e = new Funcionario();
		e.setNome("LEANDRO");
		e.setEmail("leotititi@gmail.com");
		e.getFuncEndereco().setLogradouro("RUA GOIÁS, 935");
		e.getFuncEndereco().setBairro("PAN AMERICANO");
		e.getFuncEndereco().setCidade("FORTALEZA");
		e.getFuncEndereco().setUf("CE");
		e.getFuncEndereco().setCep("12345-678");
		lista.add(e);
		JasperReport report = JasperCompileManager.compileReport("WebContent/WEB-INF/relatorios/templateFuncionarios.jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
		JasperViewer tela = new JasperViewer(print, false);
		tela.show();
		JasperExportManager.exportReportToPdfFile(print, "WebContent/WEB-INF/relatorios/RelatorioCliente.pdf");  
		System.out.println("Relatório gerado.");
	}
}

package br.com.radconnect.relatorioUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class RelatorioUtil {
	public static void imprimeRelatorio(String relatorioNome, 
			HashMap<String, Object> parametros, List lista){
		try {
			JRBeanCollectionDataSource dataSource = 
					new JRBeanCollectionDataSource(lista);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.responseComplete();
			ServletContext scontext = 
					(ServletContext) facesContext.getExternalContext().getContext();
			String path = scontext.getRealPath("/WEB-INF/relatorios");
			parametros.put("SUBREPORT_DIR", path + File.separator);
			JasperPrint jasperPrint = 
					JasperFillManager.fillReport(
					scontext.getRealPath("/WEB-INF/relatorios") +
					File.separator + relatorioNome + ".jasper",
					parametros, dataSource);
			byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);
			HttpServletResponse res = (HttpServletResponse)
					facesContext.getExternalContext().getResponse();
			res.setContentType("application/pdf");
			int codigo = (int) (Math.random() * 1000);
			res.setHeader("Content-disposition", "inline);filename=relatorio_"+codigo+".pdf");
			res.getOutputStream().write(b);
			facesContext.renderResponse();
			facesContext.responseComplete();						
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}

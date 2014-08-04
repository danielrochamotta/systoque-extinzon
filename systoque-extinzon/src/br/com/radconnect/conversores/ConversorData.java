package br.com.radconnect.conversores;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterData")
public class ConversorData implements Converter {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Date dt = new Date();
		try{
			dt = sdf.parse(arg2);
		}catch(Exception e){
			return null;
		}
		return dt;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		Date dt = (Date) obj;
		String retorno = sdf.format(dt.getTime());
		return retorno;
	}

	
}

package br.com.radconnect.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.radconnect.entityBeans.Cargo;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

@FacesConverter("ConverterCargo")
public class ConversorCargo implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if(string == null || string.equals("Selecione")){
			return null;
		}
		return EntityManagerUtil.getEntityManager().find(Cargo.class, Long.parseLong(string));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if(obj == null){
			
			
			return null;
		}
		Cargo convertido = (Cargo) obj;
		return convertido.getId().toString();
	}

}

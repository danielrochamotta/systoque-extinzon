package br.com.radconnect.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.radconnect.entityBeans.GrupoDoItem;
import br.com.radconnect.entityBeans.Setor;
import br.com.radconnect.entityBeans.SubGrupoN1DoGrupo;
import br.com.radconnect.entityBeans.SubGrupoN2DoN1;
import br.com.radconnect.entityBeans.SubGrupoN4DoN3;
import br.com.radconnect.entityBeans.SubGrupoN5DoN4;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

@FacesConverter("ConverterSubGrupoN4")
public class ConversorSubGrupoN4 implements Converter{

	public ConversorSubGrupoN4() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if(string == null || string.equals("Selecione")){
			return null;
		}
		return EntityManagerUtil.getEntityManager().find(SubGrupoN4DoN3.class, Long.parseLong(string));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if(obj == null){
			return null;
		}
		SubGrupoN4DoN3 convertido = (SubGrupoN4DoN3) obj;
				
		return convertido.getId().toString();
	}
	
}

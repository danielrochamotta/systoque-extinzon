package br.com.radconnect.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.radconnect.entityBeans.GrupoDoItem;
import br.com.radconnect.entityBeans.Setor;
import br.com.radconnect.entityBeans.SubGrupoN1DoGrupo;
import br.com.radconnect.entityBeans.SubGrupoN2DoN1;
import br.com.radconnect.entityBeans.SubGrupoN3DoN2;
import br.com.radconnect.jpaUtil.EntityManagerUtil;

@FacesConverter("ConverterSubGrupoN3")
public class ConversorSubGrupoN3 implements Converter{

	public ConversorSubGrupoN3() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if(string == null || string.equals("Selecione")){
			return null;
		}
		return EntityManagerUtil.getEntityManager().find(SubGrupoN3DoN2.class, Long.parseLong(string));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		if(obj == null){
			return null;
		}
		SubGrupoN3DoN2 convertido = (SubGrupoN3DoN2) obj;
				
		return convertido.getId().toString();
	}
	
}

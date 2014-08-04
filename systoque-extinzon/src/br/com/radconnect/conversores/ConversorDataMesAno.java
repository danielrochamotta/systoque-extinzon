package br.com.radconnect.conversores;

import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter("ConversorDataMesAno")
public class ConversorDataMesAno extends DateTimeConverter{
	

	public ConversorDataMesAno (){
		setPattern("MM/yyyy");
	}
	
}

package br.com.radconnect.testes;

import br.com.radconnect.daos.DaoLocalizacaoDeItem;
import br.com.radconnect.entityBeans.LocalizacaoItem;
import br.com.radconnect.entityBeans.SubLocalizacaoItem01;
import br.com.radconnect.entityBeans.SubLocalizacaoItem02;

public class TestLocalizacaoItem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LocalizacaoItem localizacaoTeste = new LocalizacaoItem();
		DaoLocalizacaoDeItem dao = new DaoLocalizacaoDeItem();
		SubLocalizacaoItem01 sub1 = new SubLocalizacaoItem01();
		SubLocalizacaoItem02 sub2 = new SubLocalizacaoItem02();
		
		localizacaoTeste.setNome("ALMOXARIFADO DE PECAS DE REPOSICAO");
		
		for(int i = 0; i < 2;i++){
		    sub1 = new SubLocalizacaoItem01();
			sub1.setNome("Sala "+(i+1));
			localizacaoTeste.adicionaSubLocalizacao01(sub1);
		}
		for(int i = 1;i <= 10;i++){
		    sub2 = new SubLocalizacaoItem02();
			sub2.setNome("Estante "+i);
			sub1.adicionaSubLocalizacao02(sub2);
			
		}
		
		dao.persistirLocalizacao(localizacaoTeste);
		
		System.out.println("LOCALIZACAOPERSISTIDA COM SUCESSO!!!");

	}

}

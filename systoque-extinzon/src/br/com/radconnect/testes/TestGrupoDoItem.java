package br.com.radconnect.testes;

import br.com.radconnect.daos.DaoGrupoDoItem;
import br.com.radconnect.entityBeans.GrupoDoItem;
import br.com.radconnect.entityBeans.SubGrupoN1DoGrupo;
import br.com.radconnect.entityBeans.SubGrupoN2DoN1;
import br.com.radconnect.entityBeans.SubGrupoN3DoN2;
import br.com.radconnect.entityBeans.SubGrupoN4DoN3;
import br.com.radconnect.entityBeans.SubGrupoN5DoN4;

public class TestGrupoDoItem {

	
	public static void main(String[] args) {
		
		DaoGrupoDoItem dao = new DaoGrupoDoItem();
		GrupoDoItem grupo = new GrupoDoItem();
		/*
		SubGrupoN1DoGrupo sub1 = new SubGrupoN1DoGrupo();
		SubGrupoN2DoN1 sub2 = new SubGrupoN2DoN1();
		SubGrupoN3DoN2 sub3 = new SubGrupoN3DoN2();
		SubGrupoN4DoN3 sub4 = new SubGrupoN4DoN3();
		SubGrupoN5DoN4 sub5 = new SubGrupoN5DoN4();
		grupo.setId(1L);
		grupo.setNome("PRODUTO PARA EXT");
		sub1.setNome("EXTINTOR");
		grupo.adicionaSubGrupoN1(sub1);
		sub2.setNome("POQUIMICO");
		sub1.adicionaSubGrupoN2(sub2);
		sub3.setNome("CO2");
		sub2.adicionaSubGrupoN3(sub3);
		sub4.setNome("ELETRICO");
		sub3.adicionarSubGrupoN4(sub4);
		sub5.setNome("TIPO A");
		sub4.adicionarSubGrupoN5(sub5);
		*/
		grupo.setId(2L);
		grupo = dao.grupoFind(2L);
		dao.removerGrupo(grupo);
		
		System.out.println("GRUPO REMOVIDO COM SUCESSO");

	}

}

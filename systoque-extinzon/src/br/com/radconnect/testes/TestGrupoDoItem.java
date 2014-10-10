package br.com.radconnect.testes;

import br.com.radconnect.daos.DaoGrupoDoItem;
import br.com.radconnect.entityBeans.GrupoDoItem;
import br.com.radconnect.entityBeans.SubGrupoN1DoGrupo;
import br.com.radconnect.entityBeans.SubGrupoN2DoN1;
import br.com.radconnect.entityBeans.SubGrupoN3DoN2;
import br.com.radconnect.entityBeans.SubGrupoN4DoN3;

public class TestGrupoDoItem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrupoDoItem grupoTeste = new GrupoDoItem();
		SubGrupoN1DoGrupo sub1 = new SubGrupoN1DoGrupo();
		SubGrupoN2DoN1 sub2DoN1 = new SubGrupoN2DoN1();
		SubGrupoN3DoN2 sub3 = new SubGrupoN3DoN2();
		SubGrupoN4DoN3 sub4 = new SubGrupoN4DoN3();
		DaoGrupoDoItem dao = new DaoGrupoDoItem();
		
		
		
		//grupoTeste.setNome("PO QUIMICO");
		//sub1.setNome("SUB1 PO QUIMICO");
		//grupoTeste.adicionaSubGrupoN1(sub1);
		
		grupoTeste = dao.retornaGrupo(1L);
		
		for(int i = 0; i < 10; i++){
			sub4 = new SubGrupoN4DoN3();
			sub4.setNome("Sub2 PO QUIMICO "+(i+1));
			
			grupoTeste.getListSubGrupo().get(0).getListSubGrupoN2().get(0).getListSubGrupoN3()
			.get(0).adicionarSubGrupoN4(sub4);
		}
		
		dao.persistirGrupo(grupoTeste);

	}

}

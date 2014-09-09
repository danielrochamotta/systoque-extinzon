package br.com.radconnect.testes;

import br.com.radconnect.daos.DaoGrupoDoItem;
import br.com.radconnect.entityBeans.GrupoDoItem;
import br.com.radconnect.entityBeans.SubGrupoN1DoGrupo;
import br.com.radconnect.entityBeans.SubGrupoN2DoN1;

public class TestGrupoDoItem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrupoDoItem grupoTeste = new GrupoDoItem();
		SubGrupoN1DoGrupo sub1 = new SubGrupoN1DoGrupo();
		SubGrupoN2DoN1 sub2DoN1 = new SubGrupoN2DoN1();
		DaoGrupoDoItem dao = new DaoGrupoDoItem();
		
		
		grupoTeste.setNome("PO QUIMICO");
		sub1.setNome("SUB1 PO QUIMICO");
		grupoTeste.adicionaSubGrupoN1(sub1);
		
		for(int i = 0; i < 10; i++){
			sub2DoN1 = new SubGrupoN2DoN1();
			sub2DoN1.setNome("Sub2 PO QUIMICO "+(i+1));
			
			sub1.adicionaSubGrupoN2(sub2DoN1);
		}
		
		dao.persistirGrupo(grupoTeste);

	}

}

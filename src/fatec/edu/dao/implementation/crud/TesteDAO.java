package fatec.edu.dao.implementation.crud;

import java.sql.SQLException;

public class TesteDAO {

	public static void main(String[] args) {
//		QuestionarioPtIDAOImpl qt = new QuestionarioPtIDAOImpl();
//		
//		QuestionarioPtI questionarioPtI = new QuestionarioPtI();
//		
//		questionarioPtI.setCpf("57454545");
//		questionarioPtI.setData(new Date());
//		questionarioPtI.setEstadoCivil(1);
//		questionarioPtI.setFiliacaoI("usahdusadhsa");
//		questionarioPtI.setFiliacaoII("usahdusadhsa");
//		questionarioPtI.setIdCidade(1);
//		questionarioPtI.setIdEstado(2);
//		questionarioPtI.setNome("ssdadsadsa");
//		questionarioPtI.setRegismeCasamento("aeohhhh");
//		questionarioPtI.setSexo(1);
//		
//		try {
//			qt.manter(questionarioPtI);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


		QuestionarioPtIDAOImpl qt = new QuestionarioPtIDAOImpl();
		
	
		
	try {
		System.out.println(qt.pesquisarUltimoId());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}

}

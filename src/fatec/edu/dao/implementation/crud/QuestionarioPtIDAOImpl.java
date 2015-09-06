package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIDAO;
import fatec.edu.models.QuestionarioPtI;

public class QuestionarioPtIDAOImpl implements QuestionarioPtIDAO{

	Connection conection;

	public QuestionarioPtIDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}
	
	
	@Override
	public void manter(QuestionarioPtI questionarioPtI) throws SQLException {
		String sql = "insert into Tomadores Values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1, questionarioPtI.getCpf());
		ps.setString(2, questionarioPtI.getNome());
		ps.setDate(3,new java.sql.Date(questionarioPtI.getData().getTime()));
		ps.setString(4, questionarioPtI.getFiliacaoI());
		ps.setString(5, questionarioPtI.getFiliacaoII());
		ps.setInt(6, questionarioPtI.getSexo());
		ps.setInt(7, questionarioPtI.getEstadoCivil());
		ps.setInt(8, questionarioPtI.getRegimeCasamento());
		ps.setString(9, questionarioPtI.getIdEstado());
		ps.setString(10, questionarioPtI.getIdCidade());
		
		ps.execute();
		ps.close();
		
	}

	

}

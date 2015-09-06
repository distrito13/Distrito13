package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIIIDAO;
import fatec.edu.models.QuestionarioPtIII;

public class QuestionarioPtIIIDAOImpl implements QuestionarioPtIIIDAO {

	Connection conection;

	public QuestionarioPtIIIDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(QuestionarioPtIII questionarioPtIII) throws SQLException {
		String sql = "insert into Rendas Values(?, ?, ?, ?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		
		ps.setFloat(1, questionarioPtIII.getValor());
		ps.setString(2, questionarioPtIII.getTipoRenda());
		ps.setString(3, questionarioPtIII.getPeriodo());
		ps.setInt(4, questionarioPtIII.getIdTomador());
		

		
		ps.execute();
		ps.close();
		
	}

}

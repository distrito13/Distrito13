package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIIDAO;
import fatec.edu.models.QuestionarioPtII;

public class QuestionarioPtIIDAOImpl implements QuestionarioPtIIDAO {

	Connection conection;

	public QuestionarioPtIIDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(QuestionarioPtII questionarioPtII) throws SQLException {
		String sql = "insert into ExerceAtividade Values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, questionarioPtII.getCarteiraTrabalho());
		ps.setInt(2, questionarioPtII.getIdAtividade());
		ps.setInt(3, questionarioPtII.getIdEmpresa());
		ps.setDate(4,new java.sql.Date(questionarioPtII.getDataAdmissao().getTime()));
		ps.setInt(5, questionarioPtII.getIdCargo());
		ps.setFloat(6, questionarioPtII.getSalario());
		ps.setInt(7, questionarioPtII.getIdTomador());
		
		ps.execute();
		ps.close();
		
	}

}

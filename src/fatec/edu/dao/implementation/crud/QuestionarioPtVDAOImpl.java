package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fatec.edu.controle.acesso.ControleAcessoDAO;
import fatec.edu.controle.acesso.ControleAcessoDAOImpl;
import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtVDAO;
import fatec.edu.models.QuestionarioPtV;

public class QuestionarioPtVDAOImpl implements QuestionarioPtVDAO {

	Connection conection;

	public QuestionarioPtVDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(QuestionarioPtV questionarioPtV) throws SQLException {
		String sql = "insert into Pendencias Values(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		
		ps.setDate(1,new java.sql.Date(questionarioPtV.getDataAtraso().getTime()));
		ps.setString(2, questionarioPtV.getTipoPendencia());
		ps.setFloat(3, questionarioPtV.getValor());
		ps.setString(4, questionarioPtV.getPeriodo());
		ps.setInt(5, questionarioPtV.getIdOrgao());
		ControleAcessoDAO controleAcessoDAO= new ControleAcessoDAOImpl();
		ps.setInt(6, controleAcessoDAO.retornaIdControleAcesso());
		
		ps.execute();
		ps.close();
		
	}

}

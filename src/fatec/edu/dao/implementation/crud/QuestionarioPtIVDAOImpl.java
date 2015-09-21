package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fatec.edu.controle.acesso.ControleAcessoDAO;
import fatec.edu.controle.acesso.ControleAcessoDAOImpl;
import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIVDAO;
import fatec.edu.models.QuestionarioPtIV;

public class QuestionarioPtIVDAOImpl implements QuestionarioPtIVDAO {

	Connection conection;

	public QuestionarioPtIVDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(QuestionarioPtIV questionarioPtIV) throws SQLException {
		String sql = "insert into Dividas Values(?, ?, ?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		
		ps.setFloat(1, questionarioPtIV.getValor());
		ps.setString(2, questionarioPtIV.getTipoDivida());
		ControleAcessoDAO controleAcessoDAO= new ControleAcessoDAOImpl();
		ps.setInt(3, controleAcessoDAO.retornaIdControleAcesso());
		
		
		ps.execute();
		ps.close();
		
	}
}

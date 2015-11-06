package fatec.edu.dao.implementation.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.controle.acesso.ControleAcessoDAO;
import fatec.edu.controle.acesso.ControleAcessoDAOImpl;
import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.dao.interfaces.crud.QuestionarioPtIIDAO;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtII;

public class QuestionarioPtIIDAOImpl implements QuestionarioPtIIDAO {

	Connection conection;

	public QuestionarioPtIIDAOImpl(){
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public void manter(QuestionarioPtII questionarioPtII) throws SQLException {
		ControleAcessoDAO controleAcessoDAO= new ControleAcessoDAOImpl();
		
		String sql = "insert into ExerceAtividade Values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1, questionarioPtII.getIdAtividade());
		ps.setString(2, questionarioPtII.getIdEmpresa());
		ps.setDate(3,new java.sql.Date(questionarioPtII.getDataAdmissao().getTime()));
		ps.setString(4, questionarioPtII.getIdCargo());
		ps.setDouble(5, questionarioPtII.getSalario());
		ps.setString(7, questionarioPtII.getEstabilidade());
		
		
		ps.setInt(6, controleAcessoDAO.retornaIdControleAcesso());
		
		ps.execute();
		ps.close();
		
	}
	
	@Override
	public List<QuestionarioPtII> listarProfissoes() throws SQLException {
		ControleAcessoDAOImpl controleAcessoDAOImpl = new ControleAcessoDAOImpl();
		int idTomador = controleAcessoDAOImpl.retornaIdControleAcesso();
		List<QuestionarioPtII> lista = new ArrayList<QuestionarioPtII>();
		String sql = "SELECT * FROM ExerceAtividade WHERE idTomador = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		System.out.println("UltimoTomador"+idTomador);
		ps.setInt(1, idTomador);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtII questionarioPtII = new QuestionarioPtII();
			questionarioPtII.setId(rs.getInt("idExerceAtividade"));
			questionarioPtII.setIdAtividade(rs.getString("Atividade"));
			questionarioPtII.setIdEmpresa(rs.getString("Empresa"));
			questionarioPtII.setDataAdmissao(rs.getDate("dataAdmissao"));
			questionarioPtII.setIdCargo(rs.getString("Cargo"));
			questionarioPtII.setSalario(rs.getFloat("salario"));
			questionarioPtII.setEstabilidade(rs.getString("estabilidade"));
			questionarioPtII.setIdTomador(rs.getInt("idTomador"));
			lista.add(questionarioPtII);
		}
		ps.close();
		rs.close();
		return lista;
	}

}

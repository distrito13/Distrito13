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
import fatec.edu.models.QuestionarioPtII;

/**
 * 
 * @author Concecred
 * @since 10/11/2015 Classe para fazer as operações sobre Dados Profissionais no
 *        banco de dados.
 *
 */
public class QuestionarioPtIIDAOImpl implements QuestionarioPtIIDAO {

	Connection conection;

	/**
	 * Construtor da classe inicializando o genericDao
	 */
	public QuestionarioPtIIDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	/**
	 * Método para inserir as dados profissionais do Tomador no Banco de dados
	 * 
	 * @param questionarioPtII
	 */
	@Override
	public void manter(QuestionarioPtII questionarioPtII) throws SQLException {
		ControleAcessoDAO controleAcessoDAO = new ControleAcessoDAOImpl();

		String sql = "insert into ExerceAtividade Values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1, questionarioPtII.getIdAtividade());
		ps.setString(2, questionarioPtII.getIdEmpresa());
		ps.setDate(3, new java.sql.Date(questionarioPtII.getDataAdmissao().getTime()));
		ps.setString(4, questionarioPtII.getIdCargo());
		ps.setDouble(5, questionarioPtII.getSalario());
		ps.setString(7, questionarioPtII.getEstabilidade());

		ps.setInt(6, controleAcessoDAO.retornaIdControleAcesso());

		ps.execute();
		ps.close();

	}

	/**
	 * Método para listar os dados profissionais na Table do banco de dados
	 */
	@Override
	public List<QuestionarioPtII> listarProfissoes() throws SQLException {
		ControleAcessoDAOImpl controleAcessoDAOImpl = new ControleAcessoDAOImpl();
		int idTomador = controleAcessoDAOImpl.retornaIdControleAcesso();
		List<QuestionarioPtII> lista = new ArrayList<QuestionarioPtII>();
		String sql = "SELECT * FROM ExerceAtividade WHERE idTomador = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
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
			System.out.println(""+questionarioPtII.getDataAdmissao());
		}
		ps.close();
		rs.close();
		return lista;
	}

	/**
	 * Método usado para fazer os updates de dados profissionais no banco de
	 * dados
	 * 
	 * @param questionarioPtII
	 * @param idProfissional
	 */
	@Override
	public void atualizarDadosProfissionais(QuestionarioPtII questionarioPtII, int idProfissional) throws SQLException {
		
		String sql = "UPDATE ExerceAtividade SET Atividade = ? , Empresa = ? , dataAdmissao = ?, Cargo = ?, salario = ?, estabilidade = ? WHERE idExerceAtividade = " + idProfissional;
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setString(1, questionarioPtII.getIdAtividade());
		ps.setString(2, questionarioPtII.getIdEmpresa());
		ps.setDate(3, new java.sql.Date(questionarioPtII.getDataAdmissao().getTime()));
		ps.setString(4,questionarioPtII.getIdCargo());
		ps.setDouble(5,questionarioPtII.getSalario());
		ps.setString(6, questionarioPtII.getEstabilidade());

		ps.execute();
		ps.close();

	}

	/**
	 * Método usado para deletar determinada atividade profissional do banco de
	 * dados
	 * 
	 * @param questionarioPtII
	 */
	@Override
	public void deletarDadosProfissionais(QuestionarioPtII questionarioPtII) throws SQLException {
		String sql = "DELETE ExerceAtividade WHERE idExerceAtividade = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, questionarioPtII.getId());
		ps.execute();
		ps.close();

	}

}

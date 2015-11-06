package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtIII;
import fatec.edu.models.QuestionarioPtIV;
import fatec.edu.models.QuestionarioPtV;

public interface BuscaEditarTomadorDAO {

	public List<QuestionarioPtI> listarTomadoresCadastrados() throws SQLException;

	public List<QuestionarioPtI> buscaTomador(int idTomador) throws SQLException;

	public String buscarNomeTomador(int idTomador) throws SQLException;

	public String atividade(int idTomador) throws SQLException;

	public String Empresa(int idTomador) throws SQLException;

	public Date dataAdmissao(int idTomador) throws SQLException;

	public String cargo(int idTomador) throws SQLException;

	public String salario(int idTomador) throws SQLException;

	public List<QuestionarioPtIII> buscarPorRenda(int idTomador) throws SQLException;

	public List<QuestionarioPtIV> buscaroPorDivida(int idTomador) throws SQLException;

	public List<QuestionarioPtV> buscarPorPendencia(int idTomador) throws SQLException;
	
	public void darUpdateTomador(int idTomador) throws SQLException;
}

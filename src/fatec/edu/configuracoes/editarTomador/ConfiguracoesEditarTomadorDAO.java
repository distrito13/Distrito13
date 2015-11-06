package fatec.edu.configuracoes.editarTomador;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtIII;

public interface ConfiguracoesEditarTomadorDAO {

	public List<QuestionarioPtI> retornaUsuariodaSessionparaFazerOFiltro() throws SQLException;

	public List<QuestionarioPtIII> retornaListadeRendasDoTomador() throws SQLException;

	public String buscarNomeTomador(int idTomador) throws SQLException;

	public List<QuestionarioPtI> retornaTodoConteudoPrimeiraAba() throws SQLException;
}

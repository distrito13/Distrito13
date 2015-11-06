package fatec.edu.mega.dao.fuzzy;
import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtII;
import fatec.edu.models.QuestionarioPtIII;
import fatec.edu.models.QuestionarioPtIV;
import fatec.edu.models.QuestionarioPtV;

public interface MegaDAO {

	public QuestionarioPtI consultaTomador(QuestionarioPtI tomador) throws SQLException;
	
	//Listas
	
	public List<QuestionarioPtII> listarProfissionais(QuestionarioPtI tomador) throws SQLException;

	public List<QuestionarioPtIII> listarRendas(QuestionarioPtI tomador) throws SQLException;

	public List<QuestionarioPtIV> listarDividas(QuestionarioPtI tomador) throws SQLException;

	public List<QuestionarioPtV> listarPendencias(QuestionarioPtI tomador) throws SQLException;

	//para score profissionais

	public QuestionarioPtII getSomaExerceAtividade(QuestionarioPtI tomador) throws SQLException;

	public double getMediaMesesTrabalhados(QuestionarioPtI tomador) throws SQLException;
	
	//para score rendas

	public QuestionarioPtIII getSomasMediasRenda(QuestionarioPtI tomador) throws SQLException;


	//para score dividas

	public QuestionarioPtIV getSomaDivida(QuestionarioPtI tomador) throws SQLException;

	//para score pendencias

	public QuestionarioPtV  getSomasMediasPendencia(QuestionarioPtI tomador) throws SQLException;

	public int getMediaDiasAtraso(QuestionarioPtI tomador)throws SQLException;
}

package fatec.edu.mega.dao.fuzzy;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtII;
import fatec.edu.models.QuestionarioPtIII;
import fatec.edu.models.QuestionarioPtIV;
import fatec.edu.models.QuestionarioPtV;

public interface MegaDAO2 {

	public Mega pegaDadosTomador(QuestionarioPtI tomador)throws SQLException;
	
	// profissionais

	public Mega pegaDadosExerceAtividade(QuestionarioPtI tomador) throws SQLException;

	// rendas

	public Mega pegaDadosRenda(QuestionarioPtI tomador) throws SQLException;

	// dividas

	public Mega pegaDadosDivida(QuestionarioPtI tomador) throws SQLException;

	// pendencias

	public Mega pegaDadosPendencia(QuestionarioPtI tomador) throws SQLException;

	// Ativo
	public Mega pegaDadosAtivo(QuestionarioPtI tomador) throws SQLException;
	
}

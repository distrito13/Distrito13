package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;
import fatec.edu.models.QuestionarioPtVI;

public interface QuestionarioPtVIDAO {
	public void manter(QuestionarioPtVI questionarioPtVI) throws SQLException;

	public List<QuestionarioPtVI> listarAtivos() throws SQLException;

	void atualizarAtivo(QuestionarioPtVI questionarioPtVI, int idAtivo) throws SQLException;

	void deletarAtivo(QuestionarioPtVI questionarioPtVI) throws SQLException;

}

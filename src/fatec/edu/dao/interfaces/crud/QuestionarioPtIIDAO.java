package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.QuestionarioPtII;

public interface QuestionarioPtIIDAO {
	public void manter(QuestionarioPtII questionarioPtII) throws SQLException;
	
	public List<QuestionarioPtII> listarProfissoes() throws SQLException;
}

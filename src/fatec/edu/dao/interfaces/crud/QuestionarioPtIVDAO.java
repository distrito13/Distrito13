package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.QuestionarioPtIV;

public interface QuestionarioPtIVDAO {
	public void manter(QuestionarioPtIV questionarioPtIV) throws SQLException;

	public List<QuestionarioPtIV> listarDividas() throws SQLException;
}

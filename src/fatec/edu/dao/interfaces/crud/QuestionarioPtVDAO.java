package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;

import fatec.edu.models.QuestionarioPtV;

public interface QuestionarioPtVDAO {
	public void manter(QuestionarioPtV questionarioPtV) throws SQLException;
}

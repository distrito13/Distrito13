package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import fatec.edu.models.QuestionarioPtI;

public interface QuestionarioPtIDAO {

	public void manter(QuestionarioPtI questionarioPtI) throws SQLException;
	
	public int pesquisarUltimoId() throws SQLException;


}


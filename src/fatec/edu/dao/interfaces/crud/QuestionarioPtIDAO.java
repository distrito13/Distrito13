package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.QuestionarioPtI;

public interface QuestionarioPtIDAO {

	public void manter(QuestionarioPtI questionarioPtI) throws SQLException;
	
	public int pesquisarUltimoId() throws SQLException;

	public List<QuestionarioPtI> pesquisar() throws SQLException;

}


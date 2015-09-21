package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.QuestionarioPtIII;

public interface QuestionarioPtIIIDAO {

	public void manter(QuestionarioPtIII questionarioPtIII) throws SQLException;

	public List <QuestionarioPtIII> listarRendas()throws SQLException;
	
	public int consultandoTomador () throws SQLException;
}

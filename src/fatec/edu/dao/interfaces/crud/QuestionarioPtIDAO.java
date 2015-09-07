package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.Sexo;

public interface QuestionarioPtIDAO {

	public void manter(QuestionarioPtI questionarioPtI) throws SQLException;
	
	public List<Sexo> buscarSexo () throws SQLException; 

}


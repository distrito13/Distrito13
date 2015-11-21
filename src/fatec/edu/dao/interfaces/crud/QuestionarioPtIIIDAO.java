package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.QuestionarioPtIII;

/**
 * 
 * @author Concecred 
 * Interface com os m�todos para realizar as opera��es com
 *         d�vidas
 */
public interface QuestionarioPtIIIDAO {

	public void manter(QuestionarioPtIII questionarioPtIII) throws SQLException;

	public List<QuestionarioPtIII> listarRendas() throws SQLException;

	public int consultandoTomador() throws SQLException;

	public void atualizarRenda(QuestionarioPtIII questionarioPtIII, int idRenda) throws SQLException;

	public void deletarRenda(QuestionarioPtIII questionarioPtIII) throws SQLException;

}

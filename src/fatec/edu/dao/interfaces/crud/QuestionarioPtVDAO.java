package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.QuestionarioPtV;

/**
 * 
 * @author Concecred Interface com os métodos para realizar operações com
 *         pendências
 *
 */
public interface QuestionarioPtVDAO {

	public void manter(QuestionarioPtV questionarioPtV) throws SQLException;

	public List<QuestionarioPtV> listarPendencias() throws SQLException;

	public void atualizarPendencia(QuestionarioPtV questionarioPtV, int idPendencia) throws SQLException;

	public void deletarPendencia(QuestionarioPtV questionarioPtV) throws SQLException;

}

package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.QuestionarioPtIV;

/**
 * 
 * @author Concecred
 *  Interface com os m�todos para realizar as opera��es com
 *         d�vidas
 */
public interface QuestionarioPtIVDAO {

	public void manter(QuestionarioPtIV questionarioPtIV) throws SQLException;

	public List<QuestionarioPtIV> listarDividas() throws SQLException;

	public void atualizarDivida(QuestionarioPtIV questionarioPtIV, int idDivdia) throws SQLException;

	public void deletarDivida(QuestionarioPtIV questionarioPtIV) throws SQLException;
}

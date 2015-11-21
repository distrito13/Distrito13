package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.QuestionarioPtII;

/**
 * 
 * @author Concecred Interface com os métodos para realizar as operações com os
 *         dados profissionais
 */
public interface QuestionarioPtIIDAO {
	public void manter(QuestionarioPtII questionarioPtII) throws SQLException;

	public List<QuestionarioPtII> listarProfissoes() throws SQLException;

	public void atualizarDadosProfissionais(QuestionarioPtII questionarioPtII, int idProfissional) throws SQLException;

	public void deletarDadosProfissionais(QuestionarioPtII questionarioPtII) throws SQLException;

}

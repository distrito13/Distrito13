package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Estado;


public interface EstadoDAO {
	public void manter(Estado estado) throws SQLException;

	public List<Estado> pesquisar() throws SQLException;

	public void remover(Estado estado) throws SQLException;
}

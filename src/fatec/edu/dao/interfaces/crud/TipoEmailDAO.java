package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.TipoEmail;

public interface TipoEmailDAO {
	public void manter(TipoEmail tipoEmail) throws SQLException;

	public List<TipoEmail> pesquisar() throws SQLException;

	public void remover(TipoEmail tipoEmail) throws SQLException;
}

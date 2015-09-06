package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.TipoTelefone;

public interface TipoTelefoneDAO {

	public void manter(TipoTelefone tipoTelefone) throws SQLException;

	public List<TipoTelefone> pesquisar() throws SQLException;

	public void remover(TipoTelefone tipoTelefone) throws SQLException;

}

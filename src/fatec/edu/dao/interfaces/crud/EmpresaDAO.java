package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Empresa_vaisair;

public interface EmpresaDAO {
	public void manter(Empresa_vaisair empresa) throws SQLException;

	public List<Empresa_vaisair> pesquisar() throws SQLException;

	public void remover(Empresa_vaisair empresa) throws SQLException;
}

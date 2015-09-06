package fatec.edu.dao.interfaces.crud;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.Empresa;

public interface EmpresaDAO {
	public void manter(Empresa empresa) throws SQLException;

	public List<Empresa> pesquisar() throws SQLException;

	public void remover(Empresa empresa) throws SQLException;
}

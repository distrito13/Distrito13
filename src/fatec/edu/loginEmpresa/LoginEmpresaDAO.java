package fatec.edu.loginEmpresa;

import java.sql.SQLException;
import java.util.List;

public interface LoginEmpresaDAO {
	
	
	public void inserirEmpresa(Credor credor) throws SQLException;

	public List<Credor> buscarLoginSenha(String credorUsuario, String senha) throws SQLException;

	public int buscarLoginId(String credorUsuario, String senha) throws SQLException;
}

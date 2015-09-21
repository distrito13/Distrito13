package fatec.edu.controle.acesso;

import java.sql.SQLException;

import fatec.edu.models.QuestionarioPtI;

public interface ControleAcessoDAO {

	public int retornaIdControleAcesso() throws SQLException;
	
	public void manterControleAcesso(ControleAcesso controleAcesso) throws SQLException;
	
	public boolean identificaTomadorExistente () throws SQLException;
	
	public void inicializarTabelaTomador() throws SQLException;
}

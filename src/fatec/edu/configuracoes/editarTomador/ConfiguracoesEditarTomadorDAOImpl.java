package fatec.edu.configuracoes.editarTomador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.loginEmpresa.Credor;
import fatec.edu.loginEmpresa.LoginEmpresaDAOImpl;
import fatec.edu.loginEmpresa.LoginEmpresaManagedBean;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtIII;
import fatec.edu.models.Tomador;

public class ConfiguracoesEditarTomadorDAOImpl implements ConfiguracoesEditarTomadorDAO {

	Connection conection;
	private String PA_NOME;

	public ConfiguracoesEditarTomadorDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public List<QuestionarioPtI> retornaUsuariodaSessionparaFazerOFiltro() throws SQLException {
		LoginEmpresaManagedBean usuarioLogado = new LoginEmpresaManagedBean();

		List<QuestionarioPtI> lista = new ArrayList<QuestionarioPtI>();
		String sql = "SELECT Tomadores.idTomador,Tomadores.nome , Tomadores.cpf FROM  Tomadores	INNER JOIN CredorTomador ON CredorTomador.idTomador = Tomadores.idTomador AND CredorTomador.idCredor = "
				+ usuarioLogado.usuarioLogado;
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtI questionarioPtI = new QuestionarioPtI();
			questionarioPtI.setId(rs.getInt("idTomador"));
			questionarioPtI.setCpf(rs.getString("cpf"));
			questionarioPtI.setNome(rs.getString("nome"));
			lista.add(questionarioPtI);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public List<QuestionarioPtIII> retornaListadeRendasDoTomador() throws SQLException {
		List<QuestionarioPtIII> lista = new ArrayList<QuestionarioPtIII>();
		String sql = "select DISTINCT Rendas.idRenda, Rendas.valor, Rendas.tipoRenda , Rendas.periodo FROM Rendas INNER JOIN Tomadores ON Rendas.idTomador = " + 9;
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtIII renda = new QuestionarioPtIII();
			renda.setId(rs.getInt("idRenda"));
			renda.setValor(rs.getDouble("valor"));
			renda.setTipoRenda(rs.getString("tipoRenda"));
			renda.setPeriodo(rs.getString("periodo"));
			lista.add(renda);
		}
		ps.close();
		return lista;
	}

	
	public String buscarNomeTomador(int idTomador) throws SQLException {
		List<QuestionarioPtI> lista = new ArrayList<QuestionarioPtI>();
		String sql = "SELECT  nome FROM Tomadores WHERE idTomador =" + idTomador;
		PreparedStatement ps = conection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			QuestionarioPtI qpti = new QuestionarioPtI();
			qpti.setNome(rs.getString("nome"));
			PA_NOME = qpti.getNome();
		}
		ps.close();
		rs.close();
		return PA_NOME;
	}

	@Override
	public List<QuestionarioPtI> retornaTodoConteudoPrimeiraAba() throws SQLException {
		List<QuestionarioPtI> lista = new ArrayList<QuestionarioPtI>();
		String sql = "SELECT * FROM Tomadores";
		PreparedStatement ps = conection.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtI questionarioPtI = new QuestionarioPtI();
			questionarioPtI.setId(rs.getInt("idTomador"));
			questionarioPtI.setCpf(rs.getString("cpf"));
			questionarioPtI.setNome(rs.getString("nome"));
			questionarioPtI.setData(rs.getDate("dataNasc"));
			questionarioPtI.setFiliacaoI(rs.getString("filiacaoResp1"));
			questionarioPtI.setFiliacaoII(rs.getString("filiacaoResp2"));
			questionarioPtI.setSexo(rs.getInt("idSexo"));
			questionarioPtI.setEstadoCivil(rs.getString("estadoCivil"));
			questionarioPtI.setRegimeCasamento(rs.getString("regimeCasamento"));
			questionarioPtI.setIdEstado(rs.getInt("idEstado"));
			questionarioPtI.setCidade(rs.getString("cidade"));
			questionarioPtI.setEscolaridade(rs.getString("escolaridade"));

			lista.add(questionarioPtI);
		}
		ps.close();
		rs.close();
		return lista;
	}
	
}

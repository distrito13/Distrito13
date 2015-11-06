package fatec.edu.mega.dao.fuzzy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fatec.edu.controle.acesso.ControleAcessoDAOImpl;
import fatec.edu.dao.generic.GenericDAO;
import fatec.edu.models.Atividade_vaisair;

import fatec.edu.models.Cidade_vaisair;
import fatec.edu.models.Estado;
import fatec.edu.models.ExercAtividade;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtII;
import fatec.edu.models.QuestionarioPtIII;
import fatec.edu.models.QuestionarioPtIV;
import fatec.edu.models.QuestionarioPtV;
import fatec.edu.models.Sexo;
import fatec.edu.models.Tomador;

public class MegaDAOImpl implements MegaDAO {

	Connection conection;

	public MegaDAOImpl() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	@Override
	public QuestionarioPtI consultaTomador(QuestionarioPtI tomador) throws SQLException {
		String sql = "SELECT * FROM Tomadores WHERE idTomador = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		System.out.println("Tomador:" + tomador.getId());
		ps.setInt(1, tomador.getId());
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
		}
		ps.close();
		rs.close();
		return tomador;
	}

	@Override
	public List<QuestionarioPtII> listarProfissionais(QuestionarioPtI tomador) throws SQLException {

		List<QuestionarioPtII> lista = new ArrayList<QuestionarioPtII>();
		String sql = "SELECT * FROM ExerceAtividade WHERE idTomador = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		System.out.println("Tomador:" + tomador.getId());
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtII questionarioPtII = new QuestionarioPtII();
			questionarioPtII.setId(rs.getInt("idExerceAtividade"));
			questionarioPtII.setIdAtividade(rs.getString("Atividade"));
			questionarioPtII.setIdEmpresa(rs.getString("Empresa"));
			questionarioPtII.setDataAdmissao(rs.getDate("dataAdmissao"));
			questionarioPtII.setIdCargo(rs.getString("Cargo"));
			questionarioPtII.setSalario(rs.getFloat("salario"));
			questionarioPtII.setEstabilidade(rs.getString("estabilidade"));
			questionarioPtII.setIdTomador(rs.getInt("idTomador"));
			lista.add(questionarioPtII);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public List<QuestionarioPtIII> listarRendas(QuestionarioPtI tomador) throws SQLException {

		List<QuestionarioPtIII> lista = new ArrayList<QuestionarioPtIII>();
		String sql = "SELECT * FROM Rendas WHERE idTomador = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		System.out.println("Tomador:" + tomador.getId());
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtIII questionarioPtIII = new QuestionarioPtIII();
			questionarioPtIII.setId(rs.getInt("idRenda"));
			questionarioPtIII.setTipoRenda("tipoRenda");
			questionarioPtIII.setValor(rs.getDouble("valor"));
			questionarioPtIII.setPeriodo(rs.getString("periodo"));
			questionarioPtIII.setIdTomador(rs.getInt("idTomador"));
			lista.add(questionarioPtIII);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public List<QuestionarioPtIV> listarDividas(QuestionarioPtI tomador) throws SQLException {

		List<QuestionarioPtIV> lista = new ArrayList<QuestionarioPtIV>();
		String sql = "SELECT * FROM Dividas WHERE idTomador = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		System.out.println("Tomador:" + tomador.getId());
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtIV questionarioPtIV = new QuestionarioPtIV();
			questionarioPtIV.setId(rs.getInt("idDivida"));
			questionarioPtIV.setTipoDivida("tipoDivida");
			questionarioPtIV.setValor(rs.getFloat("valor"));
			questionarioPtIV.setIdTomador(rs.getInt("idTomador"));
			lista.add(questionarioPtIV);
		}
		ps.close();
		rs.close();
		return lista;
	}

	@Override
	public List<QuestionarioPtV> listarPendencias(QuestionarioPtI tomador) throws SQLException {

		List<QuestionarioPtV> lista = new ArrayList<QuestionarioPtV>();
		String sql = "SELECT * FROM Pendencias WHERE idTomador = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		System.out.println("Tomador:" + tomador.getId());
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			QuestionarioPtV questionarioPtV = new QuestionarioPtV();
			questionarioPtV.setId(rs.getInt("idPendencia"));
			questionarioPtV.setTipoPendencia("tipoPendencia");
			questionarioPtV.setValor(rs.getFloat("valor"));
			questionarioPtV.setPeriodo(rs.getString("periodo"));
			questionarioPtV.setIdOrgao(rs.getInt("idOrgao"));
			questionarioPtV.setIdTomador(rs.getInt("idTomador"));
			lista.add(questionarioPtV);
		}
		ps.close();
		rs.close();
		return lista;
	}
////////////////////////////////////--SCORE
	@Override
	public QuestionarioPtII getSomaExerceAtividade(QuestionarioPtI tomador) throws SQLException {
		QuestionarioPtII somaExerceAtividade = new QuestionarioPtII();
		String sql = "select t.idTomador,SUM(e.salario)as somaSalario " 
				+ "from Tomadores t "
				+ "inner join ExerceAtividade e " 
				+ "on e.idTomador = t.idTomador " 
				+ "where t.idTomador= ? "
				+ "group by t.idTomador ";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			somaExerceAtividade.setSalario(rs.getDouble("somaSalario"));
            //estabilidade --> versão futura do BD	
		}
		ps.close();
		rs.close();
		return somaExerceAtividade;
	}

	@Override
	public double getMediaMesesTrabalhados(QuestionarioPtI tomador) throws SQLException {
		double MediaMesesTrabalhados=0;
		String sql = "select t.idTomador,((AVG(DATEDIFF(MONTH,GETDATE(),e.dataAdmissao)))*-1)as mediaMesesTrabalhados "+		
				"from Tomadores t "+
				"inner join ExerceAtividade e "+
				"on e.idTomador = t.idTomador "+
				"where t.idTomador= ? "+
				"group by t.idTomador"; 
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			MediaMesesTrabalhados =rs.getDouble("mediaMesesTrabalhados");
		}
		ps.close();
		rs.close();
		return MediaMesesTrabalhados;
	}

	@Override
	public QuestionarioPtIII getSomasMediasRenda(QuestionarioPtI tomador) throws SQLException {
		QuestionarioPtIII somasMediasRenda = new QuestionarioPtIII();
		String sql = "select t.idTomador,SUM( r.valor) as somarenda, "+
				"avg(case(r.periodo) "+
						"when 'Diário' then 1 "+
						"when 'Mensal' then 30 "+
						"when 'Bimestral' then 60 "+
						"when 'Trimestral' then 90 "+
						"when 'Semestral' then 182 "+
						"when 'Anual' then 365 "+
					"end) as mediaPeriodo "+
				"from Tomadores t "+
				"inner join Rendas r "+
				"on r.idTomador = t.idTomador "+
				"where t.idTomador= ? "+
				"group by t.idTomador";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			somasMediasRenda.setValor(rs.getDouble("somaRenda"));
			somasMediasRenda.setPeriodo(String.valueOf(rs.getDouble("mediaPeriodo")));
		}
		ps.close();
		rs.close();
		return somasMediasRenda;
	}

	@Override
	public QuestionarioPtIV getSomaDivida(QuestionarioPtI tomador) throws SQLException {
		QuestionarioPtIV somaDivida = new QuestionarioPtIV();
		String sql = "select t.idTomador,SUM(d.valor)as somaDivida " 
				+ "from Tomadores t "
				+ "inner join Dividas d " 
				+ "on d.idTomador = t.idTomador " 
				+ "where t.idTomador= ? "
				+ "group by t.idTomador ";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			somaDivida.setValor(rs.getDouble("somaDivida"));
		}
		ps.close();
		rs.close();
		return somaDivida;
	}

	@Override
	public QuestionarioPtV getSomasMediasPendencia(QuestionarioPtI tomador) throws SQLException {
		QuestionarioPtV somasMediasPendencia = new QuestionarioPtV();
		String sql = "select t.idTomador,SUM( p.valor) as somaPendencia, "+
				"avg(case(p.periodo) "+
						"when 'Diário' then 1 "+
						"when 'Mensal' then 30 "+
						"when 'Bimestral' then 60 "+
						"when 'Trimestral' then 90 "+
						"when 'Semestral' then 182 "+
						"when 'Anual' then 365 "+
					"end) as mediaPeriodo "+
				"from Tomadores t "+
				"inner join Pendencias p "+
				"on p.idTomador = t.idTomador "+
				"where t.idTomador= ? "+
				"group by t.idTomador";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			somasMediasPendencia.setValor(rs.getDouble("somaPendencia"));
			somasMediasPendencia.setPeriodo(String.valueOf(rs.getDouble("mediaPeriodo")));
		}
		ps.close();
		rs.close();
		return somasMediasPendencia;
	}

	@Override
	public int getMediaDiasAtraso(QuestionarioPtI tomador) throws SQLException {
		int MediaDiasAtraso=0;
		String sql = "select t.idTomador, ((AVG(DATEDIFF(DAY,GETDATE(),p.dataAtraso)))*-1)as mediaDiasAtraso "+		
				"from Tomadores t "+
				"inner join Pendencias p "+
				"on p.idTomador = t.idTomador "+
				"where t.idTomador= ? "+
				"group by t.idTomador"; 
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			MediaDiasAtraso =rs.getInt("mediaDiasAtraso");
		}
		ps.close();
		rs.close();
		return MediaDiasAtraso;
	}

}

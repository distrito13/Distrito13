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

public class MegaDAOImpl2 implements MegaDAO2 {

	Connection conection;

	public MegaDAOImpl2() {
		GenericDAO gDao = new GenericDAO();
		conection = gDao.getConnection();
	}

	////////////////////////////////////--SCORE
	@Override
	public Mega pegaDadosTomador(QuestionarioPtI tomador) throws SQLException {
		Mega dadosTomador = new Mega();
		String sql = "select idTomador,"
				+"case(escolaridade)"
				+	" when 'Analfabeto' then 0"
				+	" when 'Ensino fundamental I Incompleto' then 1"
				+	" when 'Ensino Fundamental II Incompleto' then 2"
				+	" when 'Ensino Fundamental Completo' then 3"
				+	" when 'Ensino Médio Incompleto' then 4"
				+	" when 'Ensino Médio Completo' then 5"
				+	" when 'Técnico Completo' then 6"
				+	" when 'Ensino Superior Incompleto' then 7"
				+	" when 'Ensino Superior Completo' then 8"
				+	" when 'Mestrado e Doutorado' then 9"
				+" end as valorEscolaridade" 
				+" from Tomadores"
				+" where idTomador= ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			dadosTomador.setIdTomador(rs.getInt("idTomador"));
			dadosTomador.setValorEscolaridade(rs.getInt("valorEscolaridade"));
            
		}
		ps.close();
		rs.close();
		return dadosTomador;
	}
	
	@Override
	public Mega pegaDadosExerceAtividade(QuestionarioPtI tomador) throws SQLException {
		Mega dadosExerceAtividade = new Mega();
		String sql = "select SUM(salario)as somasalario,"
				+" salariosminimos=SUM(salario)/788,"
				+" ((AVG(DATEDIFF(MONTH,GETDATE(),dataAdmissao)))*-1)as mediaMesesTrabalhados,"
				+" SUM(case(estabilidade)"
				+	" when 'Autônomo' then 0"
				+	" when 'Funcionário de Empresa privada' then 1"
				+	" when 'Funcionário do setor Público' then 2"
				+	" end)as valorEstabilidade"			
				+" from ExerceAtividade"
				+" where idTomador= ? ";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			dadosExerceAtividade.setQuantidadeSalariosMinimosSalario(rs.getDouble("salariosminimos"));
            dadosExerceAtividade.setMediaMesesTrabalhados(rs.getDouble("mediaMesesTrabalhados"));
            dadosExerceAtividade.setValorEstabilidade(rs.getInt("valorEstabilidade"));
		}
		ps.close();
		rs.close();
		return dadosExerceAtividade;
	}

	@Override
	public Mega pegaDadosRenda(QuestionarioPtI tomador) throws SQLException {
		Mega dadosRenda = new Mega();
		String sql = "select SUM(valor) as somarenda,salariosminimos=SUM(valor)/788," 
				+" avg(case(periodo)"
					+" when 'Diário' then 1"
					+" when 'Mensal' then 30"
					+" when 'Bimestral' then 60"
					+" when 'Trimestral' then 90"
					+" when 'Semestral' then 182"
					+" when 'Anual' then 365"
				+" end) as mediaPeriodo"
				+" from  Rendas" 
				+" where idTomador= ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			dadosRenda.setQuantidadeSalariosMinimosRenda(rs.getDouble("salariosminimos"));
			dadosRenda.setMediaPeriodoRenda(rs.getDouble("mediaPeriodo"));
		}
		ps.close();
		rs.close();
		return dadosRenda;
	}

	@Override
	public Mega pegaDadosDivida(QuestionarioPtI tomador) throws SQLException {
		Mega dadosDivida = new Mega();
		String sql = "select SUM(valor) as somaDivida,"
					+" salariosminimos=SUM(valor)/788"
					+" from  Dividas"
					+" where idTomador= ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			dadosDivida.setQuantidadeSalariosMinimosDivida(rs.getDouble("salariosminimos"));
		}
		ps.close();
		rs.close();
		return dadosDivida;
	}

	@Override
	public Mega pegaDadosPendencia(QuestionarioPtI tomador) throws SQLException {
		Mega dadosPendencia = new Mega();
		String sql = "select SUM( valor) as somaPendencia,salariosminimos=SUM(valor)/788," 
				+" avg(case(periodo)"
					+" when 'Diário' then 1"
					+" when 'Mensal' then 30"
					+" when 'Bimestral' then 60"
					+" when 'Trimestral' then 90"
					+" when 'Semestral' then 182"
					+" when 'Anual' then 365"
					+" end) as mediaPeriodo,"
					+" ((AVG(DATEDIFF(DAY,GETDATE(),dataAtraso)))*-1)as mediaDiasAtraso"
					+" from Pendencias" 
					+" where idTomador= ? ";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			dadosPendencia.setQuantidadeSalariosMinimosPendencia(rs.getDouble("salariosminimos"));
			dadosPendencia.setMediaPeriodoPendencia(rs.getDouble("mediaPeriodo"));
			dadosPendencia.setMediaDiasAtraso(rs.getInt("mediaDiasAtraso"));
			
            
		}
		ps.close();
		rs.close();
		return dadosPendencia;
	}

	@Override
	public Mega pegaDadosAtivo(QuestionarioPtI tomador) throws SQLException {
		Mega dadosAtivos = new Mega();
		String sql = "select SUM(valor) as somaAtivos,"
				+"salariosminimos=SUM(valor)/788,"
				+" count(case(tipo) when 'Automóvel' then 1 end) as quantidadeAutomoveis,"
				+" count(case(tipo) when 'Imóvel' then 1 end) as quantidadeImoveis,"
				+" count(case(tipo) when 'Terreno' then 1 end) as quantidadeTerrenos,"
				+" count(case(tipo) when 'Outros' then 1 end) as quantidadeOutros"
		 +" from Ativos where idTomador = ?";
		PreparedStatement ps = conection.prepareStatement(sql);
		ps.setInt(1, tomador.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			dadosAtivos.setQuantidadeSalariosMinimosAtivos(rs.getDouble("salariosminimos"));
			dadosAtivos.setQuantidadeAutomoveis(rs.getInt("quantidadeAutomoveis"));
			dadosAtivos.setQuantidadeImoveis(rs.getInt("quantidadeImoveis"));
			dadosAtivos.setQuantidadeTerrenos(rs.getInt("quantidadeTerrenos"));
            
		}
		ps.close();
		rs.close();
		return dadosAtivos;
	}

	
	

}

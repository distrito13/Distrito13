package fatec.edu.fuzzy;


import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import fatec.edu.dao.implementation.crud.AvaliacaoDAOImpl;
import fatec.edu.dao.interfaces.crud.AvaliacaoDAO;
import fatec.edu.mega.dao.fuzzy.Mega;
import fatec.edu.mega.dao.fuzzy.MegaDAO;
import fatec.edu.mega.dao.fuzzy.MegaDAO2;
import fatec.edu.mega.dao.fuzzy.MegaDAOImpl;
import fatec.edu.mega.dao.fuzzy.MegaDAOImpl2;
import fatec.edu.models.Avaliacao;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtII;
import fatec.edu.models.QuestionarioPtIII;
import fatec.edu.models.QuestionarioPtIV;
import fatec.edu.models.QuestionarioPtV;

public class TesteControladorFuzzy2 {
	
	
	public static void main(String[] args) throws SQLException {
		ControladorFuzzy2 ctrFuzzy = null;
		
		ctrFuzzy = new ControladorFuzzy2("\\src\\default2.fcl");


		MegaDAO2 mDao = new MegaDAOImpl2();
		QuestionarioPtI q1 = new QuestionarioPtI();
		q1.setId(32); //<--- 32

				
		Mega megamodel=new Mega();

		megamodel.setIdTomador(mDao.pegaDadosTomador(q1).getIdTomador());
		megamodel.setValorEscolaridade(mDao.pegaDadosTomador(q1).getValorEscolaridade());
		
		megamodel.setQuantidadeSalariosMinimosSalario(mDao.pegaDadosExerceAtividade(q1).getQuantidadeSalariosMinimosSalario());
		megamodel.setMediaMesesTrabalhados(mDao.pegaDadosExerceAtividade(q1).getMediaMesesTrabalhados());
		megamodel.setValorEstabilidade(mDao.pegaDadosExerceAtividade(q1).getValorEstabilidade());
		
		megamodel.setQuantidadeSalariosMinimosRenda(mDao.pegaDadosRenda(q1).getQuantidadeSalariosMinimosRenda());
		megamodel.setMediaPeriodoRenda(mDao.pegaDadosRenda(q1).getMediaPeriodoRenda());
		
		megamodel.setQuantidadeSalariosMinimosDivida(mDao.pegaDadosDivida(q1).getQuantidadeSalariosMinimosDivida());
		
		megamodel.setQuantidadeSalariosMinimosPendencia(mDao.pegaDadosPendencia(q1).getQuantidadeSalariosMinimosPendencia());
		megamodel.setMediaPeriodoPendencia(mDao.pegaDadosPendencia(q1).getMediaPeriodoPendencia());
		megamodel.setMediaDiasAtraso(mDao.pegaDadosPendencia(q1).getMediaDiasAtraso());
		
		megamodel.setQuantidadeSalariosMinimosAtivos(mDao.pegaDadosAtivo(q1).getQuantidadeSalariosMinimosAtivos());
		megamodel.setQuantidadeAutomoveis(mDao.pegaDadosAtivo(q1).getQuantidadeAutomoveis());
		megamodel.setQuantidadeImoveis(mDao.pegaDadosAtivo(q1).getQuantidadeImoveis());
		megamodel.setQuantidadeTerrenos(mDao.pegaDadosAtivo(q1).getQuantidadeTerrenos());

		
		
		Avaliacao av = new Avaliacao();		
	
		av.setScoreExerceAtividade(ctrFuzzy.getScoreSalario(megamodel.getQuantidadeSalariosMinimosSalario(), megamodel.getMediaMesesTrabalhados(), megamodel.getValorEstabilidade()));
		av.setScoreRenda(ctrFuzzy.getScoreRenda(megamodel.getQuantidadeSalariosMinimosRenda(),megamodel.getMediaPeriodoRenda()));
		//av.setScoreDivida(ctrFuzzy.getScoreDivida(megamodel.getQuantidadeSalariosMinimosDivida()));
		//av.setScorePendencia(ctrFuzzy.getScorePendencia(megamodel.getQuantidadeSalariosMinimosPendencia(), megamodel.getMediaPeriodoPendencia(),megamodel.getMediaDiasAtraso()));
		
		//test chumbando valores em salario minimo de divida e pendencia
		av.setScoreDivida(ctrFuzzy.getScoreDivida(0.2));
		av.setScorePendencia(ctrFuzzy.getScorePendencia(0.2, megamodel.getMediaPeriodoPendencia(),megamodel.getMediaDiasAtraso()));
		
		
		double scoreGastos = ctrFuzzy.getScoreGastos(av.getScoreDivida(), av.getScorePendencia());
		double scoreCapital = ctrFuzzy.getScoreCapital(av.getScoreRenda(), av.getScoreExerceAtividade());
		
		
		double scoreCapitalAtivos=ctrFuzzy.getScoreAtivos(megamodel.getQuantidadeAutomoveis(),megamodel.getQuantidadeImoveis(), megamodel.getQuantidadeTerrenos());
		double scoreAtivoTomador=ctrFuzzy.getScoreCapitalAtivos(megamodel.getQuantidadeSalariosMinimosAtivos(), megamodel.getQuantidadeSalariosMinimosSalario());
		double scoreTomador2 = ctrFuzzy.getScoreTomador2(scoreCapitalAtivos, scoreAtivoTomador);
		
		av.setScoreAtivo(scoreTomador2);
		
		double scoreTomador1= ctrFuzzy.getScoreTomador1(scoreCapital, scoreGastos);
		double scoreTomador3= ctrFuzzy.getScoreTomador3(scoreTomador2, megamodel.getValorEscolaridade());
		
		av.setScoreTomador(ctrFuzzy.getScoreTomadorFinal(scoreTomador1, scoreTomador3));
		
		av.setValorEmprestimo(100);
		av.setScoreFinal(ctrFuzzy.getScoreTomadorFinal(av.getScoreTomador(), av.getValorEmprestimo()));
		
		System.out.println(
				
			"\nSALARIO :"+ av.getScoreExerceAtividade()+ "%"
			
			+ "\nRENDA :"+ av.getScoreRenda()+ "%"
			
			+ "\nDIVIDA :"+ av.getScoreDivida()+ "%"
			
			+ "\nPENDÊNCIA :"+ av.getScorePendencia()+ "%"
			
			+ "\n VALOR ATIVOS :"+ scoreCapitalAtivos+ "%"
			+ "\n NUMERO DE ATIVOS :"+ scoreAtivoTomador+ "%"
			+ "\n ATIVOS :"+ scoreTomador2+ "%"
			+ "\n -GASTOS:" + scoreGastos  + "%"
			+ "\n -CAPITAL " + scoreCapital+ "%"
			
			+ "\n TOMADOR SCORE 1 :"	+ scoreTomador1+ "%"
					+ "\n TOMADOR SCORE 3-que usa score ATIVOS :"	+ scoreTomador3+ "%"
			+ "\n Tomador FINAL :"	+ av.getScoreTomador()+ "%"
			
			+ "\n Final EMPRESTIMO :"	+ av.getScoreFinal()+ "%"
				
				);
		
		av.setIdTomador(32);
		av.setIdCredor(1);
	av.setDataAvaliação(new Date());
		
		
	/*	AvaliacaoDAO avDao = new AvaliacaoDAOImpl();
		avDao.gravarScoreTomador(av);*/
		
		
		
		
		
		//Recebendo do Banco 
		
		
/*		AvaliacaoDAO avDao = new AvaliacaoDAOImpl();
		
		Avaliacao av = new Avaliacao();
		
		
		av = avDao.pesquisarScoreIDTomador(1);
				
		
		System.out.println(
				
			"\nSalario : "+ av.getScoreExerceAtividade() + "%"
			+ "\nRenda : "+ av.getScoreRenda() + "%"
			+ "\nDivida : "+ av.getScoreDivida()+ "%"
			+ "\nPendencia : "+ av.getScorePendencia()+ "%"
			+ "\nTomador : "	+ av.getScoreTomador()+ "%"
			+ "\nEmprestimo : " + av.getValorEmprestimo()+ "%"
			+ "\nFinal : "	+ av.getScoreFinal()+ "%"
				
				);
		
		*/
		

		
		}

}

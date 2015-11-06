package fatec.edu.fuzzy;


import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import fatec.edu.dao.implementation.crud.AvaliacaoDAOImpl;
import fatec.edu.dao.interfaces.crud.AvaliacaoDAO;
import fatec.edu.mega.dao.fuzzy.MegaDAO;
import fatec.edu.mega.dao.fuzzy.MegaDAOImpl;
import fatec.edu.models.Avaliacao;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtII;
import fatec.edu.models.QuestionarioPtIII;
import fatec.edu.models.QuestionarioPtIV;
import fatec.edu.models.QuestionarioPtV;

public class TesteControladorFuzzy {
	
	
	public static void main(String[] args) throws SQLException {
		ControladorFuzzy ctrFuzzy = null;
		
		ctrFuzzy = new ControladorFuzzy("\\src\\default.fcl");


		MegaDAO mDao = new MegaDAOImpl();
		QuestionarioPtI q1 = new QuestionarioPtI();
		q1.setId(36); //<--- 21? 21 tem rendas e etc?

		QuestionarioPtIII renda = mDao.getSomasMediasRenda(q1);
		
		//so pra checar
      	//renda.setValor(1200);
		QuestionarioPtIV divida = mDao.getSomaDivida(q1);

		QuestionarioPtV pendencia = mDao.getSomasMediasPendencia(q1);
		//pendencia.setValor(2000);
		
		
		Avaliacao av = new Avaliacao();

		QuestionarioPtII ea = mDao.getSomaExerceAtividade(q1);

		JOptionPane.showMessageDialog(null, ea.getSalario());
		
	
		av.setScoreExerceAtividade(ctrFuzzy.getScoreSalario(ea, mDao.getMediaMesesTrabalhados(q1), 2));
		av.setScoreRenda(ctrFuzzy.getScoreRenda(renda));
		av.setScoreDivida(ctrFuzzy.getScoreDivida(divida));
		av.setScorePendencia(ctrFuzzy.getScorePedencia(pendencia, mDao.getMediaDiasAtraso(q1)));
		
		double scoreGastos = ctrFuzzy.getScoreGastos(av.getScoreDivida(), av.getScorePendencia());
		double scoreCapital = ctrFuzzy.getScoreCapital(av.getScoreRenda(), av.getScoreExerceAtividade());
		
		av.setScoreTomador( ctrFuzzy.getScoreTomador((ctrFuzzy.getScoreCapital(av.getScoreRenda(), av.getScoreExerceAtividade())),
				(ctrFuzzy.getScoreGastos(av.getScoreDivida(), av.getScorePendencia() ) )));
		
		av.setValorEmprestimo(5000);
		av.setScoreFinal(ctrFuzzy.getScoreTomadorFinal(av.getScoreTomador(), av.getValorEmprestimo()));
		
		System.out.println(
				
			"\nSalario :"+ av.getScoreExerceAtividade()+ "%"
			+ "\nRenda :"+ av.getScoreRenda()+ "%"
			+ "\nDivida :"+ av.getScoreDivida()+ "%"
			+ "\nPendencia :"+ av.getScorePendencia()+ "%"
			+ "\nGastos:" + ctrFuzzy.getScoreGastos(av.getScoreDivida(), av.getScorePendencia())  + "%"
			+ "\nCapital " + ctrFuzzy.getScoreCapital(av.getScoreRenda(), av.getScoreExerceAtividade())+ "%"
			+ "\nTomador :"	+ av.getScoreTomador()+ "%"
			+ "\nFinal :"	+ av.getScoreFinal()+ "%"
				
				);
		
		av.setIdTomador(36);
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

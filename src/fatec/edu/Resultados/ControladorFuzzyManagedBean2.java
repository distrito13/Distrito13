package fatec.edu.Resultados;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fatec.edu.GerenciadorResultados.GerenciaResultadosManagedBean;
import fatec.edu.controle.acesso.ControleAcessoDAO;
import fatec.edu.controle.acesso.ControleAcessoDAOImpl;
import fatec.edu.dao.implementation.crud.AvaliacaoDAOImpl;
import fatec.edu.dao.interfaces.crud.AvaliacaoDAO;
import fatec.edu.fuzzy.ControladorFuzzy;
import fatec.edu.fuzzy.ControladorFuzzy2;
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

@ManagedBean
@SessionScoped
public class ControladorFuzzyManagedBean2 {

	private QuestionarioPtI questionarioptIAtual;
	private Mega megamodel;
	private MegaDAO2 megaDAO;
	private ControleAcessoDAO controleAcessoDAO;


	public ControladorFuzzyManagedBean2() {
		questionarioptIAtual = new QuestionarioPtI();
		megamodel = new Mega();
		setControleAcessoDAO(new ControleAcessoDAOImpl());
		megaDAO = new MegaDAOImpl2();
	}

	public String realizaSomaTotal() throws IOException {

		try {
			//questionarioptIAtual.setId(controleAcessoDAO.retornaIdControleAcesso());
			questionarioptIAtual.setId(32);

			megamodel.setIdTomador(megaDAO.pegaDadosTomador(questionarioptIAtual).getIdTomador());
			megamodel.setValorEscolaridade(megaDAO.pegaDadosTomador(questionarioptIAtual).getValorEscolaridade());
			
			megamodel.setQuantidadeSalariosMinimosSalario(megaDAO.pegaDadosExerceAtividade(questionarioptIAtual).getQuantidadeSalariosMinimosSalario());
			megamodel.setMediaMesesTrabalhados(megaDAO.pegaDadosExerceAtividade(questionarioptIAtual).getMediaMesesTrabalhados());
			megamodel.setValorEstabilidade(megaDAO.pegaDadosExerceAtividade(questionarioptIAtual).getValorEstabilidade());
			
			megamodel.setQuantidadeSalariosMinimosRenda(megaDAO.pegaDadosRenda(questionarioptIAtual).getQuantidadeSalariosMinimosRenda());
			megamodel.setMediaPeriodoRenda(megaDAO.pegaDadosRenda(questionarioptIAtual).getMediaPeriodoRenda());
			
			megamodel.setQuantidadeSalariosMinimosDivida(megaDAO.pegaDadosDivida(questionarioptIAtual).getQuantidadeSalariosMinimosDivida());
			
			megamodel.setQuantidadeSalariosMinimosPendencia(megaDAO.pegaDadosPendencia(questionarioptIAtual).getQuantidadeSalariosMinimosPendencia());
			megamodel.setMediaPeriodoPendencia(megaDAO.pegaDadosPendencia(questionarioptIAtual).getMediaPeriodoPendencia());
			megamodel.setMediaDiasAtraso(megaDAO.pegaDadosPendencia(questionarioptIAtual).getMediaDiasAtraso());
			
			megamodel.setQuantidadeSalariosMinimosAtivos(megaDAO.pegaDadosAtivo(questionarioptIAtual).getQuantidadeSalariosMinimosAtivos());
			megamodel.setQuantidadeAutomoveis(megaDAO.pegaDadosAtivo(questionarioptIAtual).getQuantidadeAutomoveis());
			megamodel.setQuantidadeImoveis(megaDAO.pegaDadosAtivo(questionarioptIAtual).getQuantidadeImoveis());
			megamodel.setQuantidadeTerrenos(megaDAO.pegaDadosAtivo(questionarioptIAtual).getQuantidadeTerrenos());

			
			geraAvaliacao();
			System.out.println("entrou no bean-geraavaliacao");
			
			GerenciaResultadosManagedBean gr = new GerenciaResultadosManagedBean();
			
			gr.estabeleceComparativo();
			System.out.println("entrou no estabeleceComparativo");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("passou");
		return "ok";
	}

	public void geraAvaliacao() throws SQLException, IOException {
		ControladorFuzzy2 controladorFuzzy = new ControladorFuzzy2();
		System.out.println("entrou no metodo-geraavaliacao");
		
		Avaliacao avaliacao = new Avaliacao();		
		
		avaliacao.setScoreExerceAtividade(controladorFuzzy.getScoreSalario(megamodel.getQuantidadeSalariosMinimosSalario(), megamodel.getMediaMesesTrabalhados(), megamodel.getValorEstabilidade()));
		avaliacao.setScoreRenda(controladorFuzzy.getScoreRenda(megamodel.getQuantidadeSalariosMinimosRenda(),megamodel.getMediaPeriodoRenda()));
		//avaliacao.setScoreDivida(controladorFuzzy.getScoreDivida(megamodel.getQuantidadeSalariosMinimosDivida()));
		//avaliacao.setScorePendencia(controladorFuzzy.getScorePendencia(megamodel.getQuantidadeSalariosMinimosPendencia(), megamodel.getMediaPeriodoPendencia(),megamodel.getMediaDiasAtraso()));
		
		//test chumbando valores em salario minimo de divida e pendencia
		avaliacao.setScoreDivida(controladorFuzzy.getScoreDivida(0.2));
		avaliacao.setScorePendencia(controladorFuzzy.getScorePendencia(0.2, megamodel.getMediaPeriodoPendencia(),megamodel.getMediaDiasAtraso()));
		
		
		double scoreGastos = controladorFuzzy.getScoreGastos(avaliacao.getScoreDivida(), avaliacao.getScorePendencia());
		double scoreCapital = controladorFuzzy.getScoreCapital(avaliacao.getScoreRenda(), avaliacao.getScoreExerceAtividade());
		
		
		double scoreCapitalAtivos=controladorFuzzy.getScoreAtivos(megamodel.getQuantidadeAutomoveis(),megamodel.getQuantidadeImoveis(), megamodel.getQuantidadeTerrenos());
		double scoreAtivoTomador=controladorFuzzy.getScoreCapitalAtivos(megamodel.getQuantidadeSalariosMinimosAtivos(), megamodel.getQuantidadeSalariosMinimosSalario());
		double scoreTomador2 = controladorFuzzy.getScoreTomador2(scoreCapitalAtivos, scoreAtivoTomador);
		
		avaliacao.setScoreAtivo(scoreTomador2);
		
		double scoreTomador1= controladorFuzzy.getScoreTomador1(scoreCapital, scoreGastos);
		double scoreTomador3= controladorFuzzy.getScoreTomador3(scoreTomador2, megamodel.getValorEscolaridade());
		
		avaliacao.setScoreTomador(controladorFuzzy.getScoreTomadorFinal(scoreTomador1, scoreTomador3));
		
		avaliacao.setValorEmprestimo(100);
		avaliacao.setScoreFinal(controladorFuzzy.getScoreTomadorFinal(avaliacao.getScoreTomador(), avaliacao.getValorEmprestimo()));
		
		System.out.println(
				
			"\nSALARIO :"+ avaliacao.getScoreExerceAtividade()+ "%"
			
			+ "\nRENDA :"+ avaliacao.getScoreRenda()+ "%"
			
			+ "\nDIVIDA :"+ avaliacao.getScoreDivida()+ "%"
			
			+ "\nPENDÊNCIA :"+ avaliacao.getScorePendencia()+ "%"
			
			+ "\n VALOR ATIVOS :"+ scoreCapitalAtivos+ "%"
			+ "\n NUMERO DE ATIVOS :"+ scoreAtivoTomador+ "%"
			+ "\n ATIVOS :"+ scoreTomador2+ "%"
			+ "\n -GASTOS:" + scoreGastos  + "%"
			+ "\n -CAPITAL " + scoreCapital+ "%"
			
			+ "\n TOMADOR SCORE 1 :"	+ scoreTomador1+ "%"
					+ "\n TOMADOR SCORE 3-que usa score ATIVOS :"	+ scoreTomador3+ "%"
			+ "\n Tomador FINAL :"	+ avaliacao.getScoreTomador()+ "%"
			
			+ "\n Final EMPRESTIMO :"	+ avaliacao.getScoreFinal()+ "%"
				
				);
		
		//avaliacao.setIdTomador(controleAcessoDAO.retornaIdControleAcesso());
		avaliacao.setIdTomador(32);
		avaliacao.setIdCredor(1);
		avaliacao.setDataAvaliação(new Date());
		
		//AvaliacaoDAO avDao = new AvaliacaoDAOImpl();
		//avDao.gravarScoreTomador(avaliacao);
			

	}


	public QuestionarioPtI getQuestionarioptIAtual() {
		return questionarioptIAtual;
	}

	public void setQuestionarioptIAtual(QuestionarioPtI questionarioptIAtual) {
		this.questionarioptIAtual = questionarioptIAtual;
	}



	public Mega getMegamodel() {
		return megamodel;
	}

	public void setMegamodel(Mega megamodel) {
		this.megamodel = megamodel;
	}

	public MegaDAO2 getMegaDAO() {
		return megaDAO;
	}

	public void setMegaDAO2(MegaDAO2 megaDAO) {
		this.megaDAO = megaDAO;
	}

	public ControleAcessoDAO getControleAcessoDAO() {
		return controleAcessoDAO;
	}

	public void setControleAcessoDAO(ControleAcessoDAO controleAcessoDAO) {
		this.controleAcessoDAO = controleAcessoDAO;
	}


}

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
import fatec.edu.mega.dao.fuzzy.MegaDAO;
import fatec.edu.mega.dao.fuzzy.MegaDAOImpl;
import fatec.edu.models.Avaliacao;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtII;
import fatec.edu.models.QuestionarioPtIII;
import fatec.edu.models.QuestionarioPtIV;
import fatec.edu.models.QuestionarioPtV;

@ManagedBean
@SessionScoped
public class ControladorFuzzyManagedBean {

	private QuestionarioPtI questionarioptIAtual;
	private QuestionarioPtII questionarioptIIAtual;
	private QuestionarioPtIII questionarioptIIIAtual;
	private QuestionarioPtIV questionarioptIVAtual;
	private QuestionarioPtV questionarioptVAtual;
	private MegaDAO megaDAO;
	private ControleAcessoDAO controleAcessoDAO;


	public ControladorFuzzyManagedBean() {
		questionarioptIAtual = new QuestionarioPtI();
		questionarioptIIAtual = new QuestionarioPtII();
		questionarioptIIIAtual = new QuestionarioPtIII();
		questionarioptIVAtual = new QuestionarioPtIV();
		questionarioptVAtual = new QuestionarioPtV();
		setControleAcessoDAO(new ControleAcessoDAOImpl());
		megaDAO = new MegaDAOImpl();
	}

	public String realizaSomaTotal() throws IOException {

		try {
			questionarioptIAtual.setId(controleAcessoDAO.retornaIdControleAcesso());

			
			questionarioptIIIAtual=megaDAO.getSomasMediasRenda(questionarioptIAtual);
			System.out.println(megaDAO.getSomasMediasRenda(questionarioptIAtual).getValor());
			
			questionarioptIVAtual=megaDAO.getSomaDivida(questionarioptIAtual);
			System.out.println(megaDAO.getSomaDivida(questionarioptIAtual).getValor());
			
			questionarioptVAtual=megaDAO.getSomasMediasPendencia(questionarioptIAtual);
			System.out.println(megaDAO.getSomasMediasPendencia(questionarioptIAtual).getValor());
			
			questionarioptIIAtual=megaDAO.getSomaExerceAtividade(questionarioptIAtual);
			System.out.println(megaDAO.getSomaExerceAtividade(questionarioptIAtual).getSalario());
			
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
		ControladorFuzzy controladorFuzzy = new ControladorFuzzy();
		System.out.println("entrou no metodo-geraavaliacao");
		
		Avaliacao avaliacao = new Avaliacao();
		System.out.println("instanciou avaliacao");
		avaliacao.setScoreExerceAtividade(controladorFuzzy.getScoreSalario(questionarioptIIAtual,
				megaDAO.getMediaMesesTrabalhados(questionarioptIAtual), 2));
		System.out.println("set score exerce:"+avaliacao.getScoreExerceAtividade());

		avaliacao.setScoreRenda(controladorFuzzy.getScoreRenda(questionarioptIIIAtual));
		System.out.println("set score renda");

		avaliacao.setScoreDivida(controladorFuzzy.getScoreDivida(questionarioptIVAtual));
		System.out.println("set score divida");

		avaliacao.setScorePendencia(controladorFuzzy.getScorePedencia(questionarioptVAtual,
				megaDAO.getMediaDiasAtraso(questionarioptIAtual)));
		System.out.println("set score pendencia");

		double scoreGastos = controladorFuzzy.getScoreGastos(avaliacao.getScoreDivida(), avaliacao.getScorePendencia());
		double scoreCapital = controladorFuzzy.getScoreCapital(avaliacao.getScoreRenda(),
				avaliacao.getScoreExerceAtividade());

		avaliacao.setScoreTomador( controladorFuzzy.getScoreTomador((controladorFuzzy.getScoreCapital(avaliacao.getScoreRenda(), avaliacao.getScoreExerceAtividade())),
				(controladorFuzzy.getScoreGastos(avaliacao.getScoreDivida(), avaliacao.getScorePendencia() ) )));
		
		avaliacao.setValorEmprestimo(100);

		avaliacao.setScoreFinal(
				controladorFuzzy.getScoreTomadorFinal(avaliacao.getScoreTomador(), avaliacao.getValorEmprestimo()));

		System.out.println(

		"\nSalario :" + avaliacao.getScoreExerceAtividade() + "%" + "\nRenda :" + avaliacao.getScoreRenda() + "%"
				+ "\nDivida :" + avaliacao.getScoreDivida() + "%" + "\nPendencia :" + avaliacao.getScorePendencia()
				+ "%" + "\nGastos:"
				+ controladorFuzzy.getScoreGastos(avaliacao.getScoreDivida(), avaliacao.getScorePendencia()) + "%"
				+ "\nCapital "
				+ controladorFuzzy.getScoreCapital(avaliacao.getScoreRenda(), avaliacao.getScoreExerceAtividade()) + "%"
				+ "\nTomador :" + avaliacao.getScoreTomador() + "%" + "\nFinal :" + avaliacao.getScoreFinal() + "%"

		);
		
		
		

		avaliacao.setIdTomador(controleAcessoDAO.retornaIdControleAcesso());
		avaliacao.setIdCredor(1);
		avaliacao.setDataAvaliação(new Date());
		
		AvaliacaoDAO avDao = new AvaliacaoDAOImpl();
		avDao.gravarScoreTomador(avaliacao);
			

	}


	public QuestionarioPtI getQuestionarioptIAtual() {
		return questionarioptIAtual;
	}

	public void setQuestionarioptIAtual(QuestionarioPtI questionarioptIAtual) {
		this.questionarioptIAtual = questionarioptIAtual;
	}

	public QuestionarioPtII getQuestionarioptIIAtual() {
		return questionarioptIIAtual;
	}

	public void setQuestionarioptIIAtual(QuestionarioPtII questionarioptIIAtual) {
		this.questionarioptIIAtual = questionarioptIIAtual;
	}

	public QuestionarioPtIII getQuestionarioptIIIAtual() {
		return questionarioptIIIAtual;
	}

	public void setQuestionarioptIIIAtual(QuestionarioPtIII questionarioptIIIAtual) {
		this.questionarioptIIIAtual = questionarioptIIIAtual;
	}

	public QuestionarioPtIV getQuestionarioptIVAtual() {
		return questionarioptIVAtual;
	}

	public void setQuestionarioptIVAtual(QuestionarioPtIV questionarioptIVAtual) {
		this.questionarioptIVAtual = questionarioptIVAtual;
	}

	public QuestionarioPtV getQuestionarioptVAtual() {
		return questionarioptVAtual;
	}

	public void setQuestionarioptVAtual(QuestionarioPtV questionarioptVAtual) {
		this.questionarioptVAtual = questionarioptVAtual;
	}

	public MegaDAO getMegaDAO() {
		return megaDAO;
	}

	public void setMegaDAO(MegaDAO megaDAO) {
		this.megaDAO = megaDAO;
	}

	public ControleAcessoDAO getControleAcessoDAO() {
		return controleAcessoDAO;
	}

	public void setControleAcessoDAO(ControleAcessoDAO controleAcessoDAO) {
		this.controleAcessoDAO = controleAcessoDAO;
	}


}

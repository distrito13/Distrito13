package fatec.edu.Resultados;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import fatec.edu.dao.implementation.crud.AvaliacaoDAOImpl;
import fatec.edu.dao.implementation.crud.EstadoDAOImpl;
import fatec.edu.dao.implementation.crud.QuestionarioPtIDAOImpl;
import fatec.edu.dao.implementation.crud.SexoDAOImpl;
import fatec.edu.dao.interfaces.crud.AvaliacaoDAO;
import fatec.edu.dao.interfaces.crud.EstadoDAO;
import fatec.edu.dao.interfaces.crud.SexoDAO;
import fatec.edu.fuzzy.ControladorFuzzy;
import fatec.edu.mega.dao.fuzzy.MegaDAO;
import fatec.edu.mega.dao.fuzzy.MegaDAOImpl;
import fatec.edu.models.Avaliacao;
import fatec.edu.models.Estado;
import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtII;
import fatec.edu.models.QuestionarioPtIII;
import fatec.edu.models.QuestionarioPtIV;
import fatec.edu.models.QuestionarioPtV;
import fatec.edu.models.Sexo;

@ManagedBean
@SessionScoped
public class CFRealizaAnaliseManagedBean {

	private QuestionarioPtI questionarioptIAtual;
	private QuestionarioPtII questionarioptIIAtual;
	private QuestionarioPtIII questionarioptIIIAtual;
	private QuestionarioPtIV questionarioptIVAtual;
	private QuestionarioPtV questionarioptVAtual;
	private Avaliacao avaliacaoAtual;
	private MegaDAO megaDAO;
	private List<QuestionarioPtI> tomadores;
	private QuestionarioPtIDAOImpl TomadorDAO;
	

	public CFRealizaAnaliseManagedBean() {
		questionarioptIAtual = new QuestionarioPtI();
		questionarioptIIAtual = new QuestionarioPtII();
		questionarioptIIIAtual = new QuestionarioPtIII();
		questionarioptIVAtual = new QuestionarioPtIV();
		questionarioptVAtual = new QuestionarioPtV();
		
		avaliacaoAtual = new Avaliacao();
		megaDAO = new MegaDAOImpl();
		TomadorDAO = new QuestionarioPtIDAOImpl();
		
		
		

			try {
				setTomadores(TomadorDAO.pesquisar());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	private void setTomadores(List<QuestionarioPtI> tomadores) {
		this.tomadores = tomadores;
	}
	public List<QuestionarioPtI> getTomadores() {
		return tomadores;
	}
	
	

	public QuestionarioPtIDAOImpl getTomadorDAO() {
		return TomadorDAO;
	}

	public void setTomadorDAO(QuestionarioPtIDAOImpl tomadorDAO) {
		TomadorDAO = tomadorDAO;
	}

	public String realizaSomaTotal() throws IOException {
		

		try {

			
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

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("passou");
		return "ok";
	}

	public Avaliacao getAvaliacaoAtual() {
		return avaliacaoAtual;
	}

	public void setAvaliacaoAtual(Avaliacao avaliacaoAtual) {
		this.avaliacaoAtual = avaliacaoAtual;
	}

	public void geraAvaliacao() throws SQLException, IOException {
		ControladorFuzzy controladorFuzzy = new ControladorFuzzy();
		System.out.println("entrou no metodo-geraavaliacao");
		
		
		System.out.println("instanciou avaliacao");
		avaliacaoAtual.setScoreExerceAtividade(controladorFuzzy.getScoreSalario(questionarioptIIAtual,
				megaDAO.getMediaMesesTrabalhados(questionarioptIAtual), 2));
		System.out.println("set score exerce:"+avaliacaoAtual.getScoreExerceAtividade());

		avaliacaoAtual.setScoreRenda(controladorFuzzy.getScoreRenda(questionarioptIIIAtual));
		System.out.println("set score renda");

		avaliacaoAtual.setScoreDivida(controladorFuzzy.getScoreDivida(questionarioptIVAtual));
		System.out.println("set score divida");

		avaliacaoAtual.setScorePendencia(controladorFuzzy.getScorePedencia(questionarioptVAtual,
				megaDAO.getMediaDiasAtraso(questionarioptIAtual)));
		System.out.println("set score pendencia");

		double scoreGastos = controladorFuzzy.getScoreGastos(avaliacaoAtual.getScoreDivida(), avaliacaoAtual.getScorePendencia());
		double scoreCapital = controladorFuzzy.getScoreCapital(avaliacaoAtual.getScoreRenda(),
				avaliacaoAtual.getScoreExerceAtividade());

		avaliacaoAtual.setScoreTomador(
				controladorFuzzy.getScoreTomador(avaliacaoAtual.getScoreRenda(), avaliacaoAtual.getScoreExerceAtividade()));

		//avaliacaoAtual.setValorEmprestimo(avaliacaoAtual);

		avaliacaoAtual.setScoreFinal(
				controladorFuzzy.getScoreTomadorFinal(avaliacaoAtual.getScoreTomador(), avaliacaoAtual.getValorEmprestimo()));

		System.out.println(

		"\nSalario :" + avaliacaoAtual.getScoreExerceAtividade() + "%" + "\nRenda :" + avaliacaoAtual.getScoreRenda() + "%"
				+ "\nDivida :" + avaliacaoAtual.getScoreDivida() + "%" + "\nPendencia :" + avaliacaoAtual.getScorePendencia()
				+ "%" + "\nGastos:"
				+ controladorFuzzy.getScoreGastos(avaliacaoAtual.getScoreDivida(), avaliacaoAtual.getScorePendencia()) + "%"
				+ "\nCapital "
				+ controladorFuzzy.getScoreCapital(avaliacaoAtual.getScoreRenda(), avaliacaoAtual.getScoreExerceAtividade()) + "%"
				+ "\nTomador :" + avaliacaoAtual.getScoreTomador() + "%" + "\nFinal :" + avaliacaoAtual.getScoreFinal() + "%"

		);

		//avaliacao.setIdTomador(1);
		avaliacaoAtual.setIdCredor(1);
		avaliacaoAtual.setDataAvaliação(new Date());
		
		System.out.println("v emprestimo"+avaliacaoAtual.getValorEmprestimo());
		
	/*	AvaliacaoDAO avDao = new AvaliacaoDAOImpl();
		avDao.gravarScoreTomador(avaliacaoAtual);*/
			

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


}

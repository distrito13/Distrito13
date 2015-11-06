package fatec.edu.GerenciadorResultados;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fatec.edu.models.Avaliacao;

@ManagedBean
@SessionScoped
public class GerenciaResultadosManagedBean {

	private Avaliacao avaliacaoAtual;
	private GerenciaResultadosDAO gerenciaResultadosDAO;
	private List<Avaliacao> resultados;
	private double scoreFinal;
	private double scoreTomador;
	private double scoreExercAtividade;
	private double scoreRenda;
	private double scoreDivida;
	private double scorePendencia;

	public GerenciaResultadosManagedBean() {
		avaliacaoAtual = new Avaliacao();
		gerenciaResultadosDAO = new GerenciaResultadosDAOIMpl();
		try {
			setResultados(gerenciaResultadosDAO.pegarTodosResultados());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void estabeleceComparativo() throws SQLException, IOException {

		if (gerenciaResultadosDAO.pegarScoreFinal() < 30) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Resultado_MuitoRuim.xhtml");
		} else if (gerenciaResultadosDAO.pegarScoreFinal() > 30 && gerenciaResultadosDAO.pegarScoreFinal() < 50) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Ruim.xhtml");
		} else if (gerenciaResultadosDAO.pegarScoreFinal() > 50 && gerenciaResultadosDAO.pegarScoreFinal() < 70) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Regular.xhtml");
		} else if (gerenciaResultadosDAO.pegarScoreFinal() > 70 && gerenciaResultadosDAO.pegarScoreFinal() < 80) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Bom.xhtml");
		} else if (gerenciaResultadosDAO.pegarScoreFinal() > 80 && gerenciaResultadosDAO.pegarScoreFinal() < 101) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("MuitoBom.xhtml");
		}
	}

	public Avaliacao getAvaliacaoAtual() {
		return avaliacaoAtual;
	}

	public void setAvaliacaoAtual(Avaliacao avaliacaoAtual) {
		this.avaliacaoAtual = avaliacaoAtual;
	}

	public GerenciaResultadosDAO getGerenciaResultadosDAO() {
		return gerenciaResultadosDAO;
	}

	public void setGerenciaResultadosDAO(GerenciaResultadosDAO gerenciaResultadosDAO) {
		this.gerenciaResultadosDAO = gerenciaResultadosDAO;
	}

	public List<Avaliacao> getResultados() {
		return resultados;
	}

	public void setResultados(List<Avaliacao> resultados) {
		this.resultados = resultados;
	}

	public double getScoreFinal() throws SQLException {
		return gerenciaResultadosDAO.pegarScoreFinal();
	}

	public void setScoreFinal(double scoreFinal) throws SQLException {
		this.scoreFinal = scoreFinal;
	}

	public double getScoreTomador() throws SQLException {
		return gerenciaResultadosDAO.pegarScoreTomador();
	}

	public void setScoreTomador(double scoreTomador) {
		this.scoreTomador = scoreTomador;
	}

	public double getScoreExercAtividade() throws SQLException {
		return gerenciaResultadosDAO.pegarScoreExercAtividade();
	}

	public void setScoreExercAtividade(double scoreExercAtividade) {
		this.scoreExercAtividade = scoreExercAtividade;
	}

	public double getScoreRenda() throws SQLException {
		return gerenciaResultadosDAO.pegarScoreRenda();
	}

	public void setScoreRenda(double scoreRenda) {
		this.scoreRenda = scoreRenda;
	}

	public double getScoreDivida() throws SQLException {
		return gerenciaResultadosDAO.pegarScoreDivida();
	}

	public void setScoreDivida(double scoreDivida) {
		this.scoreDivida = scoreDivida;
	}

	public double getScorePendencia() throws SQLException {
		return gerenciaResultadosDAO.pegarScorePendencia();
	}

	public void setScorePendencia(double scorePendencia) {
		this.scorePendencia = scorePendencia;
	}

	
	
}

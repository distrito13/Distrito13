package fatec.edu.mb;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.PieChartModel;

import fatec.edu.dao.implementation.crud.AvaliacaoGraficoDAOImpl;
import fatec.edu.dao.interfaces.crud.AvaliacaoGraficosDAO;
import fatec.edu.models.Avaliacao;

@ManagedBean
@SessionScoped
public class ResultadoManagedBean implements Serializable{

	private static final long serialVersionUID = -1901076222129835811L;
	
	private PieChartModel graficoModel;

	@PostConstruct
    public void init() {
		listar();
    }
	
	
	public PieChartModel getGraficoModel() {
		return graficoModel;
	}

	public void setGraficoModel(PieChartModel graficoModel) {
		this.graficoModel = graficoModel;
	}


	public void listar(){
		AvaliacaoGraficosDAO agDAO;
		List<Avaliacao> lista;
		
		try {
			agDAO = new AvaliacaoGraficoDAOImpl();
			lista = agDAO.retornaScores();
			graficar(lista);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void graficar(List<Avaliacao> lista){
		graficoModel = new PieChartModel();
		
		for (Avaliacao avaliacaoL: lista){
			graficoModel.set("Renda",avaliacaoL.getScoreRenda());
			graficoModel.set("Tomador",avaliacaoL.getScoreTomador());
			graficoModel.set("Dívida",avaliacaoL.getScoreDivida());
			graficoModel.set("Atividade Profissional",avaliacaoL.getScoreExerceAtividade());
			graficoModel.set("Pendência",avaliacaoL.getScorePendencia());

		}
		
		
		graficoModel.setTitle("Gráfico dos Scores");
		graficoModel.setLegendPosition("w");
	}

}

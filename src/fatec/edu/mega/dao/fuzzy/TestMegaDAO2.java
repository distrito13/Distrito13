package fatec.edu.mega.dao.fuzzy;

import java.sql.SQLException;

import fatec.edu.models.QuestionarioPtI;

public class TestMegaDAO2 {

	public TestMegaDAO2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		MegaDAO2 mega = new MegaDAOImpl2();
		QuestionarioPtI tomador = new QuestionarioPtI();
		int idtomador = 32;
		tomador.setId(idtomador);
		
		Mega megamodel=new Mega();

		/*megamodel.setIdTomador(mega.pegaDadosTomador(tomador).getIdTomador());
		megamodel.setValorEscolaridade(mega.pegaDadosTomador(tomador).getValorEscolaridade());
		
		megamodel.setQuantidadeSalariosMinimosSalario(mega.pegaDadosExerceAtividade(tomador).getQuantidadeSalariosMinimosSalario());
		megamodel.setMediaMesesTrabalhados(mega.pegaDadosExerceAtividade(tomador).getMediaMesesTrabalhados());
		megamodel.setValorEstabilidade(mega.pegaDadosExerceAtividade(tomador).getValorEstabilidade());
		
		megamodel.setQuantidadeSalariosMinimosRenda(mega.pegaDadosRenda(tomador).getQuantidadeSalariosMinimosRenda());
		megamodel.setMediaPeriodoRenda(mega.pegaDadosRenda(tomador).getMediaPeriodoRenda());
		
		megamodel.setQuantidadeSalariosMinimosDivida(mega.pegaDadosDivida(tomador).getQuantidadeSalariosMinimosDivida());
		
		megamodel.setQuantidadeSalariosMinimosPendencia(mega.pegaDadosPendencia(tomador).getQuantidadeSalariosMinimosPendencia());
		megamodel.setMediaPeriodoPendencia(mega.pegaDadosPendencia(tomador).getMediaPeriodoPendencia());
		megamodel.setMediaDiasAtraso(mega.pegaDadosPendencia(tomador).getMediaDiasAtraso());
		
		megamodel.setQuantidadeSalariosMinimosAtivos(mega.pegaDadosAtivo(tomador).getQuantidadeSalariosMinimosAtivos());
		megamodel.setQuantidadeAutomoveis(mega.pegaDadosAtivo(tomador).getQuantidadeAutomoveis());
		megamodel.setQuantidadeImoveis(mega.pegaDadosAtivo(tomador).getQuantidadeImoveis());
		megamodel.setQuantidadeTerrenos(mega.pegaDadosAtivo(tomador).getQuantidadeTerrenos());*/
		//TOMADOR
		
		try {
			megamodel.setIdTomador(mega.pegaDadosTomador(tomador).getIdTomador());
			megamodel.setValorEscolaridade(mega.pegaDadosTomador(tomador).getValorEscolaridade());
			System.out.println("TOMADOR");
			System.out.println("id tomador: "+megamodel.getIdTomador());
			System.out.println("valor escolaridade: "+megamodel.getValorEscolaridade());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//-EXERCE ATIVIDADE
		
		try {
			megamodel.setQuantidadeSalariosMinimosSalario(mega.pegaDadosExerceAtividade(tomador).getQuantidadeSalariosMinimosSalario());
			megamodel.setMediaMesesTrabalhados(mega.pegaDadosExerceAtividade(tomador).getMediaMesesTrabalhados());
			megamodel.setValorEstabilidade(mega.pegaDadosExerceAtividade(tomador).getValorEstabilidade());
			System.out.println("PROFISSIONAIS");
			System.out.println("Quantos salários minimos ganha(salario): "+megamodel.getQuantidadeSalariosMinimosSalario());
			System.out.println("Media meses trabalhados: "+megamodel.getMediaMesesTrabalhados());
			System.out.println("valor estabilidade: "+megamodel.getValorEstabilidade());
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//--RENDAS
		
		try {
			megamodel.setQuantidadeSalariosMinimosRenda(mega.pegaDadosRenda(tomador).getQuantidadeSalariosMinimosRenda());
			megamodel.setMediaPeriodoRenda(mega.pegaDadosRenda(tomador).getMediaPeriodoRenda());
			System.out.println("RENDAS");
			System.out.println("Renda representa quantos salarios minimos: "+megamodel.getQuantidadeSalariosMinimosRenda());
			System.out.println("media periodo renda: "+megamodel.getMediaPeriodoRenda());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		//--DIVIDAS
			try {
				megamodel.setQuantidadeSalariosMinimosDivida(mega.pegaDadosDivida(tomador).getQuantidadeSalariosMinimosDivida());
				System.out.println("DIVIDAS");
				System.out.println("Divida representa quantos salarios minimos: "+megamodel.getQuantidadeSalariosMinimosDivida());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		//--PENDENCIAS
			try {
				megamodel.setQuantidadeSalariosMinimosPendencia(mega.pegaDadosPendencia(tomador).getQuantidadeSalariosMinimosPendencia());
				megamodel.setMediaPeriodoPendencia(mega.pegaDadosPendencia(tomador).getMediaPeriodoPendencia());
				megamodel.setMediaDiasAtraso(mega.pegaDadosPendencia(tomador).getMediaDiasAtraso());
				System.out.println("PENDENCIAS");
				System.out.println("Pendencia representa quantos salarios minimos: "+megamodel.getQuantidadeSalariosMinimosPendencia());
				System.out.println("media periodo pendencia: "+megamodel.getMediaPeriodoPendencia());
				System.out.println("media dias atraso: "+megamodel.getMediaDiasAtraso());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		//--ATIVOS
		try {
			megamodel.setQuantidadeSalariosMinimosAtivos(mega.pegaDadosAtivo(tomador).getQuantidadeSalariosMinimosAtivos());
			megamodel.setQuantidadeAutomoveis(mega.pegaDadosAtivo(tomador).getQuantidadeAutomoveis());
			megamodel.setQuantidadeImoveis(mega.pegaDadosAtivo(tomador).getQuantidadeImoveis());
			megamodel.setQuantidadeTerrenos(mega.pegaDadosAtivo(tomador).getQuantidadeTerrenos());
			System.out.println("ATIVOS");
			System.out.println("Ativos representa quantos salarios minimos: "+megamodel.getQuantidadeSalariosMinimosAtivos());
			System.out.println("Quantidade automóveis: "+megamodel.getQuantidadeAutomoveis());
			System.out.println("Quantidade imóveis: "+megamodel.getQuantidadeImoveis());
			System.out.println("Quantidade terremos: "+megamodel.getQuantidadeTerrenos());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		

	}
	
}

package fatec.edu.mega.dao.fuzzy;

import java.sql.SQLException;
import java.util.List;

import fatec.edu.models.QuestionarioPtI;
import fatec.edu.models.QuestionarioPtII;
import fatec.edu.models.QuestionarioPtIII;
import fatec.edu.models.QuestionarioPtIV;
import fatec.edu.models.QuestionarioPtV;

public class TestMegaDAO {

	public TestMegaDAO() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		MegaDAO mega = new MegaDAOImpl();
		QuestionarioPtI tomador = new QuestionarioPtI();
		int idtomador = 1;
		tomador.setId(idtomador);

		// tomador
		try {

			tomador = mega.consultaTomador(tomador);
			System.out.println("-id:" + tomador.getId() );
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//-EXERCE ATIVIDADE
		QuestionarioPtII somaSalario = new QuestionarioPtII();
		try {
			somaSalario.setSalario(mega.getSomaExerceAtividade(tomador).getSalario());
			System.out.println("Soma Salário:"+somaSalario.getSalario());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			double mediaMesesTrabalhados = mega.getMediaMesesTrabalhados(tomador);
			System.out.println("Media Meses Trabalhados:"+mediaMesesTrabalhados);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//--RENDAS
				QuestionarioPtIII somasMediasRenda = new QuestionarioPtIII();
				try {
					somasMediasRenda.setValor(mega.getSomasMediasRenda(tomador).getValor());
					somasMediasRenda.setPeriodo(mega.getSomasMediasRenda(tomador).getPeriodo());
					System.out.println("Soma Renda:" +somasMediasRenda.getValor()+ "-Media periodo:"+somasMediasRenda.getPeriodo());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
			//--DIVIDAS
				QuestionarioPtIV somaDivida = new QuestionarioPtIV();
				try {
					somaDivida.setValor(mega.getSomaDivida(tomador).getValor());
					System.out.println("Soma Dívida:"+somaDivida.getValor());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			//--PENDENCIAS
				QuestionarioPtV somasMediasPendencia = new QuestionarioPtV();
				try {
					somasMediasPendencia.setValor(mega.getSomasMediasPendencia(tomador).getValor());
					somasMediasPendencia.setPeriodo(mega.getSomasMediasPendencia(tomador).getPeriodo());
					System.out.println("Soma Pendência:" +somasMediasPendencia.getValor()+ "-Media periodo:"+somasMediasPendencia.getPeriodo());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					int mediaDiasAtraso = mega.getMediaDiasAtraso(tomador);
					System.out.println("Media Dias Atraso:"+mediaDiasAtraso);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
}

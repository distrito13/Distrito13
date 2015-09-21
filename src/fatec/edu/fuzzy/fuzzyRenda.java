package fatec.edu.fuzzy;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class fuzzyRenda {
	
	public static void main(String[] args) {
		File dir1 = new File ("");  
		StringBuffer sb = new StringBuffer();
		try {
			sb.append(dir1.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		sb.append("\\src\\default.fcl");
		
		
		
		FIS fis = FIS.load(sb.toString(), true);
		

		if (fis == null) {

			
			JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo .fcl");
		}
		
		
		FunctionBlock qi = fis.getFunctionBlock("SalarioTomador");

		for ( int i = 0 ; i<=200 ; i++){
		qi.setVariable("salario", i*50);
    	qi.setVariable("estabilidade", 1);


		qi.evaluate();

		 System.out.println((i*50)   +" - "+ "autonomo " +"- "+qi.getVariable("scorePorcentagem").getValue());
		
			qi.setVariable("salario", i*50);
	    	qi.setVariable("estabilidade", 2);
	    	
	    	qi.evaluate();
	    	 System.out.println((i*50)   +" - "+"privado" +"- "+qi.getVariable("scorePorcentagem").getValue());
	}
		for ( int i = 0 ; i<=200 ; i++){

			qi.setVariable("salario", i*50);
	    	qi.setVariable("estabilidade", 3);


		qi.evaluate();

		 System.out.println((i*50)+" - "+"publico"+"-"+qi.getVariable("scorePorcentagem").getValue());
	 	
		}
		
	}
}

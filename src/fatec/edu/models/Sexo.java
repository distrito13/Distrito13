package fatec.edu.models;

import java.io.Serializable;

public class Sexo implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idSexo;
	private String sexo;

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setIdSexo(int idSexo) {
		this.idSexo = idSexo;
	}

	public int getIdSexo() {
		return idSexo;
	}
	
	@Override
	public String toString(){
		return getSexo();
	}
}

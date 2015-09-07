package fatec.edu.models;


import fatec.edu.mb.EntityGenerica;



public class Sexo implements EntityGenerica{

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
	public int getId() {
		return idSexo;
	}

	@Override
	public void setId(int id) {
		this.idSexo = id;
		
	}
	
	public String toString(){
		return getSexo();
	}
}

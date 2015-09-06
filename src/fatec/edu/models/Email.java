package fatec.edu.models;

public class Email {

	private int idEmail;
	private String email;
	private TipoEmail tipoEmail;
	private Tomador tomador;

	public void setTomador(Tomador tomador) {
		this.tomador = tomador;
	}

	public Tomador getTomador() {
		return tomador;
	}

	public void setTipoEmail(TipoEmail tipoEmail) {
		this.tipoEmail = tipoEmail;
	}

	public TipoEmail getTipoEmail() {
		return tipoEmail;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setIdEmail(int idEmail) {
		this.idEmail = idEmail;
	}

	public int getIdEmail() {
		return idEmail;
	}
}

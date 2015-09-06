package fatec.edu.models;

public class Telefones {

	private int idTelefone;
	private String numero;
	private TipoTelefone tipoTelefone;
	private Tomador tomador;

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTomador(Tomador tomador) {
		this.tomador = tomador;
	}

	public Tomador getTomador() {
		return tomador;
	}
}

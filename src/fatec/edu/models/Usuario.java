package fatec.edu.models;

public class Usuario {

	private int idUsuario;
	private String nome;
	private String usuario;
	private String senha;
	private String permissao;
	private Credor credor;

	public void setCredor(Credor credor) {
		this.credor = credor;
	}

	public Credor getCredor() {
		return credor;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
}

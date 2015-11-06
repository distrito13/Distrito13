package fatec.edu.models;

public class Credor_provavelmentevaisair {

	private int idCredor;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String telefone;
	private String email;
	private Estado estado;
	private Cidade_vaisair cidade;

	public void setCidade(Cidade_vaisair cidade) {
		this.cidade = cidade;
	}

	public Cidade_vaisair getCidade() {
		return cidade;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCep() {
		return cep;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setIdCredor(int idCredor) {
		this.idCredor = idCredor;
	}

	public int getIdCredor() {
		return idCredor;
	}
	
	public String toString(){
		return getNomeFantasia();
	}

}

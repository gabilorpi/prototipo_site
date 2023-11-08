package modelo;

public class Cliente {
	private int idCliente;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String cpf;
    private String rua;
    private String cep;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
	
    public Cliente() {
	}

	public Cliente(int idCliente, String nome, String email, String senha, String telefone, String cpf, String rua,
			String cep, int numero, String bairro, String cidade, String estado) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.cpf = cpf;
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Cliente(String nome, String email, String senha, String telefone, String cpf, String rua, String cep,
			int numero, String bairro, String cidade, String estado) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.cpf = cpf;
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", email=" + email + ", senha=" + senha
				+ ", telefone=" + telefone + ", cpf=" + cpf + ", rua=" + rua + ", cep=" + cep + ", numero=" + numero
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + "]";
	}
  
  
}

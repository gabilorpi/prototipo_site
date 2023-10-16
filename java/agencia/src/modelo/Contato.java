package modelo;

public class Contato {
	private int idContato;
    private String nome;
    private String email;
    private String telefone;
    private String mensagen;
   
    
	public Contato() {
	}

	public Contato(int idContato, String nome, String email, String telefone, String mensagen) {
		this.idContato = idContato;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.mensagen = mensagen;
		
	}

	public Contato(String nome, String email, String telefone, String mensagen) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.mensagen = mensagen;
		
	}

	public int getIdContato() {
		return idContato;
	}

	public void setIdContato(int idContato) {
		this.idContato = idContato;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMensagem() {
		return mensagen;
	}

	public void setMensagem(String mensagen) {
		this.mensagen = mensagen;
	}

	

	@Override
	public String toString() {
		return "Contato [idContato=" + idContato + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
				+ ", mensagen=" + mensagen +  "]";
	}
    
  
    
    
    
}

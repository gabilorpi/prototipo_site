package modelo;

public class Agencia {

	 private int id_Agencia;
	    private String nome_Agencia;
	    private String cep;
	    private String rua;
	    private String bairro;
	    private String telefone;
	   
	    
		public Agencia() {
		}

		public Agencia(int id_Agencia, String nome_Agencia, String cep, String rua, String bairro, String telefone)
		{
			this.id_Agencia = id_Agencia;
			this.nome_Agencia = nome_Agencia;
			this.cep = cep;
			this.rua = rua;
			this.bairro = bairro;
			this.telefone = telefone;
			
		}

		public Agencia(String nome_Agencia, String cep, String rua, String bairro, String telefone)
		{
			this.nome_Agencia = nome_Agencia;
			this.cep = cep;
			this.rua = rua;
			this.bairro = bairro;
			this.telefone = telefone;
			
		}

		public int getId_Agencia() {
			return id_Agencia;
		}

		public void setId_Agencia(int id_Agencia) {
			this.id_Agencia = id_Agencia;
		}

		public String getNome_Agencia() {
			return nome_Agencia;
		}

		public void setNome_Agencia(String nome_Agencia) {
			this.nome_Agencia = nome_Agencia;
		}

		public String getCep() {
			return cep;
		}

		public void setCep(String cep) {
			this.cep = cep;
		}

		public String getRua() {
			return rua;
		}

		public void setRua(String rua) {
			this.rua = rua;
		}

		public String getBairro() {
			return bairro;
		}

		public void setBairro(String bairro) {
			this.bairro = bairro;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		

		@Override
		public String toString() {
			return "Agencia [id_Agencia=" + id_Agencia + ", nome_Agencia=" + nome_Agencia + ", cep=" + cep + ", rua=" + rua
					+ ", bairro=" + bairro + ", telefone=" + telefone +  "]";
		}
	    
	    
}

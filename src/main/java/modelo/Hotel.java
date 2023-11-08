package modelo;

public class Hotel {

	private int idHotel;
    private double precoPorNoite;
    private String categorias;
    private String nomeHotel;
    private String cep;
    private String rua;
    private String bairro;
    private String telefone;
    
    public Hotel() {
	}

	public Hotel(int idHotel, double precoPorNoite, String categorias, String nomeHotel, String cep, String rua,
			String bairro, String telefone) {
		this.idHotel = idHotel;
		this.precoPorNoite = precoPorNoite;
		this.categorias = categorias;
		this.nomeHotel = nomeHotel;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.telefone = telefone;
	}

	public Hotel(double precoPorNoite, String categorias, String nomeHotel, String cep, String rua, String bairro,
			String telefone) {
		this.precoPorNoite = precoPorNoite;
		this.categorias = categorias;
		this.nomeHotel = nomeHotel;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.telefone = telefone;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public double getPrecoPorNoite() {
		return precoPorNoite;
	}

	public void setPrecoPorNoite(double precoPorNoite) {
		this.precoPorNoite = precoPorNoite;
	}

	public String getCategorias() {
		return categorias;
	}

	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}

	public String getNomeHotel() {
		return nomeHotel;
	}

	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
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
		return "Hotel [idHotel=" + idHotel + ", precoPorNoite=" + precoPorNoite + ", categorias=" + categorias
				+ ", nomeHotel=" + nomeHotel + ", cep=" + cep + ", rua=" + rua + ", bairro=" + bairro + ", telefone="
				+ telefone + "]";
	}
	
    
    
	
}

package modelo;

public class Voo {

	private int idVoo;
    private String horaDecolagem;
    private String dataDecolagem;
    private String horaAterrissagem;
    private String dataAterrissagem;
    private String origem;
    private String destino;
    private double preco;
	
    public Voo() {
	}

	public Voo(int idVoo, String horaDecolagem, String dataDecolagem, String horaAterrissagem, String dataAterrissagem,
			String origem, String destino, double preco) {
		this.idVoo = idVoo;
		this.horaDecolagem = horaDecolagem;
		this.dataDecolagem = dataDecolagem;
		this.horaAterrissagem = horaAterrissagem;
		this.dataAterrissagem = dataAterrissagem;
		this.origem = origem;
		this.destino = destino;
		this.preco = preco;
	}

	public Voo(String horaDecolagem, String dataDecolagem, String horaAterrissagem, String dataAterrissagem,
			String origem, String destino, double preco) {
		this.horaDecolagem = horaDecolagem;
		this.dataDecolagem = dataDecolagem;
		this.horaAterrissagem = horaAterrissagem;
		this.dataAterrissagem = dataAterrissagem;
		this.origem = origem;
		this.destino = destino;
		this.preco = preco;
	}

	public int getIdVoo() {
		return idVoo;
	}

	public void setIdVoo(int idVoo) {
		this.idVoo = idVoo;
	}

	public String getHoraDecolagem() {
		return horaDecolagem;
	}

	public void setHoraDecolagem(String horaDecolagem) {
		this.horaDecolagem = horaDecolagem;
	}

	public String getDataDecolagem() {
		return dataDecolagem;
	}

	public void setDataDecolagem(String dataDecolagem) {
		this.dataDecolagem = dataDecolagem;
	}

	public String getHoraAterrissagem() {
		return horaAterrissagem;
	}

	public void setHoraAterrissagem(String horaAterrissagem) {
		this.horaAterrissagem = horaAterrissagem;
	}

	public String getDataAterrissagem() {
		return dataAterrissagem;
	}

	public void setDataAterrissagem(String dataAterrissagem) {
		this.dataAterrissagem = dataAterrissagem;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Voo [idVoo=" + idVoo + ", horaDecolagem=" + horaDecolagem + ", dataDecolagem=" + dataDecolagem
				+ ", horaAterrissagem=" + horaAterrissagem + ", dataAterrissagem=" + dataAterrissagem + ", origem="
				+ origem + ", destino=" + destino + ", preco=" + preco + "]";
	}
    
    
}

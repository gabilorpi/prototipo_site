package modelo;

public class Passagens {
	
	  private int idPassagem;
	    private int idVoo;
	    private int fkClienteIdCliente;
	    private int fkVooIdVoo;
    
	public Passagens() {
	}

	public Passagens(int idPassagem, int idVoo, int fkClienteIdCliente, int fkVooIdVoo) {
        this.idPassagem = idPassagem;
        this.idVoo = idVoo;
        this.fkClienteIdCliente = fkClienteIdCliente;
        this.fkVooIdVoo = fkVooIdVoo;
    }

    public int getIdPassagem() {
        return idPassagem;
    }

    public void setIdPassagem(int idPassagem) {
        this.idPassagem = idPassagem;
    }

    public int getIdVoo() {
        return idVoo;
    }

    public void setIdVoo(int idVoo) {
        this.idVoo = idVoo;
    }

    public int getFkClienteIdCliente() {
        return fkClienteIdCliente;
    }

    public void setFkClienteIdCliente(int fkClienteIdCliente) {
        this.fkClienteIdCliente = fkClienteIdCliente;
    }

    public int getFkVooIdVoo() {
        return fkVooIdVoo;
    }

    public void setFkVooIdVoo(int fkVooIdVoo) {
        this.fkVooIdVoo = fkVooIdVoo;
    }

    @Override
    public String toString() {
        return "Passagens [idPassagem=" + idPassagem + ", idVoo=" + idVoo + ", fkClienteIdCliente=" + fkClienteIdCliente
                + ", fkVooIdVoo=" + fkVooIdVoo + "]";
    }
}
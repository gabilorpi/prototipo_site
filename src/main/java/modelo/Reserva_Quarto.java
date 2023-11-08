package modelo;

public class Reserva_Quarto {

	 private int idReserva;
	    private int quarto;
	    private String dataCheckOut;
	    private String dataCheckIn;
	   
		
	    public Reserva_Quarto() {
		}

		public Reserva_Quarto(int idReserva, int quarto, String dataCheckOut, String dataCheckIn) {
			this.idReserva = idReserva;
			this.quarto = quarto;
			this.dataCheckOut = dataCheckOut;
			this.dataCheckIn = dataCheckIn;
	
		}

		public Reserva_Quarto(int quarto, String dataCheckOut, String dataCheckIn) {
			this.quarto = quarto;
			this.dataCheckOut = dataCheckOut;
			this.dataCheckIn = dataCheckIn;
			
		}

		public int getIdReserva() {
			return idReserva;
		}

		public void setIdReserva(int idReserva) {
			this.idReserva = idReserva;
		}

		public int getQuarto() {
			return quarto;
		}

		public void setQuarto(int quarto) {
			this.quarto = quarto;
		}

		public String getDataCheckOut() {
			return dataCheckOut;
		}

		public void setDataCheckOut(String dataCheckOut) {
			this.dataCheckOut = dataCheckOut;
		}

		public String getDataCheckIn() {
			return dataCheckIn;
		}

		public void setDataCheckIn(String dataCheckIn) {
			this.dataCheckIn = dataCheckIn;
		}

		
		@Override
		public String toString() {
			return "Reserva_Quarto [idReserva=" + idReserva + ", quarto=" + quarto + ", dataCheckOut=" + dataCheckOut
					+ ", dataCheckIn=" + dataCheckIn +  "]";
		}
	    
	    
}

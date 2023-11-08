package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Reserva_Quarto;


public class Reserva_QuartoDao {

	//Create
	public void Create(Reserva_Quarto reserva_Quarto) {
		
		String Sql = "insert into reserva_Quarto (quarto, data_check_out, data_check_in) values (?,?,?)";

		
		Connection conn = null;
		PreparedStatement pstm =null;
		
		try {
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(Sql);
			
			pstm.setInt(1, reserva_Quarto.getQuarto());
			pstm.setString(2, reserva_Quarto.getDataCheckOut());
			pstm.setString(3, reserva_Quarto.getDataCheckIn());
			
			
			
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

	//Read
	public List<Reserva_Quarto>read(){
		List<Reserva_Quarto>reserva_Quartos= new ArrayList<Reserva_Quarto>();
	
		String sql = "select * from reserva_Quarto";
				
		Connection conn = null;
		PreparedStatement pstm =null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				  Reserva_Quarto reserva_Quarto = new Reserva_Quarto();
				
				reserva_Quarto.setQuarto(rset.getInt("quarto"));
				reserva_Quarto.setDataCheckOut(rset.getString("data_check_out"));
				reserva_Quarto.setDataCheckIn(rset.getString("data_check_in"));
				
				
				 reserva_Quartos.add(reserva_Quarto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		

		
	return reserva_Quartos;

	}

	//Update
	
	public void Update(Reserva_Quarto reserva_Quarto) {
		
		String sql ="update reserva_Quarto set quarto = ?, data_check_out = ?, data_check_in = ? where Id_reserva = ?";;
		Connection conn = null;
		PreparedStatement pstm =null;
	
		
		try {	
		
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
				
			pstm.setInt(1, reserva_Quarto.getQuarto());
			pstm.setString(2, reserva_Quarto.getDataCheckOut());
			pstm.setString(3, reserva_Quarto.getDataCheckIn());
			pstm.setInt(4, reserva_Quarto.getIdReserva());
			pstm.execute();
		
			
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	}
	
	//Delete
	public void delete(int id) {
		String sql = "DELETE FROM reserva_Quarto WHERE Id_reserva = ?";
		
		Connection conn = null;
		PreparedStatement pstm =null;
	
		
		try {	
			
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	}
	
	//readById
	public Reserva_Quarto readById(int id) {
		Reserva_Quarto reserva_Quarto = new Reserva_Quarto();
		String sql = "select * from reserva_Quarto WHERE id_reserva = ?";
		
		Connection conn = null;
		PreparedStatement pstm =null;
		ResultSet rset = null;
		
		try {	
			
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			reserva_Quarto.setIdReserva(rset.getInt("id_reserva"));
			reserva_Quarto.setQuarto(rset.getInt("quarto"));
			reserva_Quarto.setDataCheckOut(rset.getString("data_check_out"));
			reserva_Quarto.setDataCheckIn(rset.getString("data_check_in"));
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		return reserva_Quarto;
}
}

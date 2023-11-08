package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Hotel;

public class HotelDao {


	//Create
	public void Create(Hotel hotel) {
		
		String Sql = "INSERT INTO Hoteis(id_hotel, preco_noite, categorias, nomes_hoteis, cep, rua, Bairro, telefone) values (?,?,?,?,?,?,?,?)";


		
		Connection conn = null;
		PreparedStatement pstm =null;
		
		try {
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(Sql);
			
			pstm.setInt(1, hotel.getIdHotel());
			pstm.setDouble(2, hotel.getPrecoPorNoite());
			pstm.setString(3, hotel.getCategorias());
			pstm.setString(4, hotel.getNomeHotel());
			pstm.setString(5, hotel.getCep());
			pstm.setString(6, hotel.getRua());
			pstm.setString(7, hotel.getBairro());
			pstm.setString(8, hotel.getTelefone());
		
			
			
	
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
	public List<Hotel>read(){
		List<Hotel>hotels= new ArrayList<Hotel>();
	
		String sql = "select * from Hoteis";
				
		Connection conn = null;
		PreparedStatement pstm =null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				  Hotel hotel = new Hotel();
				
				hotel.setIdHotel(rset.getInt("Id_hotel"));
				hotel.setPrecoPorNoite(rset.getDouble("preco_noite"));
				hotel.setCategorias(rset.getString("categorias"));
				hotel.setNomeHotel(rset.getString("nomes_hoteis"));
				hotel.setCep(rset.getString("cep"));
				hotel.setRua(rset.getString("rua"));
				hotel.setBairro(rset.getString("bairro"));
				hotel.setTelefone(rset.getString("telefone"));
			
				
				 hotels.add(hotel);
				
				
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
		

		
	return hotels;

	}

	//Update
	
	public void Update(Hotel hotel) {
		
		String sql ="update Hoteis set preco_noite = ?, categorias = ?, nomes_hoteis = ?, cep = ?,  rua = ?, bairro = ?, telefone = ? where Id_hotel = ?";;
		Connection conn = null;
		PreparedStatement pstm =null;
		
		
		try {	
		
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
				
			pstm.setDouble(1, hotel.getPrecoPorNoite());
			pstm.setString(2, hotel.getCategorias());
			pstm.setString(3, hotel.getNomeHotel());
			pstm.setString(4, hotel.getCep());
			pstm.setString(5, hotel.getRua());
			pstm.setString(6, hotel.getBairro());
			pstm.setString(7, hotel.getTelefone());
			pstm.setInt(8, hotel.getIdHotel());
			
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
		String sql = "DELETE FROM Hoteis WHERE Id_hotel = ?";
		
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
	public Hotel readById(int id) {
		Hotel hotel = new Hotel();
		String sql = "select * from Hoteis WHERE id_hotel = ?";
		
		Connection conn = null;
		PreparedStatement pstm =null;
		ResultSet rset = null;
		
		try {	
			
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			hotel.setIdHotel(rset.getInt("Id_hotel"));
			hotel.setPrecoPorNoite(rset.getDouble("preco_noite"));
			hotel.setCategorias(rset.getString("categorias"));
			hotel.setNomeHotel(rset.getString("nomes_hoteis"));
			hotel.setCep(rset.getString("cep"));
			hotel.setRua(rset.getString("rua"));
			hotel.setBairro(rset.getString("bairro"));
			hotel.setTelefone(rset.getString("telefone"));
		
			
		
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
		return hotel;
	}
}

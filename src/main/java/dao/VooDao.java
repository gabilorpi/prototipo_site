package dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

	import connection.ConnectionMySQL;
	import modelo.Voo;

	public class VooDao {

		//Create
		public void Create(Voo voo) {
			
			String Sql = "INSERT INTO Voo (hora_decolagem, data_decolagem, hora_aterrissagem, data_aterrissagem, origem, destino, preco) VALUES (?, ?, ?, ?, ?, ?, ?)";

			Connection conn = null;
			PreparedStatement pstm =null;
			
			try {
				conn = ConnectionMySQL.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(Sql);
				
				pstm.setString(1, voo.getHoraDecolagem());
	            pstm.setString(2, voo.getDataDecolagem());
	            pstm.setString(3, voo.getHoraAterrissagem());
	            pstm.setString(4, voo.getDataAterrissagem());
	            pstm.setString(5, voo.getOrigem());
	            pstm.setString(6, voo.getDestino());
	            pstm.setDouble(7, voo.getPreco());
				
		
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
		public List<Voo>read(){
			List<Voo>voos= new ArrayList<Voo>();
		
			String sql = "select * from Voo";
					
			Connection conn = null;
			PreparedStatement pstm =null;
			ResultSet rset = null;
			
			try {
				conn = ConnectionMySQL.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					  Voo voo = new Voo();
					
					  	voo.setIdVoo(rset.getInt("id_voo"));
		                voo.setHoraDecolagem(rset.getString("hora_decolagem"));
		                voo.setDataDecolagem(rset.getString("data_decolagem"));
		                voo.setHoraAterrissagem(rset.getString("hora_aterrissagem"));
		                voo.setDataAterrissagem(rset.getString("data_aterrissagem"));
		                voo.setOrigem(rset.getString("origem"));
		                voo.setDestino(rset.getString("destino"));
		                voo.setPreco(rset.getDouble("preco"));
					
				
					
					 voos.add(voo);
					
					
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
			

			
		return voos;

		}

		//Update
		
		public void Update(Voo voo) {
			
			String sql = "UPDATE Voo SET Hora_decolagem = ?, Data_decolagem = ?, Hora_aterrissagem = ?, Data_aterrissagem = ?, Origem = ?, Destino = ?, Preco = ? WHERE Id_voo = ?";

			Connection conn = null;
			PreparedStatement pstm =null;
			ResultSet rset = null;
			
			try {	
			
				conn = ConnectionMySQL.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, voo.getHoraDecolagem());
	            pstm.setString(2, voo.getDataDecolagem());
	            pstm.setString(3, voo.getHoraAterrissagem());
	            pstm.setString(4, voo.getDataAterrissagem());
	            pstm.setString(5, voo.getOrigem());
	            pstm.setString(6, voo.getDestino());
	            pstm.setDouble(7, voo.getPreco());
				pstm.setInt(8, voo.getIdVoo());
				
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
			String sql = "DELETE FROM Voo WHERE Id_voo = ?";
			
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
		public Voo readById(int id) {
			Voo voo = new Voo();
			String sql = "select * from Voo WHERE id_voo = ?";
			
			Connection conn = null;
			PreparedStatement pstm =null;
			ResultSet rset = null;
			
			try {	
				
				conn = ConnectionMySQL.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, id);
				
				rset = pstm.executeQuery();
				
				rset.next();
				voo.setIdVoo(rset.getInt("id_voo"));
                voo.setHoraDecolagem(rset.getString("hora_decolagem"));
                voo.setDataDecolagem(rset.getString("data_decolagem"));
                voo.setHoraAterrissagem(rset.getString("hora_aterrissagem"));
                voo.setDataAterrissagem(rset.getString("data_aterrissagem"));
                voo.setOrigem(rset.getString("origem"));
                voo.setDestino(rset.getString("destino"));
                voo.setPreco(rset.getDouble("preco"));
			
				
			
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
			return voo;
		}
	
	
	}
	




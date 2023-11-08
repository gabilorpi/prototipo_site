package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Agencia;

public class AgenciaDao {

	//Create
		public void Create(Agencia agencia) {
			
			String Sql = "insert into agencia (nome_agencia, cep, rua, bairro, telefone) values (?,?,?,?,?)";

			
			Connection conn = null;
			PreparedStatement pstm =null;
			
			try {
				conn = ConnectionMySQL.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(Sql);
				
				pstm.setString(1, agencia.getNomeAgencia());
				pstm.setString(2, agencia.getCep());
				pstm.setString(3, agencia.getRua());
				pstm.setString(4, agencia.getBairro());
				pstm.setString(5, agencia.getTelefone());
				
				
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
		public List<Agencia>read(){
			List<Agencia>agencias= new ArrayList<Agencia>();
		
			String sql = "select * from agencia";
					
			Connection conn = null;
			PreparedStatement pstm =null;
			ResultSet rset = null;
			
			try {
				conn = ConnectionMySQL.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					  Agencia agencia = new Agencia();
					
					agencia.setId_Agencia(rset.getInt("id_agencia"));
					agencia.setNome_Agencia(rset.getString("Nome_agencia"));
					agencia.setCep(rset.getString("cep"));
					agencia.setRua(rset.getString("rua"));
					agencia.setBairro(rset.getString("bairro"));
					agencia.setTelefone(rset.getString("telefone"));
					
					
					
					 agencias.add(agencia);
					
					
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
			

			
		return agencias;

		}

		//Update
		
		public void Update(Agencia agencia) {
			
			String sql ="update agencia set nome_agencia = ?, cep = ?, rua = ?, bairro = ?, telefone = ? where Id_agencia = ?";;
			Connection conn = null;
			PreparedStatement pstm =null;
			
			
			try {	
			
				conn = ConnectionMySQL.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
					
				pstm.setString(1, agencia.getNomeAgencia());
				pstm.setString(2, agencia.getCep());
				pstm.setString(3, agencia.getRua());
				pstm.setString(4, agencia.getBairro());
				pstm.setString(5, agencia.getTelefone());
				pstm.setInt(6, agencia.getIdAgencia());
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
			String sql = "DELETE FROM agencia WHERE Id_agencia = ?";
			
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
		public Agencia readById(int id) {
			Agencia agencia = new Agencia();
			String sql = "select * from agencia WHERE id_agencia = ?";
			
			Connection conn = null;
			PreparedStatement pstm =null;
			ResultSet rset = null;
			
			try {	
				
				conn = ConnectionMySQL.createConnectionToMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, id);
				
				rset = pstm.executeQuery();
				
				rset.next();
				
				agencia.setId_Agencia(rset.getInt("id_agencia"));
				agencia.setNome_Agencia(rset.getString("nome_agencia"));
				agencia.setCep(rset.getString("cep"));
				agencia.setRua(rset.getString("rua"));
				agencia.setBairro(rset.getString("bairro"));
				agencia.setTelefone(rset.getString("telefone"));
				
			
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
			return agencia;
		}
}

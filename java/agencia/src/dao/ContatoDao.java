package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Contato;

public class ContatoDao {
	//Create
			public void Create(Contato contato) {
				
				String Sql = "insert into contato (nome, email, telefone, mensagen) values (?,?,?,?)";

				
				Connection conn = null;
				PreparedStatement pstm =null;
				
				try {
					conn = ConnectionMySQL.createConnectionToMySQL();
					
					pstm = conn.prepareStatement(Sql);
					
					pstm.setString(1, contato.getNome());
					pstm.setString(2, contato.getEmail());
					pstm.setString(3, contato.getTelefone());
					pstm.setString(4, contato.getMensagem());
					
					
					
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
			public List<Contato>read(){
				List<Contato>contatos= new ArrayList<Contato>();
			
				String sql = "select * from contato";
						
				Connection conn = null;
				PreparedStatement pstm =null;
				ResultSet rset = null;
				
				try {
					conn = ConnectionMySQL.createConnectionToMySQL();
					
					pstm = conn.prepareStatement(sql);
					
					rset = pstm.executeQuery();
					
					while (rset.next()) {
						  Contato contato = new Contato();
						
						contato.setIdContato(rset.getInt("id_contato"));
						contato.setNome(rset.getString("nome"));
						contato.setEmail(rset.getString("email"));
						contato.setTelefone(rset.getString("telefone"));
						contato.setMensagem(rset.getString("mensagen"));
						
						
						
						 contatos.add(contato);
						
						
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
				

				
			return contatos;

			}

			//Update
			
			public void Update(Contato contato) {
				
				String sql ="update contato set nome = ?, email = ?, telefone = ?, mensagen = ? where Id_contato = ?";;
				Connection conn = null;
				PreparedStatement pstm =null;
			
				
				try {	
				
					conn = ConnectionMySQL.createConnectionToMySQL();
					
					pstm = conn.prepareStatement(sql);
						
					pstm.setString(1, contato.getNome());
					pstm.setString(2, contato.getEmail());
					pstm.setString(3, contato.getTelefone());
					pstm.setString(4, contato.getMensagem());
					pstm.setInt(5, contato.getIdContato());
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
				String sql = "DELETE FROM contato WHERE Id_contato = ?";
				
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
			public Contato readById(int id) {
				Contato contato = new Contato();
				String sql = "select * from contato WHERE id_contato = ?";
				
				Connection conn = null;
				PreparedStatement pstm =null;
				ResultSet rset = null;
				
				try {	
					
					conn = ConnectionMySQL.createConnectionToMySQL();
					
					pstm = conn.prepareStatement(sql);
					
					pstm.setInt(1, id);
					
					rset = pstm.executeQuery();
					
					rset.next();
					
					contato.setIdContato(rset.getInt("id_contato"));
					contato.setNome(rset.getString("nome"));
					contato.setEmail(rset.getString("email"));
					contato.setTelefone(rset.getString("telefone"));
					contato.setMensagem(rset.getString("mensagen"));
					
				
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
				return contato;
			}
}

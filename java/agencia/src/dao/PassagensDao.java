package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Passagens;

public class PassagensDao {
    

  
    public void Create(Passagens passagem) {
        String sql = "INSERT INTO Passagens (Id_passagem, Id_voo, fk_Cliente_Id_cliente, fk_Voo_Id_voo) VALUES (?, ?, ?, ?)";

    	Connection conn = null;
		PreparedStatement pstm =null;
        
        try  {
        	
        	conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
            pstm.setInt(1, passagem.getIdPassagem());
            pstm.setInt(2, passagem.getIdVoo());
            pstm.setInt(3, passagem.getFkClienteIdCliente());
            pstm.setInt(4, passagem.getFkVooIdVoo());

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

    public List<Passagens> read() {
        List<Passagens> passagens = new ArrayList<>();
        
        String sql = "SELECT * FROM Passagens";
		
        Connection conn = null;
		PreparedStatement pstm =null;
		ResultSet rset = null;
        try {
        	conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
            while (rset.next()) {
                Passagens passagem = new Passagens(rset.getInt("Id_passagem"),
                        rset.getInt("Id_voo"),
                        rset.getInt("fk_Cliente_Id_cliente"),
                        rset.getInt("fk_Voo_Id_voo"));

                passagens.add(passagem);
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
		
        return passagens;
    }

    public void Update(Passagens passagem) {
        String sql = "UPDATE Passagens SET fk_Cliente_Id_cliente = ?, fk_Voo_Id_voo = ? WHERE Id_passagem = ? AND Id_voo = ?";
    	
		Connection conn = null;
		PreparedStatement pstm =null;
		
       
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
				
            pstm.setInt(1, passagem.getFkClienteIdCliente());
            pstm.setInt(2, passagem.getFkVooIdVoo());
            pstm.setInt(3, passagem.getIdPassagem());
            pstm.setInt(4, passagem.getIdVoo());

            pstm.executeUpdate();
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

    public void delete(int idPassagem, int idVoo) {
        String sql = "DELETE FROM Passagens WHERE Id_passagem = ? AND Id_voo = ?";

    	Connection conn = null;
		PreparedStatement pstm =null;
	
        try  {
        	conn = ConnectionMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
            pstm.setInt(1, idPassagem);
            pstm.setInt(2, idVoo);

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

    public Passagens readById(int idPassagem, int idVoo) {
        Passagens passagem = null;
        String sql = "SELECT * FROM Passagens WHERE Id_passagem = ? AND Id_voo = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idPassagem);
            pstm.setInt(2, idVoo);
            rset = pstm.executeQuery();

            if (rset.next()) {
                passagem = new Passagens(
                    rset.getInt("Id_passagem"),
                    rset.getInt("Id_voo"),
                    rset.getInt("fk_Cliente_Id_cliente"),
                    rset.getInt("fk_Voo_Id_voo")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return passagem;
    }
}
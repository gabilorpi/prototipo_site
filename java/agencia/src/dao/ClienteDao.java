package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Cliente;

public class ClienteDao {

	//Create
	public void Create(Cliente cliente) {
		
		String Sql = "insert into Cliente (nome, email, senha, telefone, cpf, rua, cep, numero, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?,?,?)";

		
		Connection conn = null;
		PreparedStatement pstm =null;
		
		try {
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(Sql);
			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getSenha());
			pstm.setString(4, cliente.getTelefone());
			pstm.setString(5, cliente.getCpf());
			pstm.setString(6, cliente.getRua());
			pstm.setString(7, cliente.getCep());
			pstm.setInt(8, cliente.getNumero());
			pstm.setString(9, cliente.getBairro());
			pstm.setString(10, cliente.getCidade());
			pstm.setString(11, cliente.getEstado());
	
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
	public List<Cliente>read(){
		List<Cliente>clientes= new ArrayList<Cliente>();
	
		String sql = "select * from Cliente";
				
		Connection conn = null;
		PreparedStatement pstm =null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				  Cliente cliente = new Cliente();
				
				cliente.setIdCliente(rset.getInt("Id_cliente"));
				cliente.setNome(rset.getString("nome"));
				cliente.setEmail(rset.getString("email"));
				cliente.setSenha(rset.getString("senha"));
				cliente.setTelefone(rset.getString("telefone"));
				cliente.setCpf(rset.getString("cpf"));
				cliente.setRua(rset.getString("rua"));
				cliente.setCep(rset.getString("cep"));
				cliente.setNumero(rset.getInt("numero"));
				cliente.setBairro(rset.getString("bairro"));
				cliente.setCidade(rset.getString("cidade"));
				cliente.setEstado(rset.getString("estado"));
				
				 clientes.add(cliente);
				
				
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
		

		
	return clientes;

	}

	//Update
	
	public void Update(Cliente cliente) {
		
		String sql ="update Cliente set nome = ?, email = ?, senha = ?, telefone = ?, cpf = ?, rua = ?, cep = ?, numero = ?, bairro = ?, cidade = ?, estado = ? where Id_cliente = ?";;
		Connection conn = null;
		PreparedStatement pstm =null;
		ResultSet rset = null;
		
		try {	
		
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
				
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getSenha());
			pstm.setString(4, cliente.getTelefone());
			pstm.setString(5, cliente.getCpf());
			pstm.setString(6, cliente.getRua());
			pstm.setString(7, cliente.getCep());
			pstm.setInt(8, cliente.getNumero());
			pstm.setString(9, cliente.getBairro());
			pstm.setString(10, cliente.getCidade());
			pstm.setString(11, cliente.getEstado());
			pstm.setInt(12, cliente.getIdCliente());
			
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
		String sql = "DELETE FROM Cliente WHERE Id_cliente = ?";
		
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
	public Cliente readById(int id) {
		Cliente cliente = new Cliente();
		String sql = "select * from Cliente WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm =null;
		ResultSet rset = null;
		
		try {	
			
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			cliente.setIdCliente(rset.getInt("id_cliente"));
			cliente.setNome(rset.getString("nome"));
			cliente.setEmail(rset.getString("email"));
			cliente.setSenha(rset.getString("senha"));
			cliente.setTelefone(rset.getString("telefone"));
			cliente.setCpf(rset.getString("cpf"));
			cliente.setRua(rset.getString("rua"));
			cliente.setCep(rset.getString("cep"));
			cliente.setNumero(rset.getInt("numero"));
			cliente.setBairro(rset.getString("bairro"));
			cliente.setCidade(rset.getString("cidade"));
			cliente.setEstado(rset.getString("estado"));
			
		
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
		return cliente;
	}
}


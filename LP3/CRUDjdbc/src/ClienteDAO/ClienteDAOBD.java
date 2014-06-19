package ClienteDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import Database.DatabaseConnection;
import Model.Cliente;

public class ClienteDAOBD extends DatabaseConnection implements ClienteDAO {

	static Connection connect;
	static Scanner sc = new Scanner(System.in);

	@Override
	public void inserir(Cliente cliente) {

		try {

			startConnection("INSERT INTO cliente (nome, email, codPermissao)  VALUES (?,?,?)");

			cmd.setString(1, cliente.getName());
			cmd.setString(2, cliente.getEmail());
			cmd.setInt(3, 1);
			cmd.executeUpdate();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public void remover(Cliente cliente) {
		
		try {
			
			startConnection("DELETE FROM cliente WHERE nome = ?");
			cmd.setString(1, cliente.getName());
			cmd.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {

			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, e);
		
		}
		

	}


	/*
	 * 
	 * falta usuario escolher atualizar idade e id ( se necessario )
	 * 
	 */
	@Override
	public void atualizar(Cliente cliente) {
		
		try {
			
			startConnection("UPDATE cliente SET nome = ? WHERE nome = ?");
			cmd.setString(1, cliente.getName());
			cmd.setString(2, cliente.getName());
			cmd.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, e);
		
		}
		
	}

	@Override
	public List<Cliente> getTodosClientes() {
		
        List<Cliente> cliente = new ArrayList<>();

		
		try {
			
			startConnection("SELECT * FROM CLIENTE");
			ResultSet resultado = cmd.executeQuery();
			
			while (resultado.next()) {
				
			    Cliente c = new Cliente(
                        resultado.getString("NOME"),
                        resultado.getString("EMAIL"),
                        resultado.getInt("ID"));
                        
				cliente.add(c);
				
			}
			
			closeConnection();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, e);
        
		}
        
        return (cliente);
	}
	
	

	@Override
	public List<Cliente> getClientesBuscandoPorNome(String nome) {
		
		   List<Cliente> listaCliente = new ArrayList<>();
	        try {

	            startConnection("SELECT * FROM CLIENTE WHERE NOME LIKE ?");
	            cmd.setString(1, "%" + nome + "%");
	            ResultSet resultado = cmd.executeQuery();
	            
	            while (resultado.next()) {
	                Cliente c = new Cliente(
	                		  resultado.getString("NOME"),
	                          resultado.getString("EMAIL"),
	                          resultado.getInt("ID"));
	                
	                listaCliente.add(c);
	                
	            }
	            
	            closeConnection();
	            
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return (listaCliente);
	    }

	
	}



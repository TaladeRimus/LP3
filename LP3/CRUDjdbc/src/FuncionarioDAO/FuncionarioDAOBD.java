package FuncionarioDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Database.DatabaseConnection;
import Model.Funcionario;

public class FuncionarioDAOBD extends DatabaseConnection implements FuncionarioDAO {

	@Override
	public void inserir(Funcionario funcionario) {

		try {

			startConnection("INSERT INTO funcionario (nome, email, codPermissao)  VALUES (?,?,?)");

			cmd.setString(1, funcionario.getName());
			cmd.setString(2, funcionario.getEmail());
			cmd.setInt(3, 2);
			cmd.executeUpdate();
			
			closeConnection();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public void remover(Funcionario funcionario) {

		try {

			startConnection("DELETE FROM funcionario WHERE nome = ?");
			cmd.setString(1, funcionario.getName());
			cmd.executeUpdate();
			
			closeConnection();

		} catch (ClassNotFoundException | SQLException e) {

			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, e);

		}



	}

	@Override
	public void atualizar(Funcionario funcionario) {

		try {

			startConnection("UPDATE funcionario SET nome = ? WHERE nome = ?");
			cmd.setString(1, funcionario.getName());
			cmd.setString(2, funcionario.getName());
			cmd.executeUpdate();
			
			closeConnection();

		} catch (ClassNotFoundException | SQLException e) {

			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, e);

		}

	}

	@Override
	public List<Funcionario> getTodosFuncionarios() {
		 List<Funcionario> funcionario = new ArrayList<>();

			
			try {
				
				startConnection("SELECT * FROM FUNCIONARIO");
				ResultSet resultado = cmd.executeQuery();
				
				while (resultado.next()) {
					
				    Funcionario f = new Funcionario(
	                        resultado.getString("NOME"),
	                        resultado.getString("EMAIL"),
	                        resultado.getInt("CODPERMISSAO"));
	                        
					funcionario.add(f);
					
				}
				
				closeConnection();
				
			} catch (ClassNotFoundException | SQLException e) {
				
				Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, e);
	        
			}
	        
	        return (funcionario);
	}

	@Override
	public List<Funcionario> getFuncionariosBuscandoPorNome(String nome) {

		   List<Funcionario> listaFuncionario = new ArrayList<>();
	        try {

	            startConnection("SELECT * FROM FUNCIONARIO WHERE NOME LIKE ?");
	            cmd.setString(1, "%" + nome + "%");
	            ResultSet resultado = cmd.executeQuery();
	            
	            while (resultado.next()) {
	            	
	                Funcionario f = new Funcionario(
	                		  resultado.getString("NOME"),
	                          resultado.getString("EMAIL"),
	                          resultado.getInt("CODPERMISSAO"));
	                
	                listaFuncionario.add(f);
	                
	            }
	            
	            closeConnection();
	            
	        } catch (ClassNotFoundException | SQLException ex) {
	        	
	            Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
	            
	        }
	        
	        return (listaFuncionario);
	}

}

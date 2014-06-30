package ProdutosDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Database.DatabaseConnection;
import FuncionarioDAO.FuncionarioDAOBD;
import Model.Produtos;

public class ProdutosDAOBD extends DatabaseConnection implements ProdutosDAO {
	
	

	@Override
	public Produtos inserir(Produtos produtos) {
		
		try {

			startConnection("INSERT INTO produto (nome, categoria, preco, qtd)  VALUES (?,?,?,?)");

			cmd.setString(1, produtos.getNome());
			cmd.setString(2, produtos.getCategoria());
			cmd.setDouble(3, produtos.getPreco());
			cmd.setInt(4, produtos.getQtd());
			cmd.executeUpdate();
			
			closeConnection();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return produtos;

		
	}

	@Override
	public void remover(Produtos produtos) {

		try {

			startConnection("DELETE FROM produto WHERE nome = ?");
			cmd.setString(1, produtos.getNome());
			cmd.executeUpdate();
			
			closeConnection();

		} catch (ClassNotFoundException | SQLException e) {

			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, e);

		}

		
	}

	@Override
	public void atualizar(Produtos produtos) {
		
		try {

			startConnection("UPDATE produtos SET nome = ? WHERE nome = ?");
			cmd.setString(1, produtos.getNome());
			cmd.setString(2, produtos.getNome());
			cmd.executeUpdate();
			
			closeConnection();

		} catch (ClassNotFoundException | SQLException e) {

			Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, e);

		}

		
	}

	@Override
	public List<Produtos> getTodosProdutos() {
		
		 List<Produtos> produtos = new ArrayList<>();

			
			try {
				
				startConnection("SELECT * FROM PRODUTO");
				ResultSet resultado = cmd.executeQuery();
				
				while (resultado.next()) {
					
				    Produtos p = new Produtos(
	                        resultado.getString("NOME"),
	                        resultado.getString("CATEGORIA"),
	                        resultado.getInt("PRECO"),
	                        resultado.getInt("IDPRODUTO"),
	                        resultado.getInt("QTD"));
	                        
					produtos.add(p);
					
				}
				
				closeConnection();
				
			} catch (ClassNotFoundException | SQLException e) {
				
				Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, e);
	        
			}
	        
	        return (produtos);
	}

	@Override
	public List<Produtos> getProdutosBuscandoPorCategoria(String categoria) {
		
		List<Produtos> listaProdutos = new ArrayList<>();
		
        try {

            startConnection("SELECT * FROM PRODUTO WHERE CATEGORIA LIKE ?");
            cmd.setString(1, categoria);
            ResultSet resultado = cmd.executeQuery();
            
            while (resultado.next()) {
            	
                Produtos p = new Produtos(
                		  resultado.getString("NOME"),
                          resultado.getString("CATEGORIA"),
                          resultado.getInt("PRECO"),
                          resultado.getInt("IDPRODUTO"),
                          resultado.getInt("QTD"));
                
                listaProdutos.add(p);
                
            }
            
            closeConnection();
            
        } catch (ClassNotFoundException | SQLException ex) {
        	
            Logger.getLogger(FuncionarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return (listaProdutos);
	
	}
	
	
	
	
	
}

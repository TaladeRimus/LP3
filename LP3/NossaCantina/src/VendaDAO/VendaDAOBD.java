package VendaDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ClienteDAO.ClienteDAOBD;
import Database.DatabaseConnection;
import Model.Cliente;
import Model.Produtos;
import Model.Venda;

public class VendaDAOBD extends DatabaseConnection implements VendaDAO {
	
	Produtos p = new Produtos();

	@Override
	public Venda realizaVenda(Venda venda) {
		
		
		

	
			try {
			
				startConnection("INSERT INTO VENDA (idProdutoFK, idClienteFK, idFuncionarioFK) values(? ,? ,? )" );
				
				cmd.setInt(1, venda.getIdProd());
				cmd.setInt(2, venda.getIdCliente());
				cmd.setInt(3, venda.getIdFunc());
				
				System.out.println("produto " + venda.getIdProd());
				System.out.println("funcionario " + venda.getIdFunc());
				System.out.println("cliente " + venda.getIdCliente());
				
				cmd.executeUpdate();
				
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
	
			}
			return venda;
			
	}

	@Override
	public void removeVenda(Venda venda) {
		
		try {
			
			startConnection("DELETE FROM VENDA WHERE idProdutoFK = ?");
			
			cmd.setInt(1, p.getId());
			
			cmd.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Venda> listarTodasVendas() {
		
		List<Venda> listaVenda = new ArrayList<>();


		try {

			startConnection("SELECT * FROM VENDA");
			ResultSet resultado = cmd.executeQuery();

			while (resultado.next()) {

				Venda c = new Venda(
						resultado.getInt("IDVENDA"),
						resultado.getString("DVENDA"),
						resultado.getInt("IDPRODUTOFK"),
						resultado.getInt("IDCLIENTEFK"),
						resultado.getInt("IDFUNCIONARIOFK"));

				listaVenda.add(c);

			}

			closeConnection();

		} catch (ClassNotFoundException | SQLException e) {

			Logger.getLogger(ClienteDAOBD.class.getName()).log(Level.SEVERE, null, e);

		}

		return (listaVenda);
		
		
		
	}
	
	

}

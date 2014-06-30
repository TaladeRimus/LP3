/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Produtos;
import ProdutosDAO.ProdutosDAO;
import ProdutosDAO.ProdutosDAOBD;


public class ProdutosModelo extends AbstractTableModel {

	String header[];
	List<Produtos> produtos;

	public ProdutosModelo() {

		produtos = new ArrayList<Produtos>();

	}

	public ProdutosModelo(String[] header) {
		this.header = header;
		ProdutosDAOBD dao = new ProdutosDAOBD();
		this.produtos = dao.getTodosProdutos();

	}

	public ProdutosModelo(String[] header, List<Produtos> produtos) {
		this.header = header;
		this.produtos = produtos;

	}

	@Override
	public int getRowCount() {
		return (produtos.size());
	}

	@Override
	public int getColumnCount() {
		return (4);
	}

	@Override
	public String getColumnName(int column) {
		return header[column]; //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if (columnIndex == 0) {
			
			return (produtos.get(rowIndex).getId());
			
		} else if ( columnIndex == 1 ) {
			
			return (produtos.get(rowIndex).getNome());
		}
		
		else if ( rowIndex == 2 ){
			
			return produtos.get(rowIndex).getCategoria();        	
		}
		
		else {
			
			return produtos.get(rowIndex).getPreco();
		}

	}

	public void addProduto(Produtos p) {
		ProdutosDAOBD dao = new ProdutosDAOBD();
		produtos.add(dao.inserir(p));
	}

	public void removeProduto(int linha) {
		ProdutosDAOBD dao = new ProdutosDAOBD();
		dao.remover(produtos.get(linha));
		produtos.remove(linha);

	}

	public Produtos getProdutos(int linha) {
		return (produtos.get(linha));
	}


}

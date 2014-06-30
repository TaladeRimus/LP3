/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ClienteDAO.ClienteDAOBD;
import Model.Cliente;
import Model.Venda;
import VendaDAO.VendaDAOBD;


public class VendasModelo extends AbstractTableModel {

    String header[];
    List<Cliente> clientes;
    List<Venda> venda;
    
    public VendasModelo() {
    	
        clientes = new ArrayList<Cliente>();
        venda = new ArrayList<Venda>();

    }

    public VendasModelo(String[] header) {
    	
        this.header = header;
        ClienteDAOBD daoCliente = new ClienteDAOBD();
        VendaDAOBD daoVenda = new VendaDAOBD();
        this.clientes = daoCliente.getTodosClientes();
        this.venda = daoVenda.listarTodasVendas();

    }

    public VendasModelo(String[] header, List<Cliente> clientes) {
        this.header = header;
        this.clientes = clientes;

    }

    @Override
    public int getRowCount() {
        return (venda.size());
    }

    @Override
    public int getColumnCount() {
        return (2);
    }

    @Override
    public String getColumnName(int column) {
        return header[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return (venda.get(rowIndex).getIdVenda());
        }
        else {
        	return (venda.get(rowIndex).getIdCliente());
        }


    }
    
    public void addCliente(Cliente c) {
		ClienteDAOBD dao = new ClienteDAOBD();
		clientes.add(dao.inserir(c));
	}

	public void removeCliente(int linha) {
		ClienteDAOBD dao = new ClienteDAOBD();
		dao.remover(clientes.get(linha));
		clientes.remove(linha);

	}

    public Cliente getCliente(int linha) {
        return (clientes.get(linha));
    }
    
}


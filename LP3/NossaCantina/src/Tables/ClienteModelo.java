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


public class ClienteModelo extends AbstractTableModel {

    String header[];
    List<Cliente> clientes;
    
    public ClienteModelo() {
    	
        clientes = new ArrayList<Cliente>();

    }

    public ClienteModelo(String[] header) {
    	
        this.header = header;
        ClienteDAOBD daoCliente = new ClienteDAOBD();
        this.clientes = daoCliente.getTodosClientes();

    }

    public ClienteModelo(String[] header, List<Cliente> clientes) {
        this.header = header;
        this.clientes = clientes;

    }

    @Override
    public int getRowCount() {
        return (clientes.size());
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
            return (clientes.get(rowIndex).getId());
        }
        else {
        	return (clientes.get(rowIndex).getName());
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


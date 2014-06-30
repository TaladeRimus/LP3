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


public class VendaDataModelo extends AbstractTableModel {

    String header[];
    List<Venda> venda;
    
    public VendaDataModelo() {
    	
        venda = new ArrayList<Venda>();

    }

    public VendaDataModelo(String[] header) {
    	
        this.header = header;
        VendaDAOBD daoVenda = new VendaDAOBD();
        this.venda = daoVenda.listarTodasVendas();

    }

    public VendaDataModelo(String[] header, List<Venda> venda) {
        this.header = header;
        this.venda = venda;

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
        	return (venda.get(rowIndex).getdVenda());
        }


    }
    
    public void addVendaMes(Venda v) {
		VendaDAOBD dao = new VendaDAOBD();
		venda.add(dao.realizaVenda(v));
	}

	public void removeVendaMes(int linha) {
		VendaDAOBD dao = new VendaDAOBD();
		dao.removeVenda(venda.get(linha));
		venda.remove(linha);

	}

    public Venda getVendaMes(int linha) {
        return (venda.get(linha));
    }
    
}


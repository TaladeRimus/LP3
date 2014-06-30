/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import FuncionarioDAO.FuncionarioDAOBD;
import Model.Funcionario;


public class FuncionarioModelo extends AbstractTableModel {

    String header[];
    List<Funcionario> funcionario;
    
    public FuncionarioModelo() {
    	
        funcionario = new ArrayList<Funcionario>();

    }

    public FuncionarioModelo(String[] header) {
    	
        this.header = header;
        FuncionarioDAOBD dao = new FuncionarioDAOBD();
        this.funcionario = dao.getTodosFuncionarios();

    }

    public FuncionarioModelo(String[] header, List<Funcionario> funcionario) {
        this.header = header;
        this.funcionario = funcionario;

    }

    @Override
    public int getRowCount() {
        return (funcionario.size());
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
            return (funcionario.get(rowIndex).getId());
        }
        else {
        	return (funcionario.get(rowIndex).getName());
        }

    }
    
    public void addFuncionario(Funcionario f) {
		FuncionarioDAOBD dao = new FuncionarioDAOBD();
		funcionario.add(dao.inserir(f));
	}

	public void removeFuncionario(int linha) {
		FuncionarioDAOBD dao = new FuncionarioDAOBD();
		dao.remover(funcionario.get(linha));
		funcionario.remove(linha);

	}

    public Funcionario getFuncionario(int linha) {
        return (funcionario.get(linha));
    }
    
}


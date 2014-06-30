/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Tables;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.Cliente;


public class TabelaClientes extends JPanel {
	
    JTable tabelaCliente;

    public TabelaClientes()
    {
        String[] colunas = {"ID Cliente", "Nome"};

        ClienteModelo modelo = new ClienteModelo(colunas);
        tabelaCliente = new JTable(modelo);
        tabelaCliente.setPreferredScrollableViewportSize(new Dimension(200, 70));
        tabelaCliente.setFillsViewportHeight(true);
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tabelaCliente);

        //Add the scroll pane to this panel.
        add(scrollPane);


    }
    public JTable getTabela() {
        return tabelaCliente;
    }

    public void adicionaClientes(Cliente cliente)
    {
        ClienteModelo modelo = (ClienteModelo)getTabela().getModel();
        modelo.addCliente(cliente);
        getTabela().updateUI();
        
    }

    public void removeCliente(int linha)
    {
        ClienteModelo modelo = (ClienteModelo)getTabela().getModel();
        System.out.println("Nome:"
                + modelo.getCliente(linha).getName());
        modelo.removeCliente(linha);
        getTabela().updateUI();
        
    }

    public void removeClienteSelecionada()
    {
        int linha = getTabela().getSelectedRow();
        if(linha >= 0)
        {
            removeCliente(linha);
        }
    }
}

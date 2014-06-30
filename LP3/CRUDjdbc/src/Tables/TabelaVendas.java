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


public class TabelaVendas extends JPanel {
    JTable tabelaVenda;

    public TabelaVendas()
    {
        String[] colunas = {"ID Venda", "ID Cliente"};

        VendasModelo modelo = new VendasModelo(colunas);
        tabelaVenda = new JTable(modelo);
        tabelaVenda.setPreferredScrollableViewportSize(new Dimension(200, 70));
        tabelaVenda.setFillsViewportHeight(true);
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tabelaVenda);

        //Add the scroll pane to this panel.
        add(scrollPane);


    }
    public JTable getTabela() {
        return tabelaVenda;
    }

    public void adicionaClientes(Cliente cliente)
    {
        VendasModelo modelo = (VendasModelo)getTabela().getModel();
        modelo.addCliente(cliente);
        getTabela().updateUI();
        
    }

    public void removeCliente(int linha)
    {
        VendasModelo modelo = (VendasModelo)getTabela().getModel();
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

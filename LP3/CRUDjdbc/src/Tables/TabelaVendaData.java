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
import Model.Funcionario;
import Model.Venda;


public class TabelaVendaData extends JPanel {
    JTable tabelaVendaData;

    public TabelaVendaData()
    {
        String[] colunas = {"ID Venda", "ID Funcionario"};

        VendaDataModelo modelo = new VendaDataModelo(colunas);
        tabelaVendaData = new JTable(modelo);
        tabelaVendaData.setPreferredScrollableViewportSize(new Dimension(200, 70));
        tabelaVendaData.setFillsViewportHeight(true);
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tabelaVendaData);

        //Add the scroll pane to this panel.
        add(scrollPane);


    }
    public JTable getTabela() {
        return tabelaVendaData;
    }

    public void adicionaVendaData(Venda venda)
    {
        FuncionarioVendasModelo modelo = (FuncionarioVendasModelo)getTabela().getModel();
        modelo.addVendaFuncionario(venda);
        getTabela().updateUI();
        
    }

    public void removeVendaData(int linha)
    {
        FuncionarioVendasModelo modelo = (FuncionarioVendasModelo)getTabela().getModel();
        System.out.println("Nome:"
                + modelo.getVenda(linha).getIdVenda());
        modelo.removeVendaFuncionario(linha);
        getTabela().updateUI();
        
    }

    public void removeVendaDataSelecionada()
    {
        int linha = getTabela().getSelectedRow();
        if(linha >= 0)
        {
            removeVendaData(linha);
        }
    }
}

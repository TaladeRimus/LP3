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

public class TabelaVendaFunc extends JPanel {
    JTable tabelaVenda;

    public TabelaVendaFunc()
    {
        String[] colunas = {"ID Venda", "ID Funcionario"};

        FuncionarioVendasModelo modelo = new FuncionarioVendasModelo(colunas);
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

    public void adicionaFuncionario(Venda venda)
    {
        FuncionarioVendasModelo modelo = (FuncionarioVendasModelo)getTabela().getModel();
        modelo.addVendaFuncionario(venda);
        getTabela().updateUI();
        
    }

    public void removeVendaFuncionario(int linha)
    {
        FuncionarioVendasModelo modelo = (FuncionarioVendasModelo)getTabela().getModel();
        System.out.println("Nome:"
                + modelo.getVenda(linha).getIdVenda());
        modelo.removeVendaFuncionario(linha);
        getTabela().updateUI();
        
    }

    public void removeFuncionarioSelecionada()
    {
        int linha = getTabela().getSelectedRow();
        if(linha >= 0)
        {
            removeVendaFuncionario(linha);
        }
    }
}

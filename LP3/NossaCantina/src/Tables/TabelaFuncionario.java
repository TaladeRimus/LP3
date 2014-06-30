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


public class TabelaFuncionario extends JPanel {
    JTable tabelaFuncionario;

    public TabelaFuncionario()
    {
        String[] colunas = {"ID Cliente", "Nome"};

        FuncionarioModelo modelo = new FuncionarioModelo(colunas);
        tabelaFuncionario = new JTable(modelo);
        tabelaFuncionario.setPreferredScrollableViewportSize(new Dimension(200, 70));
        tabelaFuncionario.setFillsViewportHeight(true);
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tabelaFuncionario);

        //Add the scroll pane to this panel.
        add(scrollPane);


    }
    public JTable getTabela() {
        return tabelaFuncionario;
    }

    public void adicionaClientes(Funcionario funcionario)
    {
        FuncionarioModelo modelo = (FuncionarioModelo)getTabela().getModel();
        modelo.addFuncionario(funcionario);
        getTabela().updateUI();
        
    }

    public void removeFuncionario(int linha)
    {
        FuncionarioModelo modelo = (FuncionarioModelo)getTabela().getModel();
        System.out.println("Nome:"
                + modelo.getFuncionario(linha).getName());
        modelo.removeFuncionario(linha);
        getTabela().updateUI();
        
    }

    public void removeFuncionarioSelecionada()
    {
        int linha = getTabela().getSelectedRow();
        if(linha >= 0)
        {
            removeFuncionario(linha);
        }
    }
}

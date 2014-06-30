/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Tables;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.Produtos;

public class TabelaProdutos extends JPanel {
    JTable tabelaProdutos;

    public TabelaProdutos()
    {
        String[] colunas = {"ID", "Nome", "Categoria", "Preco"};

        ProdutosModelo modelo = new ProdutosModelo(colunas);
        tabelaProdutos = new JTable(modelo);
        tabelaProdutos.setPreferredScrollableViewportSize(new Dimension(200, 70));
        tabelaProdutos.setFillsViewportHeight(true);
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);

        //Add the scroll pane to this panel.
        add(scrollPane);


    }
    
    public JTable getTabela() {
        return tabelaProdutos;
    }

    public void adicionaProdutos(Produtos produto)
    {
        ProdutosModelo modelo = (ProdutosModelo)getTabela().getModel();
        modelo.addProduto(produto);
        getTabela().updateUI();
        
    }

    public void removeProduto(int linha)
    {
        ProdutosModelo modelo = (ProdutosModelo)getTabela().getModel();
        System.out.println("Nome:"
                + modelo.getProdutos(linha).getNome());
        modelo.removeProduto(linha);
        getTabela().updateUI();
        
    }

    public void removeProdutoSelecionada()
    {
        int linha = getTabela().getSelectedRow();
        if(linha >= 0)
        {
            removeProduto(linha);
        }
    }
	public void setTabela(JTable tabela) {
		this.tabelaProdutos = tabela;
	}
	
	public int retornaCod(int row) {
		
		ProdutosModelo modelo = (ProdutosModelo) getTabela().getModel();
		int codReturn = modelo.getProdutos(row).getId();
		return codReturn;
		
	}

	public double retornaPreco(int row) {
		
		ProdutosModelo modelo = (ProdutosModelo) getTabela().getModel();
		double precoReturn = modelo.getProdutos(row).getPreco();
		return precoReturn;
		
	}
    
}

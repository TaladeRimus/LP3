package Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import Tables.TabelaProdutos;

public class ProdutosTable extends JFrame {

	private JPanel contentPane;
	private TabelaProdutos table;

	/**
	 * Create the frame.
	 */
	public ProdutosTable() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new TabelaProdutos();
		table.setBounds(10, 11, 414, 240);
		contentPane.add(table);
	}
}

package Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import Tables.TabelaFuncionario;

public class FuncionarioTable extends JFrame {

	private JPanel contentPane;
	private TabelaFuncionario table;



	/**
	 * Create the frame.
	 */
	public FuncionarioTable() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new TabelaFuncionario();
		contentPane.add(table, BorderLayout.CENTER);
	}

}

package Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import Tables.TabelaClientes;

public class ClienteTable extends JFrame {

	private JPanel contentPane;
	private TabelaClientes tabelaCliente;



	/**
	 * Create the frame.
	 */
	public ClienteTable() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabelaCliente = new TabelaClientes();
		tabelaCliente.setBounds(10, 21, 414, 217);
		contentPane.add(tabelaCliente);
	}

}

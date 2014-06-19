package Windows;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Model.Produtos;
import ProdutosDAO.ProdutosDAOBD;

public class DelProdutos extends JFrame {

	
	Produtos p = new Produtos(null, null, 0);
	ProdutosDAOBD pDAOBD = new ProdutosDAOBD();
	
	private JPanel contentPane;
	private JTextField txt_nome;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelProdutos frame = new DelProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DelProdutos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 200, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setBounds(10, 36, 46, 14);
		contentPane.add(lblNome);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(66, 33, 86, 20);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				delete();
				
			}
		});
		btnDeletar.setBounds(43, 95, 89, 23);
		contentPane.add(btnDeletar);
	
	}
	
	private void delete(){
		
		p.setNome(txt_nome.getText());
		
		pDAOBD.remover(p);
		
		
	}
	
}

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

public class AddProdutos extends JFrame {

	
	Produtos p = new Produtos(null, null, 0);
	ProdutosDAOBD pDAOBD = new ProdutosDAOBD();
	private JPanel contentPane;
	private JTextField txt_nome;
	private JTextField txt_preco;
	private JTextField txt_categoria;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProdutos frame = new AddProdutos();
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
	public AddProdutos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 200, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setBounds(10, 35, 46, 14);
		contentPane.add(lblNome);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(66, 32, 86, 20);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				inserir();
				
			}
		});
		btnAdicionar.setBounds(39, 128, 89, 23);
		contentPane.add(btnAdicionar);
		
		JLabel lblCategoria = new JLabel("Categoria : ");
		lblCategoria.setBounds(10, 60, 70, 14);
		contentPane.add(lblCategoria);
		
		txt_categoria = new JTextField();
		txt_categoria.setBounds(66, 57, 86, 20);
		contentPane.add(txt_categoria);
		txt_categoria.setColumns(10);
		
		JLabel lblPreco = new JLabel("Preco : ");
		lblPreco.setBounds(10, 85, 46, 14);
		contentPane.add(lblPreco);
		
		txt_preco = new JTextField();
		txt_preco.setBounds(66, 85, 86, 20);
		contentPane.add(txt_preco);
		txt_preco.setColumns(10);
		
	}
	
	private void inserir(){
		
		p.setNome(txt_nome.getText());
		p.setCategoria(txt_categoria.getText());
		p.setPreco(Double.parseDouble(txt_preco.getText()));
		
		pDAOBD.inserir(p);
		
		
	}

}

package Windows;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Database.DatabaseConnection;
import Model.Produtos;
import Model.Venda;
import ProdutosDAO.ProdutosDAOBD;
import VendaDAO.VendaDAOBD;

public class DelProdutos extends JFrame {

	
	Produtos p = new Produtos();
	ProdutosDAOBD pDAOBD = new ProdutosDAOBD();
	VendaDAOBD vDAOBD = new VendaDAOBD();
	Venda v = new Venda();
	DatabaseConnection db = new DatabaseConnection();
	
	private PreparedStatement cmd;
	private ResultSet result;
	
	private JPanel contentPane;
	private JTextField txt_nome;


	/**
	 * Create the frame.
	 */
	public DelProdutos() {
		setVisible(true);
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
		v.setIdProd(retornaIdProduto());
		
		vDAOBD.removeVenda(v);
		pDAOBD.remover(p);
		
	}
	
	private int retornaIdProduto(){
		
		p.setNome(txt_nome.getText());
	
			
			try {
				cmd = db.startConnectionPS("SELECT * FROM PRODUTO WHERE nome = " + "'" + p.getNome() + "'");
				
				result = cmd.executeQuery();
				
				while(result.next()){
					
					p.setNome(result.getString("NOME"));
					p.setId(result.getInt("IDPRODUTO"));
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
				
			}
			
			

		
		return p.getId();
		
	}
	
}

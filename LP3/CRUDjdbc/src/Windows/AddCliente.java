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

import ClienteDAO.ClienteDAOBD;
import Model.Cliente;

public class AddCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3353384308590858030L;
	private JPanel contentPane;
	private JTextField txt_nome;

	Cliente p = new Cliente(null, null, 1);
	ClienteDAOBD pDAOBD = new ClienteDAOBD();
	private JTextField txt_email;
	/**
	 * Launch the application.
	 */
	
	
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCliente frame = new AddCliente();
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
	public AddCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 200, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setBounds(10, 27, 46, 14);
		contentPane.add(lblNome);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(63, 24, 86, 20);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				insert();
				
				
			}
		});
		btnCadastrar.setBounds(60, 116, 98, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setBounds(10, 58, 46, 14);
		contentPane.add(lblEmail);
		
		txt_email = new JTextField();
		txt_email.setBounds(63, 55, 86, 20);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
	}
	
	private void insert(){
		
		p.setName(txt_nome.getText());
		p.setEmail(txt_email.getText());
		
		
		pDAOBD.inserir(p);
		
	}
}

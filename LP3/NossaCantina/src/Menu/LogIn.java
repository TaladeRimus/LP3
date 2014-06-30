package Menu;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Database.DatabaseConnection;
import Model.Cliente;
import Model.Funcionario;

public class LogIn extends JFrame {


	Cliente c = new Cliente(null, null, null, 0, 0);
	Funcionario f = new Funcionario(null, null, null, 0);
	DatabaseConnection db = new DatabaseConnection();
	
	private PreparedStatement cmd;
	private ResultSet result;
	private JPanel contentPane;
	private JTextField txt_senha;
	private JTextField txt_nome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(10, 35, 46, 14);
		contentPane.add(lblNome);

		JLabel lblSenha = new JLabel("Senha : ");
		lblSenha.setBounds(10, 60, 46, 14);
		contentPane.add(lblSenha);

		txt_senha = new JTextField();
		txt_senha.setBounds(66, 57, 86, 20);
		contentPane.add(txt_senha);
		txt_senha.setColumns(10);

		txt_nome = new JTextField();
		txt_nome.setBounds(66, 32, 86, 20);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);

		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					
					verifica();
					
				} catch (HeadlessException | ClassNotFoundException
						| SQLException e1) {
					
					e1.printStackTrace();
					
				}


			}
		});
		btnLogIn.setBounds(33, 103, 89, 23);
		contentPane.add(btnLogIn);
	}

	private void verifica() throws HeadlessException, ClassNotFoundException, SQLException{

		

		if ( (verificaFuncionario(txt_nome.getText(), txt_senha.getText() ) ) == true) {

			JOptionPane.showMessageDialog( null, "Bem vindo " + txt_nome.getText() );
			dispose();
			MenuFunc.main(null);

		}
		
		else if ( ( verificaCliente(txt_nome.getText(), txt_senha.getText() ) ) == true) {

			JOptionPane.showMessageDialog( null, "Bem vindo " + txt_nome.getText() );
			dispose();
			MenuCliente.main(null);
		} 

		else {

			JOptionPane.showMessageDialog(null, "Username or Password is wrong");

		}


	}

	private boolean verificaFuncionario(String usuario, String senha) throws SQLException, ClassNotFoundException {		

		
		boolean login = false;
		
		cmd = db.startConnectionPS("select * from login where login.codfuncionario = 2");
		
		
		result = cmd.executeQuery();

		while (result.next()) {

			if ( usuario.equals(result.getString("usuario") ) ) {
				
				if ( senha.equals(result.getString("senha") ) ) {
					
					KeepLog.user = result.getString("usuario");
					login = true;

				}
			}
		}

		return login;
	}

	private boolean verificaCliente(String usuario, String senha) throws SQLException, ClassNotFoundException {		

		boolean login = false;
		
		cmd = db.startConnectionPS("select * from login where login.codCliente = 1");
		
		result = cmd.executeQuery();

		while (result.next()) {

			if ( usuario.equals(result.getString("usuario") ) ) {
				
				if ( senha.equals(result.getString("senha") ) ) {
					
					KeepLog.user = result.getString("usuario");
					login = true;

				}
			}
		}

		return login;
	}

	public String getKeepLog() {
		
		return KeepLog.user;
		
	}
	

	final static class KeepLog {
		
	 public static String user = null;
	
	
	}
	 
}

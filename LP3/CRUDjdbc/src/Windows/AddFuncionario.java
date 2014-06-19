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

import FuncionarioDAO.FuncionarioDAOBD;
import Model.Funcionario;

public class AddFuncionario extends JFrame {

	
	Funcionario f = new Funcionario(null, null, 2);
	FuncionarioDAOBD func = new FuncionarioDAOBD(); 
	private JPanel contentPane;
	private JTextField txt_nome;
	private JTextField txt_email;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFuncionario frame = new AddFuncionario();
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
	public AddFuncionario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 200, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setBounds(10, 34, 46, 14);
		contentPane.add(lblNome);

		txt_nome = new JTextField();
		txt_nome.setBounds(66, 34, 86, 20);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail : ");
		lblEmail.setBounds(10, 71, 46, 14);
		contentPane.add(lblEmail);

		txt_email = new JTextField();
		txt_email.setBounds(66, 68, 86, 20);
		contentPane.add(txt_email);
		txt_email.setColumns(10);

		JButton btnCategoria = new JButton("Cadastrar");
		btnCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				insert();


			}
		});
		btnCategoria.setBounds(37, 113, 97, 23);
		contentPane.add(btnCategoria);
	}

	private void insert(){

		f.setName(txt_nome.getText());
		f.setEmail(txt_email.getText());

		func.inserir(f);

	}
}

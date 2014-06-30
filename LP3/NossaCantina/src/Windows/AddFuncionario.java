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

	
	Funcionario f = new Funcionario(null, null, null, 0);
	FuncionarioDAOBD func = new FuncionarioDAOBD(); 
	private JPanel contentPane;
	private JTextField txt_nome;
	private JTextField txt_email;
	private JTextField txt_senha;


	/**
	 * Create the frame.
	 */
	public AddFuncionario() {
		setVisible(true);
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
		btnCategoria.setBounds(39, 128, 97, 23);
		contentPane.add(btnCategoria);
		
		JLabel lblSenha = new JLabel("Senha : ");
		lblSenha.setBounds(10, 103, 46, 14);
		contentPane.add(lblSenha);
		
		txt_senha = new JTextField();
		txt_senha.setBounds(66, 99, 86, 20);
		contentPane.add(txt_senha);
		txt_senha.setColumns(10);
	}

	private void insert(){

		f.setName(txt_nome.getText());
		f.setEmail(txt_email.getText());
		f.setSenha(txt_senha.getText());

		func.inserir(f);

	}
}

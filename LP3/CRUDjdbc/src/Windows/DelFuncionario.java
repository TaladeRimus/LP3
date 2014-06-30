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

public class DelFuncionario extends JFrame {

	Funcionario f = new Funcionario(null, null, null, 0);
	FuncionarioDAOBD fDAOBD = new FuncionarioDAOBD();
	
	private JPanel contentPane;
	private JTextField txt_nome;


	/**
	 * Create the frame.
	 */
	public DelFuncionario() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 200, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setBounds(10, 39, 46, 14);
		contentPane.add(lblNome);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(66, 36, 86, 20);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				delete();
				
			}
		});
		btnDeletar.setBounds(44, 96, 89, 23);
		contentPane.add(btnDeletar);
	}
	
	private void delete(){
		
		f.setName(txt_nome.getText());
		
		fDAOBD.remover(f);
		
	}

}

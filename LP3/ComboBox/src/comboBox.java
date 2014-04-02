import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;


public class comboBox extends JFrame {

	private JPanel contentPane;
	private JTextField txt_comp1;
	private JTextField txt_comp2;
	private JTextField txt_result;
	private int a,b;
	private	JComboBox<Object> cb_opcao = new JComboBox<Object>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comboBox frame = new comboBox();
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
	public comboBox() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cb_opcao.setModel(new DefaultComboBoxModel<Object>(new String[] {"Somar", "Subtrair", "Multiplicar", "Dividir"}));
		cb_opcao.setBounds(147, 66, 130, 20);
		contentPane.add(cb_opcao);

		JLabel lbl_comp1 = new JLabel("Complemento 1");
		lbl_comp1.setBounds(37, 11, 108, 14);
		contentPane.add(lbl_comp1);

		txt_comp1 = new JTextField();
		txt_comp1.setToolTipText("");
		txt_comp1.setBounds(147, 8, 130, 20);
		contentPane.add(txt_comp1);
		txt_comp1.setColumns(10);

		JLabel lbl_comp2 = new JLabel("Complemento 2");
		lbl_comp2.setBounds(37, 36, 108, 14);
		contentPane.add(lbl_comp2);

		txt_comp2 = new JTextField();
		txt_comp2.setBounds(147, 33, 130, 20);
		contentPane.add(txt_comp2);
		txt_comp2.setColumns(10);

		JButton btn_calcular = new JButton("Calcular");
		btn_calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcula();
			}
		});
		btn_calcular.setBounds(53, 128, 89, 23);
		contentPane.add(btn_calcular);

		JButton btn_limpar = new JButton("Limpar");
		btn_limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_comp1.setText("");
				txt_comp2.setText("");
				txt_result.setText("");
			}
		});
		btn_limpar.setBounds(152, 128, 89, 23);
		contentPane.add(btn_limpar);

		JLabel lbl_opc = new JLabel("Op\u00E7\u00F5es");
		lbl_opc.setBounds(75, 69, 70, 14);
		contentPane.add(lbl_opc);

		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(63, 101, 82, 14);
		contentPane.add(lblResultado);

		txt_result = new JTextField();
		txt_result.setEditable(false);
		txt_result.setBounds(147, 95, 130, 20);
		contentPane.add(txt_result);
		txt_result.setColumns(10);
	}


	private void calcula(){
		String a = txt_comp1.getText();
		String b = txt_comp2.getText();
		String option = (String) cb_opcao.getSelectedItem();
		
		
		if(option.equals("Somar")){
			int soma = Integer.parseInt(a) + Integer.parseInt(b);
			txt_result.setText("" + soma);
		}
		if(option.equals("Subtrair")){
			int sub = Integer.parseInt(a) - Integer.parseInt(b);
			txt_result.setText(String.valueOf(sub));
		}
		if(option.equals("Multiplicar")){
			int mult = Integer.parseInt(a) * Integer.parseInt(b);
			txt_result.setText(String.valueOf(mult));
		}
		if(option.equals("Dividir")){
			int div = Integer.parseInt(a) / Integer.parseInt(b);
			txt_result.setText(String.valueOf(div));
		}
		
		
	}

}

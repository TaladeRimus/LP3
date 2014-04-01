import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class Calculator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_console;
	private StringBuilder sb = new StringBuilder();
	private StringBuilder sb_b = new StringBuilder();
	private int a;
	private int b;
	private int resultado;
	private int operador;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Calculator.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 255, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txt_console = new JTextField();
		txt_console.setEditable(false);
		txt_console.setBounds(10, 11, 229, 40);
		contentPane.add(txt_console);
		txt_console.setColumns(10);

		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sb.append("7");
				sb_b.append("7");
				txt_console.setText(sb.toString());			
			}
		});
		btn_7.setBounds(10, 62, 45, 45);
		contentPane.add(btn_7);

		JButton btn_8 = new JButton("8");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sb.append("8");
				sb_b.append("8");
				txt_console.setText(sb.toString());	
			}
		});
		btn_8.setBounds(65, 62, 45, 45);
		contentPane.add(btn_8);

		JButton btn_9 = new JButton("9");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sb.append("9");
				sb_b.append("9");
				txt_console.setText(sb.toString());	
			}
		});
		btn_9.setBounds(120, 62, 45, 45);
		contentPane.add(btn_9);

		JButton btn_4 = new JButton("4");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sb.append("4");
				sb_b.append("4");
				txt_console.setText(sb.toString());	
			}
		});
		btn_4.setBounds(10, 118, 45, 45);
		contentPane.add(btn_4);

		JButton btn_5 = new JButton("5");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sb.append("5");
				sb_b.append("5");
				txt_console.setText(sb.toString());	
			}
		});
		btn_5.setBounds(65, 118, 45, 45);
		contentPane.add(btn_5);

		JButton btn_6 = new JButton("6");
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sb.append("6");
				sb_b.append("6");
				txt_console.setText(sb.toString());	
			}
		});
		btn_6.setBounds(120, 118, 45, 45);
		contentPane.add(btn_6);

		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sb.append("1");
				sb_b.append("1");
				txt_console.setText(sb.toString());	
			}
		});
		btn_1.setBounds(10, 174, 45, 45);
		contentPane.add(btn_1);

		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sb.append("2");
				sb_b.append("2");
				txt_console.setText(sb.toString());	
			}
		});
		btn_2.setBounds(65, 174, 45, 45);
		contentPane.add(btn_2);

		JButton btn_3 = new JButton("3");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sb.append("3");
				sb_b.append("3");
				txt_console.setText(sb.toString());	
			}
		});
		btn_3.setBounds(120, 174, 45, 45);
		contentPane.add(btn_3);

		JButton btn_0 = new JButton("0");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sb.append("0");
				sb_b.append("0");
				txt_console.setText(sb.toString());	
			}
		});
		btn_0.setBounds(65, 230, 45, 45);
		contentPane.add(btn_0);

		JButton btn_clear = new JButton("C");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_console.setText(null);
				a = 0;
				b = 0;
				resultado = 0;
				operador = 0;
				sb = new StringBuilder();
			}
		});
		btn_clear.setBounds(10, 230, 45, 45);
		contentPane.add(btn_clear);

		JButton btn_calc = new JButton("=");
		btn_calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcula();
			}
		});
		btn_calc.setBounds(120, 230, 45, 45);
		contentPane.add(btn_calc);

		JButton btn_div = new JButton("/");
		btn_div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(sb.length() != 0){
					a = Integer.parseInt(sb.toString());
					sb.append("/");
					sb_b = new StringBuilder();
					operador = 1;
				}


			}
		});
		btn_div.setBounds(194, 62, 45, 45);
		contentPane.add(btn_div);

		JButton btn_mult = new JButton("*");
		btn_mult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sb.length() != 0){
					a = Integer.parseInt(sb.toString());
					sb.append("*");
					sb_b = new StringBuilder();
					operador = 2;
				}	
			}
		});
		btn_mult.setBounds(194, 120, 45, 45);
		contentPane.add(btn_mult);

		JButton btn_sub = new JButton("-");
		btn_sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sb.length() != 0){
					a = Integer.parseInt(sb.toString());
					sb.append("-");
					sb_b = new StringBuilder();
					operador = 3;
				}	
			}
		});
		btn_sub.setBounds(194, 174, 45, 45);
		contentPane.add(btn_sub);

		JButton btn_soma = new JButton("+");
		btn_soma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sb.length() != 0){
					a = Integer.parseInt(sb.toString());
					sb.append("+");
					sb_b = new StringBuilder();
					operador = 4;
				}			
			}
		});
		btn_soma.setBounds(194, 232, 45, 43);
		contentPane.add(btn_soma);
	}


	private void calcula(){
		if(a != 0){
			b = Integer.parseInt(sb_b.toString());

			switch(operador){
			case 1:
				resultado = a / b;
				txt_console.setText(String.valueOf(resultado));
				break;
			case 2:
				resultado = a * b;
				txt_console.setText(String.valueOf(resultado));
				break;
			case 3:
				resultado = a - b;
				txt_console.setText(String.valueOf(resultado));
				break;
			case 4:
				resultado = a + b;
				txt_console.setText(String.valueOf(resultado));
				break;

			default:
				txt_console.setText("Algo deu errado");
				break;

			}
		}
	}




}

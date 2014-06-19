package Menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Windows.AddCliente;
import Windows.AddFuncionario;
import Windows.AddProdutos;
import Windows.DelCliente;
import Windows.DelFuncionario;
import Windows.DelProdutos;



public class Menu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8149947300039740161L;

	AddCliente ac = new AddCliente();
	AddFuncionario af = new AddFuncionario();
	AddProdutos ap = new AddProdutos();
	DelCliente dc = new DelCliente();
	DelFuncionario df = new DelFuncionario();
	DelProdutos dp = new DelProdutos();
	
	JMenuBar menuBar;
	JMenu mnArquivo;
	JMenuItem mntmAbrir;
	JMenuItem mntmSalvar;
	JMenuItem mntmSair;
	JMenu mnEditar;
	JMenu mnAdicionar;
	JMenuItem mntmClientes;
	JMenuItem mntmFuncionarios;
	JMenuItem mntmProdutos;
	JMenu mnExcluir;
	JMenuItem mntmClientes_1;
	JMenuItem mntmFuncionarios_1;
	JMenuItem mntmProdutos_1;
	JMenu mnRedefinir;
	JMenuItem mntmClientes_2;
	JMenuItem mntmFuncionarios_2;
	JMenuItem mntmProdutos_2;
	JMenu mnHelp;
	JMenuItem mntmAbout;






	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		
		addInstances();
		menuBar();
		actionListener();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private void addInstances(){

		menuBar = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mntmAbrir = new JMenuItem("Abrir");
		mntmSalvar = new JMenuItem("Salvar");
		mntmSair = new JMenuItem("Sair");
		mnEditar = new JMenu("Editar");
		mnAdicionar = new JMenu("Adicionar");
		mntmClientes = new JMenuItem("Clientes");
		
		mntmFuncionarios = new JMenuItem("Funcionarios");
		
		mntmProdutos = new JMenuItem("Produtos");
	
		mnExcluir = new JMenu("Excluir");
		mntmClientes_1 = new JMenuItem("Clientes");
		
		mntmFuncionarios_1 = new JMenuItem("Funcionarios");
		
		mntmProdutos_1 = new JMenuItem("Produtos");
	
		mnRedefinir = new JMenu("Redefinir");
		mntmClientes_2 = new JMenuItem("Clientes");
		mntmFuncionarios_2 = new JMenuItem("Funcionarios");
		mntmProdutos_2 = new JMenuItem("Produtos");
		mnHelp = new JMenu("Help");
		mntmAbout = new JMenuItem("About");


	}

	private void addPanelItems(){


	}

	private void menuBar(){
		
		setJMenuBar(menuBar);

		menuBar.add(mnArquivo);

		mnArquivo.add(mntmAbrir);
		mnArquivo.add(mntmSalvar);
		mnArquivo.add(mntmSair);
		menuBar.add(mnEditar);

		mnEditar.add(mnAdicionar);
		mnAdicionar.add(mntmClientes);
		mnAdicionar.add(mntmFuncionarios);
		mnAdicionar.add(mntmProdutos);

		mnEditar.add(mnExcluir);
		mnExcluir.add(mntmClientes_1);
		mnExcluir.add(mntmFuncionarios_1);
		mnExcluir.add(mntmProdutos_1);

		mnEditar.add(mnRedefinir);
		mnRedefinir.add(mntmClientes_2);
		mnRedefinir.add(mntmFuncionarios_2);
		mnRedefinir.add(mntmProdutos_2);

		menuBar.add(mnHelp);
		mnHelp.add(mntmAbout);



	}

	private void actionListener(){
		
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ac.main(null);
				
				
			}
		});
		
		mntmFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				af.main(null);
				
			}
		});
		
		mntmClientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dc.main(null);
				
			}
		});
		
		mntmFuncionarios_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				df.main(null);
				
			}
		});
		
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ap.main(null);
				
			}
		});
		
		mntmProdutos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dp.main(null);
				
			}
		});
		
		
		
	}
	
	
}

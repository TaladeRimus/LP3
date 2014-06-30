package Menu;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import Database.DatabaseConnection;
import Model.Funcionario;
import Tables.TabelaFuncionario;
import Tables.TabelaVendaData;
import Tables.TabelaVendaFunc;
import Tables.TabelaVendas;
import Windows.AddCliente;
import Windows.AddFuncionario;
import Windows.AddProdutos;
import Windows.ClienteTable;
import Windows.DelCliente;
import Windows.DelFuncionario;
import Windows.DelProdutos;
import Windows.FuncionarioTable;
import Windows.ProdutosTable;



public class MenuFunc extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8149947300039740161L;

	
	DatabaseConnection db = new DatabaseConnection();
	
	Funcionario f = new Funcionario();
	
	private PreparedStatement cmd;
	private ResultSet result;
	
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmAbrir;
	private JMenuItem mntmSalvar;
	private JMenuItem mntmSair;
	private JMenu mnEditar;
	private JMenu mnAdicionar;
	private JMenuItem mntmClientes;
	private JMenuItem mntmFuncionarios;
	private JMenuItem mntmProdutos;
	private JMenu mnExcluir;
	private JMenuItem mntmClientes_1;
	private JMenuItem mntmFuncionarios_1;
	private JMenuItem mntmProdutos_1;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JMenuItem mntmProdutos_3;


	private JToggleButton tglbtn_vendaPorCliente;
	private JToggleButton tglbtn_VendaPorFuncionario;
	private JToggleButton tglbtn_VendaPorMes;
	private JPanel contentPane;
	private TabelaVendas tabelaVendaCliente;
	private TabelaVendaFunc tabelaVendaFunc;
	private TabelaVendaData tabelaVendaData;
	private JMenu mnVisualizar;
	private JMenuItem mntmClientes_3;
	private JMenuItem mntmFuncionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFunc frame = new MenuFunc();
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
	public MenuFunc() {
		setResizable(false);
		
		linkFunc();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);

		
		
		
		addInstances();
		addPanelItems();
		setPanelItems();
		menuBar();
		actionListener();
		
	
	}
	


	private void addInstances(){

		contentPane = new JPanel();
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
		mnHelp = new JMenu("Help");
		mntmAbout = new JMenuItem("About");
		
		tglbtn_vendaPorCliente = new JToggleButton("Venda Por Cliente");
		tglbtn_VendaPorFuncionario = new JToggleButton("Venda Por Funcionario");
		tglbtn_VendaPorMes = new JToggleButton("Vendas Por Mes");
		
		tabelaVendaCliente = new TabelaVendas();
		tabelaVendaFunc = new TabelaVendaFunc();
		tabelaVendaData = new TabelaVendaData();

	}
	
	private void setPanelItems(){
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tglbtn_vendaPorCliente.setBounds(20, 207, 141, 23);
		tglbtn_VendaPorFuncionario.setBounds(171, 207, 162, 23);
		tglbtn_VendaPorMes.setBounds(343, 207, 141, 23);
		
		
		tabelaVendaCliente.setBounds(10, 11, 474, 185);
		tabelaVendaCliente.setVisible(false);
		
		tabelaVendaFunc.setBounds(10, 11, 474, 185);
		tabelaVendaFunc.setVisible(false);
		
		tabelaVendaData.setBounds(10, 11, 474, 185);
		tabelaVendaData.setVisible(false);
		
	
	}
	
	private void addPanelItems(){
		
		contentPane.add(tglbtn_vendaPorCliente);
		
		contentPane.add(tglbtn_VendaPorFuncionario);
		
		contentPane.add(tglbtn_VendaPorMes);
		
		contentPane.add(tabelaVendaCliente);
		
		contentPane.add(tabelaVendaFunc);
		
		contentPane.add(tabelaVendaData);
	}

		
	private void menuBar(){
		
		setJMenuBar(menuBar);

		menuBar.add(mnArquivo);

		mnArquivo.add(mntmAbrir);
		mnArquivo.add(mntmSalvar);
		
		mnVisualizar = new JMenu("Visualizar");
		mnArquivo.add(mnVisualizar);
		
		mntmClientes_3 = new JMenuItem("Clientes");

		mnVisualizar.add(mntmClientes_3);
		
		mntmFuncionario = new JMenuItem("Funcionario");
	
		mnVisualizar.add(mntmFuncionario);
		
		mntmProdutos_3 = new JMenuItem("Produtos");

		mnVisualizar.add(mntmProdutos_3);
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

		menuBar.add(mnHelp);
		mnHelp.add(mntmAbout);



	}

	private void actionListener(){
		
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new AddCliente();
				
				
				
				
			}
		});
		
		mntmFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddFuncionario();
				
				
				
			}
		});
		
		mntmClientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DelCliente();
			
				
			}
		});
		
		mntmFuncionarios_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DelFuncionario();
				
				
			}
		});
		
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddProdutos();
				
				
			}
		});
		
		mntmProdutos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DelProdutos();
				
				
			}
		});
		
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
				
			}
		});
		
		tglbtn_vendaPorCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (tglbtn_VendaPorFuncionario.isSelected()) {
					
					tglbtn_VendaPorFuncionario.setSelected(false);
					
				}
				
				else if ( tglbtn_VendaPorMes.isSelected() ) {
					
					tglbtn_VendaPorMes.setSelected(false);
					
				}
				
				else { 
					
					tabelaVendaFunc.setVisible(false);
					tabelaVendaData.setVisible(false);
					tabelaVendaCliente.setVisible(true);
					
				}
				
			}
		});
		
		
		tglbtn_VendaPorFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if (tglbtn_vendaPorCliente.isSelected()) {
					
					tglbtn_vendaPorCliente.setSelected(false);
					
				}
				
				else if ( tglbtn_VendaPorMes.isSelected() ) {
					
					tglbtn_VendaPorMes.setSelected(false);
					
				}
				
				else { 
					
					tabelaVendaCliente.setVisible(false);
					tabelaVendaData.setVisible(false);					
					tabelaVendaFunc.setVisible(true);
					
			
				}
				
			}
		});
		
		tglbtn_VendaPorMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (tglbtn_VendaPorFuncionario.isSelected()) {
					
					tglbtn_VendaPorFuncionario.setSelected(false);
					
				}
				
				else if ( tglbtn_vendaPorCliente.isSelected() ) {
					
					tglbtn_vendaPorCliente.setSelected(false);
					
				}
				
				else { 
					
					tabelaVendaCliente.setVisible(false);
					tabelaVendaFunc.setVisible(false);					
					tabelaVendaData.setVisible(true);					
					
				}
				
			}
		});
		
		
		mntmClientes_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new ClienteTable();
				
				
			}
		});
		
		mntmProdutos_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new ProdutosTable();
			}
		});
		
		mntmFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new FuncionarioTable();
				
			}
		});
		
	}
	
	private void linkFunc(){

		LogIn l = new LogIn();
	
		System.out.println(l.getKeepLog());
			
			try {

				cmd = db.startConnectionPS("SELECT * FROM FUNCIONARIO WHERE nome = " + "'" +l.getKeepLog() + "'");
				result = cmd.executeQuery();
				
				
				while ( result.next() ) {
					
						f.setName(result.getString("NOME"));
						f.setEmail(result.getString("EMAIL"));

				}
					
				
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			
			}
			
		

	}
}

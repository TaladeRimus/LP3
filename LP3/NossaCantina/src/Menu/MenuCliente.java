package Menu;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Database.DatabaseConnection;
import Model.Cliente;
import Model.Funcionario;
import Model.Produtos;
import Model.Venda;
import Tables.TabelaProdutos;
import VendaDAO.VendaDAOBD;

public class MenuCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PreparedStatement cmd;
	private ResultSet result;
	
	DatabaseConnection db = new DatabaseConnection();
	
	Cliente c = new Cliente();
	
	
	Funcionario f = new Funcionario();
	
	Produtos p = new Produtos();
	
	
	VendaDAOBD vDAOBD = new VendaDAOBD();
	Venda v = new Venda();
	
	
	TabelaProdutos tabela = new TabelaProdutos();
	
	private JPanel contentPane;
	private JTextField txt_valor;
	private JButton btnFinalizarCompra;
	private JLabel lblValor;
	private JLabel lblSaldo;
	private JTextField txt_saldo;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCliente frame = new MenuCliente();
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
	public MenuCliente() {
	
		linkCliente();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		addInstances();
		addPanelItems();
		setPanelItems();
		addActionListener();


	}

	private void addInstances(){
		btnFinalizarCompra = new JButton("Finalizar Compra");
		lblValor = new JLabel("Valor: ");
		lblSaldo = new JLabel("Saldo : ");
		txt_saldo = new JTextField();
		txt_valor = new JTextField();

	}

	private void addPanelItems(){
		contentPane.add(btnFinalizarCompra);
		contentPane.add(lblSaldo);
		contentPane.add(txt_valor);
		contentPane.add(txt_saldo);
		contentPane.add(tabela);


	}

	private void setPanelItems(){

		btnFinalizarCompra.setBounds(99, 209, 146, 23);

		lblValor.setBounds(56, 148, 46, 14);
		contentPane.add(lblValor);

		lblSaldo.setBounds(56, 180, 46, 14);


		txt_valor.setEditable(false);
		txt_valor.setBounds(120, 145, 86, 20);
		txt_valor.setColumns(10);

		
		txt_saldo.setEditable(false);
		txt_saldo.setBounds(120, 177, 86, 20);
		txt_saldo.setColumns(10);
		
		
		tabela.setBounds(31, 12, 294, 121);


	}
	

	private void addActionListener(){

		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				int row = tabela.getTabela().getSelectedRow(); // pega a linha selecionada
				
				int codProd = tabela.retornaCod(row); // retorna o codigo da linha selecionada 
				
				double preco = tabela.retornaPreco(row); // retorna o preco da linha selecinada
				
				
				
				c.setValorCompra(preco);
				f.setId(1);
				p.setId(codProd);
				
							
				txt_valor.setText(String.valueOf(preco));
				txt_saldo.setText(String.valueOf(c.getSaldo()));
				
				v.setIdCliente(c.getId());
				v.setIdFunc(f.getId());
				v.setIdProd(p.getId());
				
				vDAOBD.realizaVenda(v);
				
				
				atualizaSaldo();
				

				
				
			}
		});


	}
	
	
	private void atualizaSaldo(){
		
		double valorCompra = c.getSaldo() - c.getValorCompra(); // define o saldo apos a compra
		
		try {
			
			cmd = db.startConnectionPS("UPDATE CLIENTE SET saldo = ? WHERE nome = ?");
			
			cmd.setDouble(1, valorCompra );
			
			cmd.setString(2, c.getName());

			cmd.executeUpdate();
			
			c.setSaldo(valorCompra);
		
		} catch (ClassNotFoundException | SQLException e1) {

			e1.printStackTrace();
		
		}
		
		
		
	}
	

	private void linkCliente(){

		LogIn l = new LogIn();
		
		System.out.println(l.getKeepLog());
		
		try {
			
			cmd = db.startConnectionPS("SELECT * FROM CLIENTE WHERE nome = " + "'" + l.getKeepLog() + "'");
			
			result = cmd.executeQuery();
			
			while(result.next()){
				
				c.setName(result.getString("NOME"));
				c.setEmail(result.getString("EMAIL"));
				c.setSaldo(result.getInt("SALDO"));
				c.setId(result.getInt("IDCLIENTE"));
				
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
		}

		
	}
	

}

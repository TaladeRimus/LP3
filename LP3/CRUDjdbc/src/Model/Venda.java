package Model;
public class Venda {
	
	private String dVenda;
	private int idCliente;
	private int idFunc;
	private int idProd;
	private int idVenda;
	
	public Venda(String dVenda, int idCliente, int idFunc, int idProd) {
		
		this.dVenda = dVenda;
		this.idCliente = idCliente;
		this.idFunc = idFunc;
		this.idProd = idProd;
		
	}
	
	public Venda(int idVenda, String dVenda, int idProd, int idCliente, int idFunc){
		
		this.setIdVenda(idVenda);
		this.dVenda = dVenda;
		this.idCliente = idCliente;
		this.idFunc = idFunc;
		this.idProd = idProd;
		
	}

	public Venda() {

	}

	public String getdVenda() {
		return dVenda;
	}

	public void setdVenda(String dVenda) {
		this.dVenda = dVenda;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdFunc() {
		return idFunc;
	}

	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
	@Override
	public String toString() {
		return "Venda [dVenda=" + dVenda + ", idCliente=" + idCliente
				+ ", idFunc=" + idFunc + "]";
	}
	
	
}

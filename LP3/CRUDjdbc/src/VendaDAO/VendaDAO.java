package VendaDAO;

import java.util.List;

import Model.Venda;

public interface VendaDAO {

	
	public Venda realizaVenda(Venda venda);
	public void removeVenda(Venda venda);
	public List<Venda> listarTodasVendas();
	
}

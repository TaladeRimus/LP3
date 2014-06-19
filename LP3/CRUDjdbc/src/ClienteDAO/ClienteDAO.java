package ClienteDAO;

import java.util.List;
import Model.Cliente;

public interface ClienteDAO {
	

	public void inserir(Cliente cliente);
	public void remover(Cliente cliente);
	public void atualizar(Cliente clienet);
	public List<Cliente> getTodosClientes();
	public List<Cliente> getClientesBuscandoPorNome(String nome);


}

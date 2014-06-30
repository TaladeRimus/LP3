package FuncionarioDAO;

import java.util.List;

import Model.Funcionario;

public interface FuncionarioDAO {

	public Funcionario inserir(Funcionario funcionario);
	public void remover(Funcionario funcionario);
	public void atualizar(Funcionario funcionario);
	public List<Funcionario> getTodosFuncionarios();
	public List<Funcionario> getFuncionariosBuscandoPorNome(String nome);
		
}

package ProdutosDAO;

import java.util.List;

import Model.Produtos;

public interface ProdutosDAO {
	
	public Produtos inserir(Produtos produtos);
	public void remover(Produtos produtos);
	public void atualizar(Produtos produtos);
	public List<Produtos> getTodosProdutos();
	public List<Produtos> getProdutosBuscandoPorCategoria(String categoria);
		
	

}

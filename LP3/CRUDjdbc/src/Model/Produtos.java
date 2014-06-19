package Model;

public class Produtos {
	
	
	String nome, categoria;
	double preco;
	
	public Produtos(String nome, String categoria, double preco){
		
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double d) {
		this.preco = d;
	}
	
	
	
	
	
	

}

package Model;

public class Produtos {
	
	
	String nome, categoria;
	double preco;
	int id, qtd;
	
	public Produtos(String nome, String categoria, double preco, int id, int qtd){
		
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.id = id;
		this.qtd = qtd;
		
	}

	public Produtos() {

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	
	
	
	
	
	

}

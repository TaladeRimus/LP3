package Model;

public class Cliente {
	
	
	String name, email, senha;
	int id;
	double saldo, valorCompra;
	
	public Cliente(String name, String email, String senha, double saldo, int id) {
		
		this.name = name;
		this.email = email;
		this.senha = senha;
		this.saldo = saldo;
		this.id = id;
		
	}
	
	public Cliente () {
		
		
	}

	public Cliente(String name, String email, double saldo, int id) {
		
		this.name = name;
		this.email = email;
		this.saldo = saldo;
		this.id = id;
	
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double valorCompra) {
		this.saldo = valorCompra;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha){
		this.senha = senha;
	}
	
	public int getId() {
		return id;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cliente [name=" + name + ", email=" + email + "]";
	}


	
	
	
	
	
}

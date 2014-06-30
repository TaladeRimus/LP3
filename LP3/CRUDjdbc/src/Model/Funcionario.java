package Model;

public class Funcionario {
	
	String name, email, senha;
	int id;
	
	public Funcionario(String name, String email, String senha, int id){
		
		this.name = name;
		this.email = email;
		this.senha = senha;
		this.id = id;
		
	}
	
	
	public Funcionario() {
	
	}


	public Funcionario(String name, String email, int id) {

		this.name = name;
		this.email = email;
		this.id = id;
		
		
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Funcionario [name=" + name + ", email=" + email + "]";
	}
	
	
	
	
	
	

}

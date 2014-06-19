package Model;

public class Funcionario {
	
	String name, email;
	int codPermissao;
	
	public Funcionario(String name, String email, int codPermissao){
		
		this.name = name;
		this.email = email;
		this.codPermissao = codPermissao;
		
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

	public int getCodPermissao() {
		return codPermissao;
	}



	public void setCodPermissao(int codPermissao) {
		this.codPermissao = codPermissao;
	}



	@Override
	public String toString() {
		return "Funcionario [name=" + name + ", email=" + email + "]";
	}
	
	
	
	
	
	

}

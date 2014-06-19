package Model;

public class Cliente {
	
	
	String name, email;
	int codPermissao;
	
	public Cliente(String name, String email, int codPermissao) {
		
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

	public int getId() {
		return codPermissao;
	}

	public void setId(int id) {
		this.codPermissao = id;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [name=" + name + ", email=" + email + ", id=" + codPermissao
				+ "]";
	}

	
	
	
	
	
}

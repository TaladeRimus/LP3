package CRUD;

public class Pessoa {
	
	String name;
	int age;
	int id;
	
	public Pessoa(int id, String nome, int  idade) {
		
		this.id = id;
		this.name = nome;
		this.age = idade;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	public int getIdade() {
		return age;
	}

	public void setIdade(int idade) {
		this.age = idade;
	}
	
	
	
}

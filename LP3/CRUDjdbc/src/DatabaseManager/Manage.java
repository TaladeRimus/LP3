package DatabaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Connection.ConnectJDBC;

public class Manage {


	static ConnectJDBC connectDB = new ConnectJDBC();
	static Connection connect;
	static Scanner sc = new Scanner(System.in);



	public void insert(){

		String name;
		String age;
		String cmd;

		try {

			connect = connectDB.connection();

			int id = 3;

			Statement stmt = connect.createStatement();

			System.out.print("Nome: ");
			name = sc.next();

			System.out.print("Idade: ");
			age = sc.next();

			cmd = "INSERT INTO pessoa VALUES (" + id + "," + "'" + name + "'" + "," +  "'" + age + "'" + ")";

			int affectedLines = stmt.executeUpdate(cmd);
			System.out.print("Linhas Afetadas: " + affectedLines);

		} catch (Exception e) {

			System.err.println("Database error");

			e.printStackTrace();

		}


	}

	public void delete(){

		String name, age, cmd;
		int id;

		try {

			connect = connectDB.connection();

			Statement stmt = connect.createStatement();

			System.out.println("Digite o nome para deletar");
			name = sc.next();


			cmd = "DELETE FROM pessoa WHERE nome = " + "'" + name + "'";

			int affectedLines = stmt.executeUpdate(cmd);
			System.out.print("Affected lines: " + affectedLines);


		} catch (Exception e) {

			System.err.println("Database error");

			e.printStackTrace();

		}

	}

	public void update(){

		String name , newName;
		String cmd;

		try {

			connect = connectDB.connection();

			Statement stmt = connect.createStatement();

			System.out.print("Digite o nome da pessoa para trocar: ");
			name = sc.next();

			System.out.print("Digite o novo nome: ");
			newName = sc.next();

			cmd = "UPDATE pessoa SET nome = " + "'" + newName + "'" + " WHERE nome = " + "'" + name + "'";

			int affectedLines = stmt.executeUpdate(cmd);
			System.out.print("Affected lines: " + affectedLines);


		} catch (Exception e) {

			System.err.println("Database error");

			e.printStackTrace();

		}

	}

	public void searchPeople(){

		String name, cmd;

		try {

			connect = connectDB.connection();

			Statement stmt = connect.createStatement();

			System.out.print("Digite o nome para pesquisa: ");
			name = sc.next();

			ResultSet resultado = stmt.executeQuery(("SELECT * FROM PESSOA WHERE nome = " + "'" + name + "'"));

			if ( resultado.next() ) {

				System.out.print("Quantidade encontrada para " + name + ": " + resultado.getRow());
			}

			else {

				System.err.println("Name not found");

			}


		} catch (Exception e) {

			System.err.println("Database error");

			e.printStackTrace();

		}


	}

	public void returnPeople(){

		try {

			connect = connectDB.connection();

			Statement stmt = connect.createStatement();
			
			

			ResultSet resultado = stmt.executeQuery(("SELECT * FROM PESSOA"));

			if( resultado.next() ) {
				
				while( resultado.next() ) {
				
			

					System.out.print(resultado.getInt("id"));
					System.out.print(resultado.getString("nome"));
					System.out.println(resultado.getString("idade"));

				}

				
			}
			
			else {
				
				System.err.println("Could not find data");
				
			}



		} catch (Exception e) {

			System.err.println("Database error");

			e.printStackTrace();

		}


	}

	public static void main(String[] args) throws SQLException {
		Manage m = new Manage();

		//m.insert();
		m.returnPeople();
	}
}

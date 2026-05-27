package conexao;

/* Classe apenas pre- definida temos que corrir as alterações conforme o banco de dados*/
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe responsável por criar conexão com o banco de dados.
 */
public class Conexao {

	// URL do banco de dados
	private static final String URL = "jdbc:mysql://localhost:3306/loja_veiculos";

	// Usuário do MySQL
	private static final String USUARIO = "root";

	// Senha do MySQL
	private static final String SENHA = "";

	/**
	 * Método responsável por abrir conexão com o banco.
	 */
	public static Connection conectar() {

		try {

			return DriverManager.getConnection(URL, USUARIO, SENHA);

		} catch (Exception e) {

			System.out.println("Erro ao conectar com banco.");
			e.printStackTrace();

			return null;
		}
	}
}
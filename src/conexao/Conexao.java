package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe responsável pela conexão
 * com o banco de dados MySQL.
 */
public class Conexao {

    // URL do banco
    private static final String URL =
            "jdbc:mysql://localhost:3306/loja_veiculos";

    // Usuário do banco
    private static final String USUARIO =
            "root";

    // Senha do banco
    private static final String SENHA =
            "";

    /**
     * Método responsável por abrir
     * conexão com o banco.
     */
    public static Connection conectar() {

        try {

            // Retorna conexão aberta
            return DriverManager.getConnection(
                    URL,
                    USUARIO,
                    SENHA
            );

        } catch (Exception e) {

            System.out.println(
                    "Erro ao conectar com banco.");

            e.printStackTrace();

            return null;
        }
    }
}
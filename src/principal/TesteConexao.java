package principal;

import java.sql.Connection;

import conexao.Conexao;

/**
 * Classe usada apenas
 * para testar conexão
 * com banco de dados.
 */
public class TesteConexao {

    public static void main(String[] args) {

        // Abrindo conexão
        Connection conexao =
                Conexao.conectar();

        // Verificando conexão
        if (conexao != null) {

            System.out.println(
                    "Conexão realizada com sucesso!"
            );

        } else {

            System.out.println(
                    "Erro ao conectar."
            );
        }
    }
}
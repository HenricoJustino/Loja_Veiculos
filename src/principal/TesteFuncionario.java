package principal;

import dao.FuncionarioDAO;
import modelo.Funcionario;

/**
 * Classe usada para testar
 * cadastro de funcionário.
 */
public class TesteFuncionario {

    public static void main(String[] args) {

        // Criando funcionário
        Funcionario funcionario =
                new Funcionario();

        funcionario.setNome("Carlos Silva");
        funcionario.setCpf("98765432100");
        funcionario.setTelefone("(64)98888-8888");
        funcionario.setEmail("carlos@email.com");

        // DAO
        FuncionarioDAO funcionarioDAO =
                new FuncionarioDAO();

        // Salvando no banco
        funcionarioDAO.salvar(funcionario);

        System.out.println(
                "Funcionário cadastrado com sucesso!"
        );
    }
}
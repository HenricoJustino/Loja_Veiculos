package principal;

import dao.ClienteDAO;
import modelo.Cliente;

/**
 * Classe usada para testar
 * cadastro de cliente.
 */
public class TesteCliente {

    public static void main(String[] args) {

        // Criando cliente
        Cliente cliente = new Cliente();

        cliente.setNome("João Silva");
        cliente.setCpf("12345678900");
        cliente.setTelefone("(64)99999-9999");
        cliente.setEmail("joao@email.com");

        // DAO
        ClienteDAO clienteDAO =
                new ClienteDAO();

        // Salvando no banco
        clienteDAO.salvar(cliente);

        System.out.println(
                "Cliente cadastrado com sucesso!"
        );
    }
}
package servico;

import java.util.List;

import dao.ClienteDAO;
import modelo.Cliente;

/**
 * Classe responsável pelas regras
 * de negócio relacionadas ao cliente.
 */
public class ClienteServico {

    // Objeto DAO
    private ClienteDAO clienteDAO =
            new ClienteDAO();

    /**
     * Salvar cliente.
     */
    public void salvar(Cliente cliente) {

        clienteDAO.salvar(cliente);
    }

    /**
     * Listar clientes.
     */
    public List<Cliente> listar() {

        return clienteDAO.listar();
    }

    /**
     * Atualizar cliente.
     */
    public void atualizar(Cliente cliente) {

        clienteDAO.atualizar(cliente);
    }

    /**
     * Excluir cliente.
     */
    public void excluir(Long id) {

        clienteDAO.excluir(id);
    }
}
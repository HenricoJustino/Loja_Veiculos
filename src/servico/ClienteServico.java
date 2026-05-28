package servico;

import java.util.List;

import dao.ClienteDAO;
import modelo.Cliente;

/**
 * Classe responsável pelas
 * regras de negócio do cliente.
 */
public class ClienteServico {

	// Objeto DAO
	private ClienteDAO clienteDAO =
			new ClienteDAO();

	/**
	 * Método responsável
	 * por validar e salvar cliente.
	 */
	public void salvar(Cliente cliente) {

		// =========================
		// VALIDAÇÕES
		// =========================

		// Verifica nome vazio
		if (cliente.getNome() == null ||
				cliente.getNome().trim().isEmpty()) {

			System.out.println(
					"Nome obrigatório."
			);

			return;
		}

		// Verifica CPF vazio
		if (cliente.getCpf() == null ||
				cliente.getCpf().trim().isEmpty()) {

			System.out.println(
					"CPF obrigatório."
			);

			return;
		}

		// Verifica telefone vazio
		if (cliente.getTelefone() == null ||
				cliente.getTelefone().trim().isEmpty()) {

			System.out.println(
					"Telefone obrigatório."
			);

			return;
		}

		// =========================
		// SALVANDO
		// =========================

		clienteDAO.salvar(cliente);

		System.out.println(
				"Cliente salvo com sucesso!"
		);
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
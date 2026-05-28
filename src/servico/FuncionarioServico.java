package servico;

import java.util.List;

import dao.FuncionarioDAO;
import modelo.Funcionario;

/**
 * Classe responsável pelas
 * regras de negócio do funcionário.
 */
public class FuncionarioServico {

	// Objeto DAO
	private FuncionarioDAO funcionarioDAO =
			new FuncionarioDAO();

	/**
	 * Método responsável
	 * por validar e salvar funcionário.
	 */
	public void salvar(Funcionario funcionario) {

		// =========================
		// VALIDAÇÕES
		// =========================

		// Verifica nome vazio
		if (funcionario.getNome() == null ||
				funcionario.getNome().trim().isEmpty()) {

			System.out.println(
					"Nome obrigatório."
			);

			return;
		}

		// Verifica CPF vazio
		if (funcionario.getCpf() == null ||
				funcionario.getCpf().trim().isEmpty()) {

			System.out.println(
					"CPF obrigatório."
			);

			return;
		}

		// Verifica telefone vazio
		if (funcionario.getTelefone() == null ||
				funcionario.getTelefone().trim().isEmpty()) {

			System.out.println(
					"Telefone obrigatório."
			);

			return;
		}

		// Verifica email vazio
		if (funcionario.getEmail() == null ||
				funcionario.getEmail().trim().isEmpty()) {

			System.out.println(
					"Email obrigatório."
			);

			return;
		}

		// =========================
		// SALVANDO
		// =========================

		funcionarioDAO.salvar(funcionario);

		System.out.println(
				"Funcionário salvo com sucesso!"
		);
	}

	/**
	 * Listar funcionários.
	 */
	public List<Funcionario> listar() {

		return funcionarioDAO.listar();
	}

	/**
	 * Atualizar funcionário.
	 */
	public void atualizar(Funcionario funcionario) {

		funcionarioDAO.atualizar(funcionario);
	}

	/**
	 * Excluir funcionário.
	 */
	public void excluir(Long id) {

		funcionarioDAO.excluir(id);
	}
}
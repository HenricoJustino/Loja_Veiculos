package servico;

import java.util.List;

import dao.FuncionarioDAO;
import modelo.Funcionario;

/**
 * Classe responsável pelas regras de negócio relacionadas ao funcionário.
 */
public class FuncionarioServico {

	// Objeto DAO
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	/**
	 * Salvar funcionário.
	 */
	public void salvar(Funcionario funcionario) {

		funcionarioDAO.salvar(funcionario);
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
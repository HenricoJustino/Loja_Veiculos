package servico;

import java.util.List;

import dao.VeiculoDAO;
import modelo.Veiculo;

/**
 * Classe responsável pelas regras de negócio relacionadas ao veículo.
 */
public class VeiculoServico {

	// Objeto DAO
	private VeiculoDAO veiculoDAO = new VeiculoDAO();

	/**
	 * Salvar veículo.
	 */
	public void salvar(Veiculo veiculo) {

		// Futuramente:
		// validações podem ficar aqui

		veiculoDAO.salvar(veiculo);
	}

	/**
	 * Listar veículos.
	 */
	public List<Veiculo> listar() {

		return veiculoDAO.listar();
	}

	/**
	 * Atualizar veículo.
	 */
	public void atualizar(Veiculo veiculo) {

		veiculoDAO.atualizar(veiculo);
	}

	/**
	 * Excluir veículo.
	 */
	public void excluir(Long id) {

		veiculoDAO.excluir(id);
	}
}
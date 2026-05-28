package servico;

import java.util.List;

import dao.VeiculoDAO;
import modelo.Veiculo;

/**
 * Classe responsável pelas
 * regras de negócio relacionadas
 * ao veículo.
 */
public class VeiculoServico {

	// Objeto DAO
	private VeiculoDAO veiculoDAO =
			new VeiculoDAO();

	/**
	 * Método responsável por:
	 * 
	 * - validar dados
	 * - salvar veículo no banco
	 */
	public void salvar(Veiculo veiculo) {

		// =========================
		// VALIDAÇÕES
		// =========================

		// Verifica se marca está vazia
		if (veiculo.getMarca() == null ||
				veiculo.getMarca().trim().isEmpty()) {

			System.out.println(
					"A marca é obrigatória."
			);

			return;
		}

		// Verifica se modelo está vazio
		if (veiculo.getModelo() == null ||
				veiculo.getModelo().trim().isEmpty()) {

			System.out.println(
					"O modelo é obrigatório."
			);

			return;
		}

		// Verifica se preço é inválido
		if (veiculo.getPreco() <= 0) {

			System.out.println(
					"Preço inválido."
			);

			return;
		}

		// Verifica se ano é inválido
		if (veiculo.getAno() < 1900) {

			System.out.println(
					"Ano inválido."
			);

			return;
		}

		// =========================
		// SALVANDO NO BANCO
		// =========================

		veiculoDAO.salvar(veiculo);

		System.out.println(
				"Veículo salvo com sucesso!"
		);
	}

	/**
	 * Método responsável
	 * por listar veículos.
	 */
	public List<Veiculo> listar() {

		return veiculoDAO.listar();
	}

	/**
	 * Método responsável
	 * por atualizar veículo.
	 */
	public void atualizar(Veiculo veiculo) {

		veiculoDAO.atualizar(veiculo);
	}

	/**
	 * Método responsável
	 * por excluir veículo.
	 */
	public void excluir(Long id) {

		veiculoDAO.excluir(id);
	}
}
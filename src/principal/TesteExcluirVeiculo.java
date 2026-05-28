package principal;

import dao.VeiculoDAO;

/**
 * Classe usada para testar
 * exclusão de veículo.
 */
public class TesteExcluirVeiculo {

    public static void main(String[] args) {

        // DAO
        VeiculoDAO veiculoDAO =
                new VeiculoDAO();

        // Excluindo veículo de ID 1
        veiculoDAO.excluir(1L);

        System.out.println(
                "Veículo excluído com sucesso!"
        );
    }
}
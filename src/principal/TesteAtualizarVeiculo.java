package principal;

import dao.VeiculoDAO;
import modelo.Veiculo;

/**
 * Classe usada para testar
 * atualização de veículo.
 */
public class TesteAtualizarVeiculo {

    public static void main(String[] args) {

        // Criando objeto
        Veiculo veiculo = new Veiculo();

        // ID do veículo existente
        veiculo.setId(1L);

        // Novos dados
        veiculo.setMarca("Honda");
        veiculo.setModelo("Civic");
        veiculo.setCor("Preto");
        veiculo.setAno(2022);
        veiculo.setPreco(150000.0);
        veiculo.setStatus("Disponível");

        // DAO
        VeiculoDAO veiculoDAO =
                new VeiculoDAO();

        // Atualizando
        veiculoDAO.atualizar(veiculo);

        System.out.println(
                "Veículo atualizado com sucesso!"
        );
    }
}
package principal;

import dao.VeiculoDAO;
import modelo.Veiculo;

/**
 * Classe usada para testar
 * inserção de veículo no banco.
 */
public class TesteVeiculo {

    public static void main(String[] args) {

        // Criando objeto veículo
        Veiculo veiculo = new Veiculo();

        veiculo.setMarca("Toyota");
        veiculo.setModelo("Corolla");
        veiculo.setCor("Prata");
        veiculo.setAno(2020);
        veiculo.setPreco(120000.0);
        veiculo.setStatus("Disponível");

        // Criando DAO
        VeiculoDAO veiculoDAO =
                new VeiculoDAO();

        // Salvando no banco
        veiculoDAO.salvar(veiculo);

        System.out.println(
                "Veículo cadastrado com sucesso!"
        );
    }
}
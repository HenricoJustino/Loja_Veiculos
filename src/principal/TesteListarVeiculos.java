package principal;

import java.util.List;

import dao.VeiculoDAO;
import modelo.Veiculo;

/**
 * Classe usada para testar
 * listagem de veículos.
 */
public class TesteListarVeiculos {

    public static void main(String[] args) {

        // Criando DAO
        VeiculoDAO veiculoDAO =
                new VeiculoDAO();

        // Recebendo lista do banco
        List<Veiculo> lista =
                veiculoDAO.listar();

        // Percorrendo lista
        for (Veiculo veiculo : lista) {

            System.out.println(
                    "ID: " + veiculo.getId()
            );

            System.out.println(
                    "Marca: " + veiculo.getMarca()
            );

            System.out.println(
                    "Modelo: " + veiculo.getModelo()
            );

            System.out.println(
                    "Cor: " + veiculo.getCor()
            );

            System.out.println(
                    "Ano: " + veiculo.getAno()
            );

            System.out.println(
                    "Preço: " + veiculo.getPreco()
            );

            System.out.println(
                    "Status: " + veiculo.getStatus()
            );

            System.out.println(
                    "---------------"
            );
        }
    }
}
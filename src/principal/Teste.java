package principal;

import java.util.Date;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Veiculo;
import modelo.Venda;

/**
 * Classe principal do sistema.
 * 
 * Utilizada para testes iniciais
 * das entidades e relacionamentos.
 */
public class Teste {

    public static void main(String[] args) {

        // =========================
        // TESTE CLIENTE
        // =========================

        Cliente cliente = new Cliente(
                1L,
                "Rafael",
                "123.456.789-00",
                "(64)99999-9999",
                "rafael@email.com"
        );

        // =========================
        // TESTE FUNCIONARIO
        // =========================

        Funcionario funcionario = new Funcionario(
                1L,
                "Carlos",
                "987.654.321-00",
                "(64)98888-8888",
                "carlos@email.com"
        );

        // =========================
        // TESTE VEICULO
        // =========================

        Veiculo veiculo = new Veiculo(
                1L,
                "Toyota",
                "Corolla",
                "Prata",
                2020,
                95000.0,
                "DISPONIVEL"
        );

        // =========================
        // TESTE VENDA
        // =========================

        Venda venda = new Venda(
                1L,
                cliente,
                funcionario,
                veiculo,
                new Date(),
                "Financiamento",
                95000.0
        );

        // =========================
        // EXIBINDO RESULTADOS
        // =========================

        System.out.println("=== TESTE VENDA ===");

        System.out.println();

        System.out.println("Cliente: "
                + venda.getCliente().getNome());

        System.out.println("Funcionario: "
                + venda.getFuncionario().getNome());

        System.out.println("Veiculo: "
                + venda.getVeiculo().getModelo());

        System.out.println("Forma de pagamento: "
                + venda.getFormaPagamento());

        System.out.println("Valor final: "
                + venda.getValorFinal());
    }
}
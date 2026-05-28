package principal;

import java.util.Date;

import dao.VendaDAO;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Veiculo;
import modelo.Venda;

/**
 * Classe usada para testar
 * cadastro de venda.
 */
public class TesteVenda {

    public static void main(String[] args) {

        // =========================
        // Criando objetos relacionados
        // =========================

        Cliente cliente = new Cliente();

        // ID existente no banco
        cliente.setId(1L);

        Funcionario funcionario =
                new Funcionario();

        // ID existente no banco
        funcionario.setId(1L);

        Veiculo veiculo =
                new Veiculo();

        // ID existente no banco
        veiculo.setId(2L);

        // =========================
        // Criando venda
        // =========================

        Venda venda = new Venda();

        venda.setCliente(cliente);

        venda.setFuncionario(funcionario);

        venda.setVeiculo(veiculo);

        venda.setDataVenda(new Date());

        venda.setFormaPagamento("Financiamento");

        venda.setValorFinal(85000.0);

        // =========================
        // Salvando venda
        // =========================

        VendaDAO vendaDAO =
                new VendaDAO();

        vendaDAO.salvar(venda);

        System.out.println(
                "Venda cadastrada com sucesso!"
        );
    }
}
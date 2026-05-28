package servico;

import java.util.List;

import dao.VendaDAO;
import modelo.Venda;

/**
 * Classe responsável pelas
 * regras de negócio da venda.
 */
public class VendaServico {

    // Objeto DAO
    private VendaDAO vendaDAO =
            new VendaDAO();

    /**
     * Método responsável
     * por validar e salvar venda.
     */
    public void salvar(Venda venda) {

        // =========================
        // VALIDAÇÕES
        // =========================

        // Verifica cliente
        if (venda.getCliente() == null) {

            System.out.println(
                    "Cliente obrigatório."
            );

            return;
        }

        // Verifica funcionário
        if (venda.getFuncionario() == null) {

            System.out.println(
                    "Funcionário obrigatório."
            );

            return;
        }

        // Verifica veículo
        if (venda.getVeiculo() == null) {

            System.out.println(
                    "Veículo obrigatório."
            );

            return;
        }

        // Verifica forma de pagamento
        if (venda.getFormaPagamento() == null ||
                venda.getFormaPagamento().trim().isEmpty()) {

            System.out.println(
                    "Forma de pagamento obrigatória."
            );

            return;
        }

        // Verifica valor final
        if (venda.getValorFinal() <= 0) {

            System.out.println(
                    "Valor inválido."
            );

            return;
        }

        // =========================
        // SALVANDO
        // =========================

        vendaDAO.salvar(venda);

        System.out.println(
                "Venda salva com sucesso!"
        );
    }

    /**
     * Listar vendas.
     */
    public List<Venda> listar() {

        return vendaDAO.listar();
    }

    /**
     * Atualizar venda.
     */
    public void atualizar(Venda venda) {

        vendaDAO.atualizar(venda);
    }

    /**
     * Excluir venda.
     */
    public void excluir(Long id) {

        vendaDAO.excluir(id);
    }
}
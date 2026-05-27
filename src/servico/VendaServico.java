package servico;

import java.util.List;

import dao.VendaDAO;
import modelo.Venda;

/**
 * Classe responsável pelas regras
 * de negócio relacionadas à venda.
 */
public class VendaServico {

    // Objeto DAO
    private VendaDAO vendaDAO =
            new VendaDAO();

    /**
     * Salvar venda.
     */
    public void salvar(Venda venda) {

        // Futuramente:
        // validar veículo disponível
        // calcular comissão
        // gerar faturamento

        vendaDAO.salvar(venda);
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
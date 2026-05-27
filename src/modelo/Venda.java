package modelo;

import java.util.Date;

/**
 * Representa uma venda realizada na loja.
 * 
 * Esta classe conecta:
 * - cliente
 * - funcionário
 * - veículo
 * 
 * funcionando como a entidade central do sistema.
 */
public class Venda {

    /** Identificador único da venda */
    private Long id;

    /** Cliente que realizou a compra */
    private Cliente cliente;

    /** Funcionário responsável pela venda */
    private Funcionario funcionario;

    /** Veículo vendido */
    private Veiculo veiculo;

    /** Data em que a venda foi realizada */
    private Date dataVenda;

    /** Forma de pagamento utilizada */
    private String formaPagamento;

    /** Valor final da venda */
    private Double valorFinal;

    /**
     * Construtor vazio.
     * 
     * Necessário para consultas,
     * frameworks e criação de objetos vazios.
     */
    public Venda() {
    }

    /**
     * Construtor completo.
     */
    public Venda(Long id, Cliente cliente,
                 Funcionario funcionario,
                 Veiculo veiculo,
                 Date dataVenda,
                 String formaPagamento,
                 Double valorFinal) {

        this.id = id;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.veiculo = veiculo;
        this.dataVenda = dataVenda;
        this.formaPagamento = formaPagamento;
        this.valorFinal = valorFinal;
    }

    // ===== GETTERS E SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }
}
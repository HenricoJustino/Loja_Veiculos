package modelo;

/**
 * Representa um veículo da loja.
 * 
 * Esta classe funciona como um "molde" dos veículos do sistema.
 * Cada objeto Veiculo criado representará um carro cadastrado.
 */
public class Veiculo {

    /** Identificador único do veículo */
    private Long id;

    /** Marca do veículo */
    private String marca;

    /** Modelo do veículo */
    private String modelo;

    /** Cor do veículo */
    private String cor;

    /** Ano de fabricação */
    private Integer ano;

    /** Preço do veículo */
    private Double preco;

    /**
     * Status do veículo.
     * 
     * Exemplos:
     * DISPONIVEL
     * VENDIDO
     */
    private String status;

    /**
     * Construtor vazio.
     * 
     * Muito utilizado pelo JavaBeans,
     * frameworks e também durante consultas ao banco.
     */
    public Veiculo() {
    }

    /**
     * Construtor completo.
     * 
     * Facilita criar veículos já preenchidos.
     */
    public Veiculo(Long id, String marca, String modelo, String cor,
                   Integer ano, Double preco, String status) {

        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
        this.status = status;
    }

    // ===== GETTERS E SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
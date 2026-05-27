package modelo;

/**
 * Representa um cliente da loja.
 * 
 * Esta classe armazena os dados dos clientes que realizam compras no sistema.
 * 
 * Em resumo: Ele participa: venda;relacionamento com o veículo;
 */
public class Cliente {

	/** Identificador único do cliente */
	private Long id;

	/** Nome do cliente */
	private String nome;

	/** CPF do cliente */
	private String cpf;

	/** Telefone para contato */
	private String telefone;

	/** Email do cliente */
	private String email;

	/**
	 * Construtor vazio.
	 * 
	 * Necessário para criação de objetos vazios e utilização em consultas ao banco.
	 */
	public Cliente() {
	}

	/**
	 * Construtor completo.
	 * 
	 * Facilita a criação de clientes já preenchidos.
	 */
	public Cliente(Long id, String nome, String cpf, String telefone, String email) {

		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}

	// ===== GETTERS E SETTERS =====

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
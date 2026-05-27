package modelo;

/**
 * Representa um funcionário da loja.
 * 
 * O funcionário será responsável por realizar vendas no sistema.
 */
public class Funcionario {

	/** Identificador único do funcionário */
	private Long id;

	/** Nome do funcionário */
	private String nome;

	/** CPF do funcionário */
	private String cpf;

	/** Telefone para contato */
	private String telefone;

	/** Email do funcionário */
	private String email;

	/**
	 * Construtor vazio.
	 * 
	 * Necessário para criação de objetos vazios e utilização em consultas ao banco.
	 */
	public Funcionario() {
	}

	/**
	 * Construtor completo.
	 * 
	 * Facilita criar funcionários já preenchidos.
	 */
	public Funcionario(Long id, String nome, String cpf, String telefone, String email) {

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
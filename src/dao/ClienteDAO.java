package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.Cliente;

/**
 * Classe responsável pelas operações de banco de dados da entidade Cliente.
 */
public class ClienteDAO {

	/**
	 * Salvar cliente no banco.
	 */
	public void salvar(Cliente cliente) {

		String sql = """

				INSERT INTO cliente
				(nome, cpf, telefone, email)

				VALUES

				(?, ?, ?, ?)

				""";

		try {

			Connection conexao = Conexao.conectar();

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, cliente.getNome());

			stmt.setString(2, cliente.getCpf());

			stmt.setString(3, cliente.getTelefone());

			stmt.setString(4, cliente.getEmail());

			stmt.executeUpdate();

			System.out.println("Cliente salvo com sucesso!");

			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println("Erro ao salvar cliente.");

			e.printStackTrace();
		}
	}

	/**
	 * Listar clientes do banco.
	 */
	public List<Cliente> listar() {

		List<Cliente> listaClientes = new ArrayList<>();

		String sql = "SELECT * FROM cliente";

		try {

			Connection conexao = Conexao.conectar();

			PreparedStatement stmt = conexao.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Cliente cliente = new Cliente();

				cliente.setId(rs.getLong("id"));

				cliente.setNome(rs.getString("nome"));

				cliente.setCpf(rs.getString("cpf"));

				cliente.setTelefone(rs.getString("telefone"));

				cliente.setEmail(rs.getString("email"));

				listaClientes.add(cliente);
			}

			rs.close();

			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println("Erro ao listar clientes.");

			e.printStackTrace();
		}

		return listaClientes;
	}

	/**
	 * Atualizar cliente.
	 */
	public void atualizar(Cliente cliente) {

		String sql = """

				UPDATE cliente

				SET
				nome = ?,
				cpf = ?,
				telefone = ?,
				email = ?

				WHERE id = ?

				""";

		try {

			Connection conexao = Conexao.conectar();

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, cliente.getNome());

			stmt.setString(2, cliente.getCpf());

			stmt.setString(3, cliente.getTelefone());

			stmt.setString(4, cliente.getEmail());

			stmt.setLong(5, cliente.getId());

			stmt.executeUpdate();

			System.out.println("Cliente atualizado com sucesso!");

			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println("Erro ao atualizar cliente.");

			e.printStackTrace();
		}
	}

	/**
	 * Excluir cliente.
	 */
	public void excluir(Long id) {

		String sql = "DELETE FROM cliente WHERE id = ?";

		try {

			Connection conexao = Conexao.conectar();

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setLong(1, id);

			stmt.executeUpdate();

			System.out.println("Cliente excluído com sucesso!");

			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println("Erro ao excluir cliente.");

			e.printStackTrace();
		}
	}
}
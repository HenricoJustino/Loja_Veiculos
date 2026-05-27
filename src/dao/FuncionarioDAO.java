package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.Funcionario;

/**
 * Classe responsável pelas operações de banco de dados da entidade Funcionario.
 */
public class FuncionarioDAO {

	/**
	 * Salvar funcionário no banco.
	 */
	public void salvar(Funcionario funcionario) {

		String sql = """

				INSERT INTO funcionario
				(nome, cpf, telefone, email)

				VALUES

				(?, ?, ?, ?)

				""";

		try {

			Connection conexao = Conexao.conectar();

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, funcionario.getNome());

			stmt.setString(2, funcionario.getCpf());

			stmt.setString(3, funcionario.getTelefone());

			stmt.setString(4, funcionario.getEmail());

			stmt.executeUpdate();

			System.out.println("Funcionário salvo com sucesso!");

			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println("Erro ao salvar funcionário.");

			e.printStackTrace();
		}
	}

	/**
	 * Listar funcionários do banco.
	 */
	public List<Funcionario> listar() {

		List<Funcionario> listaFuncionarios = new ArrayList<>();

		String sql = "SELECT * FROM funcionario";

		try {

			Connection conexao = Conexao.conectar();

			PreparedStatement stmt = conexao.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Funcionario funcionario = new Funcionario();

				funcionario.setId(rs.getLong("id"));

				funcionario.setNome(rs.getString("nome"));

				funcionario.setCpf(rs.getString("cpf"));

				funcionario.setTelefone(rs.getString("telefone"));

				funcionario.setEmail(rs.getString("email"));

				listaFuncionarios.add(funcionario);
			}

			rs.close();

			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println("Erro ao listar funcionários.");

			e.printStackTrace();
		}

		return listaFuncionarios;
	}

	/**
	 * Atualizar funcionário.
	 */
	public void atualizar(Funcionario funcionario) {

		String sql = """

				UPDATE funcionario

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

			stmt.setString(1, funcionario.getNome());

			stmt.setString(2, funcionario.getCpf());

			stmt.setString(3, funcionario.getTelefone());

			stmt.setString(4, funcionario.getEmail());

			stmt.setLong(5, funcionario.getId());

			stmt.executeUpdate();

			System.out.println("Funcionário atualizado com sucesso!");

			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println("Erro ao atualizar funcionário.");

			e.printStackTrace();
		}
	}

	/**
	 * Excluir funcionário.
	 */
	public void excluir(Long id) {

		String sql = "DELETE FROM funcionario WHERE id = ?";

		try {

			Connection conexao = Conexao.conectar();

			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setLong(1, id);

			stmt.executeUpdate();

			System.out.println("Funcionário excluído com sucesso!");

			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println("Erro ao excluir funcionário.");

			e.printStackTrace();
		}
	}
}
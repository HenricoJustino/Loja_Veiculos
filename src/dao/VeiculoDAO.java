package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.Veiculo;

/**
 * Classe responsável pelas operações de banco de dados da entidade Veiculo.
 */
public class VeiculoDAO {

	/**
	 * Método responsável por salvar um veículo no banco de dados.
	 */
	public void salvar(Veiculo veiculo) {

		// Comando SQL de INSERT
		String sql = """

				INSERT INTO veiculo
				(marca, modelo, cor, ano, preco, status)

				VALUES

				(?, ?, ?, ?, ?, ?)

				""";

		try {

			// Abrindo conexão com banco
			Connection conexao = Conexao.conectar();

			// Preparando comando SQL
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// Substituindo os ? pelos dados do objeto
			stmt.setString(1, veiculo.getMarca());

			stmt.setString(2, veiculo.getModelo());

			stmt.setString(3, veiculo.getCor());

			stmt.setInt(4, veiculo.getAno());

			stmt.setDouble(5, veiculo.getPreco());

			stmt.setString(6, veiculo.getStatus());

			// Executando INSERT
			stmt.executeUpdate();

			System.out.println("Veículo salvo com sucesso!");

			// Fechando recursos
			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println("Erro ao salvar veículo.");

			e.printStackTrace();
		}
	}

	/**
	 * Método responsável por listar todos os veículos do banco.
	 */
	public List<Veiculo> listar() { // Depoois vamos criar um metado para listar veiculos mais vendidos

		// Lista que armazenará os veículos
		List<Veiculo> listaVeiculos = new ArrayList<>();

		// Comando SQL
		String sql = "SELECT * FROM veiculo";

		try {

			// Abrindo conexão
			Connection conexao = Conexao.conectar();

			// Preparando SQL
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// Executando SELECT
			ResultSet rs = stmt.executeQuery();

			// Percorrendo resultados
			while (rs.next()) {

				// Criando objeto Veiculo
				Veiculo veiculo = new Veiculo();

				// Preenchendo objeto
				veiculo.setId(rs.getLong("id"));

				veiculo.setMarca(rs.getString("marca"));

				veiculo.setModelo(rs.getString("modelo"));

				veiculo.setCor(rs.getString("cor"));

				veiculo.setAno(rs.getInt("ano"));

				veiculo.setPreco(rs.getDouble("preco"));

				veiculo.setStatus(rs.getString("status"));

				// Adicionando na lista
				listaVeiculos.add(veiculo);
			}

			// Fechando recursos
			rs.close();

			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println("Erro ao listar veículos.");

			e.printStackTrace();
		}

		// Retornando lista
		return listaVeiculos;
	}

	/**
	 * Método responsável por atualizar um veículo no banco.
	 */
	public void atualizar(Veiculo veiculo) {

		// Comando SQL
		String sql = """

				UPDATE veiculo

				SET
				marca = ?,
				modelo = ?,
				cor = ?,
				ano = ?,
				preco = ?,
				status = ?

				WHERE id = ?

				""";

		try {

			// Abrindo conexão
			Connection conexao = Conexao.conectar();

			// Preparando SQL
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// Substituindo parâmetros
			stmt.setString(1, veiculo.getMarca());

			stmt.setString(2, veiculo.getModelo());

			stmt.setString(3, veiculo.getCor());

			stmt.setInt(4, veiculo.getAno());

			stmt.setDouble(5, veiculo.getPreco());

			stmt.setString(6, veiculo.getStatus());

			stmt.setLong(7, veiculo.getId());

			// Executando UPDATE
			stmt.executeUpdate();

			System.out.println("Veículo atualizado com sucesso!");

			// Fechando recursos
			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println("Erro ao atualizar veículo.");

			e.printStackTrace();
		}
	}

	/**
	 * Método responsável por excluir um veículo do banco.
	 */
	public void excluir(Long id) {

		// Comando SQL
		String sql = "DELETE FROM veiculo WHERE id = ?";

		try {

			// Abrindo conexão
			Connection conexao = Conexao.conectar();

			// Preparando SQL
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// Substituindo parâmetro
			stmt.setLong(1, id);

			// Executando DELETE
			stmt.executeUpdate();

			System.out.println("Veículo excluído com sucesso!");

			// Fechando recursos
			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println("Erro ao excluir veículo.");

			e.printStackTrace();
		}
	}

}
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Veiculo;
import modelo.Venda;

/**
 * DAO responsável pelas operações da entidade Venda.
 */
public class VendaDAO {

	/**
	 * Método responsável por salvar venda no banco.
	 */
	public void salvar(Venda venda) {

		String sql = "INSERT INTO venda "
				+ "(id_cliente, id_funcionario, id_veiculo, data_venda, forma_pagamento, valor_final) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		Connection conexao = null;
		PreparedStatement pstmt = null;

		try {

			// Abrindo conexão
			conexao = Conexao.conectar();

			// Preparando SQL
			pstmt = conexao.prepareStatement(sql);

			// Inserindo IDs das FK
			pstmt.setLong(1, venda.getCliente().getId());

			pstmt.setLong(2, venda.getFuncionario().getId());

			pstmt.setLong(3, venda.getVeiculo().getId());

			// Convertendo Date Java → SQL Date
			pstmt.setDate(4,
					new java.sql.Date(
							venda.getDataVenda().getTime()));

			pstmt.setString(5,
					venda.getFormaPagamento());

			pstmt.setDouble(6,
					venda.getValorFinal());

			// Executando INSERT
			pstmt.executeUpdate();

			System.out.println(
					"Venda salva com sucesso!"
			);

		} catch (Exception e) {

			System.out.println(
					"Erro ao salvar venda."
			);

			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null) {
					pstmt.close();
				}

				if (conexao != null) {
					conexao.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	/**
	 * Método responsável
	 * por listar vendas.
	 */
	public List<Venda> listar() {

		List<Venda> listaVendas =
				new ArrayList<>();

		String sql = "SELECT * FROM venda";

		try {

			Connection conexao =
					Conexao.conectar();

			PreparedStatement stmt =
					conexao.prepareStatement(sql);

			ResultSet rs =
					stmt.executeQuery();

			while (rs.next()) {

				Venda venda = new Venda();

				venda.setId(
						rs.getLong("id"));

				// Criando objetos relacionados
				Cliente cliente =
						new Cliente();

				cliente.setId(
						rs.getLong("id_cliente"));

				Funcionario funcionario =
						new Funcionario();

				funcionario.setId(
						rs.getLong("id_funcionario"));

				Veiculo veiculo =
						new Veiculo();

				veiculo.setId(
						rs.getLong("id_veiculo"));

				// Associando objetos
				venda.setCliente(cliente);

				venda.setFuncionario(funcionario);

				venda.setVeiculo(veiculo);

				venda.setDataVenda(
						rs.getDate("data_venda"));

				venda.setFormaPagamento(
						rs.getString("forma_pagamento"));

				venda.setValorFinal(
						rs.getDouble("valor_final"));

				listaVendas.add(venda);
			}

			rs.close();

			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println(
					"Erro ao listar vendas."
			);

			e.printStackTrace();
		}

		return listaVendas;
	}

	/**
	 * Método responsável
	 * por atualizar venda.
	 */
	public void atualizar(Venda venda) {

		String sql = """

				UPDATE venda

				SET
				id_cliente = ?,
				id_funcionario = ?,
				id_veiculo = ?,
				data_venda = ?,
				forma_pagamento = ?,
				valor_final = ?

				WHERE id = ?

				""";

		try {

			Connection conexao =
					Conexao.conectar();

			PreparedStatement stmt =
					conexao.prepareStatement(sql);

			stmt.setLong(1,
					venda.getCliente().getId());

			stmt.setLong(2,
					venda.getFuncionario().getId());

			stmt.setLong(3,
					venda.getVeiculo().getId());

			stmt.setDate(4,
					new java.sql.Date(
							venda.getDataVenda().getTime()));

			stmt.setString(5,
					venda.getFormaPagamento());

			stmt.setDouble(6,
					venda.getValorFinal());

			stmt.setLong(7,
					venda.getId());

			stmt.executeUpdate();

			System.out.println(
					"Venda atualizada com sucesso!"
			);

			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println(
					"Erro ao atualizar venda."
			);

			e.printStackTrace();
		}
	}

	/**
	 * Método responsável
	 * por excluir venda.
	 */
	public void excluir(Long id) {

		String sql =
				"DELETE FROM venda WHERE id = ?";

		try {

			Connection conexao =
					Conexao.conectar();

			PreparedStatement stmt =
					conexao.prepareStatement(sql);

			stmt.setLong(1, id);

			stmt.executeUpdate();

			System.out.println(
					"Venda excluída com sucesso!"
			);

			stmt.close();

			conexao.close();

		} catch (Exception e) {

			System.out.println(
					"Erro ao excluir venda."
			);

			e.printStackTrace();
		}
	}
}
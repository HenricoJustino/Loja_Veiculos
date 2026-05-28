package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexao.Conexao;
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
			pstmt.setDate(4, new java.sql.Date(venda.getDataVenda().getTime()));

			pstmt.setString(5, venda.getFormaPagamento());

			pstmt.setDouble(6, venda.getValorFinal());

			// Executando INSERT
			pstmt.executeUpdate();

			System.out.println("Venda salva com sucesso!");

		} catch (Exception e) {

			System.out.println("Erro ao salvar venda.");

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
}
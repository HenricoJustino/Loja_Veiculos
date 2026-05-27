package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Veiculo;
import modelo.Venda;

/**
 * Classe responsável pelas operações
 * de banco de dados da entidade Venda.
 */
public class VendaDAO {

    /**
     * Salvar venda no banco.
     */
    public void salvar(Venda venda) {

        String sql = """
                
                INSERT INTO venda
                
                (
                id_cliente,
                id_funcionario,
                id_veiculo,
                data_venda,
                forma_pagamento,
                valor_final
                )
                
                VALUES
                
                (?, ?, ?, ?, ?, ?)
                
                """;

        try {

            Connection conexao =
                    Conexao.conectar();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            // FK cliente
            stmt.setLong(
                    1,
                    venda.getCliente().getId());

            // FK funcionario
            stmt.setLong(
                    2,
                    venda.getFuncionario().getId());

            // FK veiculo
            stmt.setLong(
                    3,
                    venda.getVeiculo().getId());

            // Data
            stmt.setDate(
                    4,
                    new Date(
                            venda.getDataVenda().getTime()));

            // Forma pagamento
            stmt.setString(
                    5,
                    venda.getFormaPagamento());

            // Valor final
            stmt.setDouble(
                    6,
                    venda.getValorFinal());

            stmt.executeUpdate();

            System.out.println(
                    "Venda salva com sucesso!");

            stmt.close();

            conexao.close();

        } catch (Exception e) {

            System.out.println(
                    "Erro ao salvar venda.");

            e.printStackTrace();
        }
    }

    /**
     * Listar vendas.
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

                Venda venda =
                        new Venda();

                venda.setId(
                        rs.getLong("id"));

                // =========================
                // CLIENTE
                // =========================

                Cliente cliente =
                        new Cliente();

                cliente.setId(
                        rs.getLong("id_cliente"));

                venda.setCliente(cliente);

                // =========================
                // FUNCIONARIO
                // =========================

                Funcionario funcionario =
                        new Funcionario();

                funcionario.setId(
                        rs.getLong("id_funcionario"));

                venda.setFuncionario(funcionario);

                // =========================
                // VEICULO
                // =========================

                Veiculo veiculo =
                        new Veiculo();

                veiculo.setId(
                        rs.getLong("id_veiculo"));

                venda.setVeiculo(veiculo);

                // =========================
                // DEMAIS CAMPOS
                // =========================

                venda.setDataVenda(
                        rs.getDate("data_venda"));

                venda.setFormaPagamento(
                        rs.getString(
                                "forma_pagamento"));

                venda.setValorFinal(
                        rs.getDouble(
                                "valor_final"));

                listaVendas.add(venda);
            }

            rs.close();

            stmt.close();

            conexao.close();

        } catch (Exception e) {

            System.out.println(
                    "Erro ao listar vendas.");

            e.printStackTrace();
        }

        return listaVendas;
    }

    /**
     * Atualizar venda.
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

            stmt.setLong(
                    1,
                    venda.getCliente().getId());

            stmt.setLong(
                    2,
                    venda.getFuncionario().getId());

            stmt.setLong(
                    3,
                    venda.getVeiculo().getId());

            stmt.setDate(
                    4,
                    new Date(
                            venda.getDataVenda().getTime()));

            stmt.setString(
                    5,
                    venda.getFormaPagamento());

            stmt.setDouble(
                    6,
                    venda.getValorFinal());

            stmt.setLong(
                    7,
                    venda.getId());

            stmt.executeUpdate();

            System.out.println(
                    "Venda atualizada com sucesso!");

            stmt.close();

            conexao.close();

        } catch (Exception e) {

            System.out.println(
                    "Erro ao atualizar venda.");

            e.printStackTrace();
        }
    }

    /**
     * Excluir venda.
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
                    "Venda excluída com sucesso!");

            stmt.close();

            conexao.close();

        } catch (Exception e) {

            System.out.println(
                    "Erro ao excluir venda.");

            e.printStackTrace();
        }
    }
}
package cadastrobd.model;

import cadastrobd.model.util.ConectorBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {

    // Método para obter uma Pessoa Física pelo ID
    public PessoaFisica getPessoa(int pessoaID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaFisica pessoa = null;

        try {
            conn = ConectorBD.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM Pessoa WHERE PessoaID = ? AND TipoPessoa = 'Física'";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, pessoaID);
                rs = pstmt.executeQuery();

                if (rs != null && rs.next()) {
                    pessoa = resultSetToPessoaFisica(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(rs);
            ConectorBD.close(pstmt);
            ConectorBD.close(conn);
        }

        return pessoa;
    }

    // Método para retornar todas as Pessoas Físicas
    public List<PessoaFisica> getPessoas() {
        List<PessoaFisica> pessoas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConectorBD.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM Pessoa WHERE TipoPessoa = 'Física'";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs != null && rs.next()) {
                    PessoaFisica pessoa = resultSetToPessoaFisica(rs);
                    pessoas.add(pessoa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(rs);
            ConectorBD.close(pstmt);
            ConectorBD.close(conn);
        }

        return pessoas;
    }

    // Método para incluir uma nova Pessoa Física
    public boolean incluir(PessoaFisica pessoa) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean resultado = false;

        try {
            conn = ConectorBD.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO Pessoa (TipoPessoa, Nome, Endereco, Telefone, Email, CPF) OUTPUT INSERTED.PessoaID VALUES (?, ?, ?, ?, ?, ?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "Física");
                pstmt.setString(2, pessoa.getNome());
                pstmt.setString(3, pessoa.getEndereco());
                pstmt.setString(4, pessoa.getTelefone());
                pstmt.setString(5, pessoa.getEmail());
                pstmt.setString(6, pessoa.getCpf());
                rs = pstmt.executeQuery();

                if (rs != null && rs.next()) {
                    pessoa.setPessoaID(rs.getInt(1));
                    resultado = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(rs);
            ConectorBD.close(pstmt);
            ConectorBD.close(conn);
        }

        return resultado;
    }

    // Método para alterar os dados de uma Pessoa Física
    public boolean alterar(PessoaFisica pessoa) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean resultado = false;

        try {
            conn = ConectorBD.getConnection();
            if (conn != null) {
                String sql = "UPDATE Pessoa SET Nome = ?, Endereco = ?, Telefone = ?, Email = ?, CPF = ? WHERE PessoaID = ? AND TipoPessoa = 'Física'";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, pessoa.getNome());
                pstmt.setString(2, pessoa.getEndereco());
                pstmt.setString(3, pessoa.getTelefone());
                pstmt.setString(4, pessoa.getEmail());
                pstmt.setString(5, pessoa.getCpf());
                pstmt.setInt(6, pessoa.getPessoaID());
                int rows = pstmt.executeUpdate();

                if (rows > 0) {
                    resultado = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(pstmt);
            ConectorBD.close(conn);
        }

        return resultado;
    }

    // Método para excluir uma Pessoa Física pelo ID
    public boolean excluir(int pessoaID) {
        boolean excluiu = false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConectorBD.getConnection();
            if (conn != null) {
                String sql = "DELETE FROM Pessoa WHERE PessoaID = ? AND TipoPessoa = 'Física'";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, pessoaID);
                int rowsAffected = pstmt.executeUpdate();
                excluiu = (rowsAffected > 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(pstmt);
            ConectorBD.close(conn);
        }

        return excluiu;
    }

    // Método utilitário para converter ResultSet em objeto PessoaFisica
    private PessoaFisica resultSetToPessoaFisica(ResultSet rs) throws SQLException {
        PessoaFisica pessoa = new PessoaFisica();
        pessoa.setPessoaID(rs.getInt("PessoaID"));
        pessoa.setTipoPessoa(rs.getString("TipoPessoa"));
        pessoa.setNome(rs.getString("Nome"));
        pessoa.setEndereco(rs.getString("Endereco"));
        pessoa.setTelefone(rs.getString("Telefone"));
        pessoa.setEmail(rs.getString("Email"));
        pessoa.setCpf(rs.getString("CPF"));
        return pessoa;
    }
}

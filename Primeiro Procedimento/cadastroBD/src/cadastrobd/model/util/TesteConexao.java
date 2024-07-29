package cadastrobd.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Carrega o driver JDBC explicitamente
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Estabelece a conexão
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Loja;encrypt=true;trustServerCertificate=true;";
            String user = "sa";
            String password = "loja";
            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Conexão estabelecida com sucesso!");
                // Fecha a conexão
                connection.close();
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } finally {
            // Fecha a conexão se ainda estiver aberta
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

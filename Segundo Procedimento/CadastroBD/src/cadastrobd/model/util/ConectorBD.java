package cadastrobd.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorBD {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Loja;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "loja";
    

    // Método para retornar uma conexão com o banco de dados
    public static Connection getConnection() {
        try {         
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() ); 
            return null;
        }
    }
    

    // Método para retornar um objeto do tipo PreparedStatement a partir de um SQL fornecido
    public static PreparedStatement getPrepared(Connection conn, String sql, int RETURN_GENERATED_KEYS) {
        try {
            return conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para retornar o ResultSet relacionado a uma consulta
    public static ResultSet getSelect(PreparedStatement pstmt) {
        try {
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para fechar um Statement
    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para fechar um ResultSet
    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para fechar uma Connection
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para fechar um PreparedStatement (chama close(Statement) internamente)
    public static void close(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package cadastrobd.model.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SequenceManager {
    
    // Método para retornar o próximo valor de uma sequência
    public static int getValue(String sequenceName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int nextValue = -1;
        
        try {
            conn = ConectorBD.getConnection();
            if (conn != null) {
                String sql = "SELECT NEXT VALUE FOR " + sequenceName;
                pstmt = ConectorBD.getPrepared(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);
                rs = ConectorBD.getSelect(pstmt);
                
                if (rs != null && rs.next()) {
                    nextValue = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConectorBD.close(rs);
            ConectorBD.close(pstmt);
            ConectorBD.close(conn);
        }
        
        return nextValue;
    }
}

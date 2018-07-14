package dados;

import java.sql.*;

/**
 * Created by over on 06/07/18.
 */
public class Database {

    private Connection conn;

    public Database() throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/sisfarj";
        String usuario = "postgres";
        String senha = "postgres";
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url,usuario,senha);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public ResultSet doSelect(String query) throws SQLException{
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    //Usar para update, insert e delete
    public int doUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(query);
    }
}

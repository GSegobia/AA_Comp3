package dados;

import java.sql.*;

/**
 * Created by over on 06/07/18.
 */
public class Database {

    private static Connection conn;

    public static Connection getConnect() throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/sisfarj";
        String usuario = "postgres";
        String senha = "postgres    ";

        if(conn == null){
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,usuario,senha);
        }
        return conn;
    }

    public static ResultSet doSelect(String query) throws ClassNotFoundException, SQLException{
        Statement stmt;
        ResultSet rs = null;
        conn = Database.getConnect();

        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch(Exception e) {
            System.err.println(e.toString());
        }

        return rs;
    }
    //Usar para update, insert e delete
    public static int doUpdate(String query) throws ClassNotFoundException, SQLException {
        Statement stmt;
        int updatesDone = 0;

        conn = Database.getConnect();
        stmt = conn.createStatement();
        updatesDone = stmt.executeUpdate(query);

        return updatesDone;
    }
}

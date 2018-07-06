package dados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by over on 06/07/18.
 */
public class Database {

    private static Database instance;
    private static Connection conn;
    private static Statement stmt;

    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public static Connection getConnect() {
        String url = "jdbc:postgresql://localhost:5432/sisfarj";
        String usuario="postgres";
        String senha = "123456";

        if(conn == null){
            try {
                conn = DriverManager.getConnection(url,usuario,senha);
            } catch(Exception e ){
                System.err.println(e.toString());
            }
        }
        return conn;
    }
    public static void main(String args[]){
        Database.getConnect();
    }

}

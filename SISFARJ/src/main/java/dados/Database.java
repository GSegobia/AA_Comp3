package dados;
import javax.validation.metadata.ExecutableDescriptor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by over on 06/07/18.
 */
public class Database {

    private static Database instance;
    private static Connection conn;

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
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(url,usuario,senha);
            } catch(Exception e ){
                System.err.println(e.toString());
            }
        }
        return conn;
    }

    public static ResultSet doSelect(String query){
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
    public static int doUpdate(String query){
        Statement stmt;
        int updatesDone = 0;
        conn = Database.getConnect();

        try{
            stmt = conn.createStatement();
            updatesDone = stmt.executeUpdate(query);
        } catch(Exception e) {
            System.err.println(e.toString());
        }

        return updatesDone;
    }
}

package dados;
import java.util.ArrayList;
import dados.Database;

/**
 * Created by over on 06/07/18.
 */
public interface DAO {

    boolean find(int id);
    Class findAndGet(int id);
//    public abstract boolean find(String campo, String valor);
//    public abstract ArrayList<Object> findAll();
//    public abstract boolean create(Object obj);
//    public abstract boolean update();
}

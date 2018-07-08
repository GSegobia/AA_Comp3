package dados;
import java.sql.ResultSet;
import java.util.ArrayList;
import dados.Database;
import dominio.Modelo;

/**
 * Created by over on 06/07/18.
 */
public abstract class DAO {
    public abstract Modelo mapModel(ResultSet rs);
    public abstract boolean find(int id);
    public abstract Modelo findAndGet(int id);
    public abstract boolean create(Modelo modelo);
    public abstract boolean update(Modelo modelo);
    public abstract ArrayList<Modelo> findAll();

}

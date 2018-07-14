package dados;

import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Fellipe Bravo on 14/07/18.
 */
public interface DataMapper<Modelo>{
    Modelo mapModel(ResultSet rs) throws SQLException;
    Modelo get(int id) throws SQLException, ModeloNaoExiste, ClassNotFoundException;
    boolean create(Modelo modelo) throws SQLException, ClassNotFoundException;
    boolean update(Modelo modelo) throws SQLException, ClassNotFoundException;
    List<Modelo> findAll() throws SQLException, ClassNotFoundException;
}

package dados;

import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DataMapper<Model> {
    public abstract Model mapModel(ResultSet rs) throws ClassNotFoundException, SQLException;
    public abstract boolean exists(int id) throws ClassNotFoundException, SQLException;
    public abstract Model get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste;
    public abstract boolean create(Model modelo) throws ClassNotFoundException, SQLException;
    public abstract boolean update(Model modelo) throws ClassNotFoundException, SQLException;
    public abstract ArrayList<Model> findAll() throws ClassNotFoundException, SQLException;
}

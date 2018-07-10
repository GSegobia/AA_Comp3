package main.java.dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by over on 06/07/18.
 */
public interface DAO<Model> {
    Model mapModel(ResultSet rs) throws ClassNotFoundException, SQLException;
    boolean exists(int id) throws ClassNotFoundException, SQLException;
    Model get(int id) throws ClassNotFoundException, SQLException;
    boolean create(Model modelo) throws ClassNotFoundException, SQLException;
    boolean update(Model modelo) throws ClassNotFoundException, SQLException;
    ArrayList<Model> findAll() throws ClassNotFoundException, SQLException;

}

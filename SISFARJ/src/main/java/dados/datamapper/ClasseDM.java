package dados.datamapper;

import dados.DataMapper;
import dados.Database;
import dominio.Classe;
import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by over on 11/07/18.
 */
public class ClasseDM implements DataMapper<Classe> {

    @Override
    public Classe mapModel(ResultSet rs) throws SQLException {
        return new Classe(
                rs.getInt("id"),
                rs.getString("nome")
        );
    }

    @Override
    public Classe get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        Classe a = null;
        String query = String.format("SELECT * FROM classe WHERE id=%d",id);

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        if(rs.next()) a = mapModel(rs);
        if(a == null) throw new ModeloNaoExiste("Classe",id);

        return a;
    }

    @Override
    public boolean create(Classe classe) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Classe classe) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Classe> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Classe> categorias = new ArrayList<>();

        Database db = new Database();
        ResultSet rs = db.doSelect("SELECT * FROM classe");
        db.closeConnection();

        while(rs.next()) categorias.add(mapModel(rs));
        return categorias;
    }
}

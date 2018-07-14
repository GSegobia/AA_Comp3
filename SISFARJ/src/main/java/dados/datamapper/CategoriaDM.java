package dados.datamapper;

import dados.DataMapper;
import dados.Database;
import dominio.Categoria;
import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by over on 11/07/18.
 */
public class CategoriaDM implements DataMapper<Categoria> {

    @Override
    public Categoria mapModel(ResultSet rs) throws SQLException {
        return new Categoria(
                rs.getInt("id"),
                rs.getString("nome")
        );
    }

    @Override
    public Categoria get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        Categoria a = null;
        String query = String.format("SELECT * FROM Categoria WHERE id=%d",id);

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        if(rs.next()) a = mapModel(rs);
        if(a == null) throw new ModeloNaoExiste("Categoria",id);

        return a;
    }

    @Override
    public boolean create(Categoria categoria) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Categoria categoria) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Categoria> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Categoria> categorias = new ArrayList<>();

        Database db = new Database();
        ResultSet rs = db.doSelect("SELECT * FROM categoria");
        db.closeConnection();

        while(rs.next()) categorias.add(mapModel(rs));
        return categorias;
    }
}

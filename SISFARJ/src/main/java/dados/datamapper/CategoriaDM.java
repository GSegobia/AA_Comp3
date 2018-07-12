package dados.datamapper;

import dados.Database;
import dominio.Categoria;
import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by over on 11/07/18.
 */
public class CategoriaDM {
    private static Categoria mapModel(ResultSet rs) throws ClassNotFoundException, SQLException {
        return new Categoria(
                rs.getInt("id"),
                rs.getString("nome")
        );
    }

    public static Categoria get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        Categoria a = null;
        String query = String.format("Select * from Categoria where id=%d",id);

        ResultSet rs = Database.doSelect(query);

        if(rs.next()){
            a = mapModel(rs);
        }
        if(a == null) throw new ModeloNaoExiste("Categoria",id);

        return a;
    }
    
    public static ArrayList<Categoria> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        ResultSet rs = Database.doSelect("Select * from categoria");

        if(rs.next()){
            do {
                categorias.add(mapModel(rs));
            } while(rs.next());
        }
        return categorias;
    }
}

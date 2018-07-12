package dados.datamapper;

import dados.Database;
import dominio.Classe;
import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by over on 11/07/18.
 */
public class ClasseDM {
    private static Classe mapModel(ResultSet rs) throws ClassNotFoundException, SQLException {
        return new Classe(
                rs.getInt("id"),
                rs.getString("nome")
        );
    }

    public static Classe get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        Classe a = null;
        String query = String.format("Select * from classe where id=%d",id);

        ResultSet rs = Database.doSelect(query);

        if(rs.next()){
            a = mapModel(rs);
        }

        if(a == null) throw new ModeloNaoExiste("Classe",id);

        return a;
    }
    
    public static ArrayList<Classe> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Classe> categorias = new ArrayList<Classe>();
        ResultSet rs = Database.doSelect("Select * from classe");

        if(rs.next()){
            do {
                categorias.add(mapModel(rs));
            } while(rs.next());
        }
        return categorias;
    }
}

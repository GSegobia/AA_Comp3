package dados.datamapper;

import dados.Database;
import dominio.Prova;
import exceptions.ModeloNaoExiste;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ProvaDM {

    private static Prova mapModel(ResultSet rs) throws ClassNotFoundException, SQLException {
        return new Prova(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("classe_id"),
                rs.getInt("categoria_id"),
                rs.getInt("competicao_id")
        );
    }

    public static Prova get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        Prova a = null;
        String query = String.format("Select * from Prova where id=%d",id);

        ResultSet rs = Database.doSelect(query);

        while(rs.next()){
            a = mapModel(rs);
        }
        if(a == null) throw new ModeloNaoExiste("Prova",id);

        return a;
    }

    public static boolean create(Prova modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into Prova (nome,classe_id,categoria_id,competica_id) " +
                        "values('%s',%d,%d,%d,%d);",
                modelo.getNome(),
                modelo.getClasse_id(),
                modelo.getCategoria_id(),
                modelo.getCompeticao_id()
            );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
    }

    public static ArrayList<Prova> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Prova> Provas = new ArrayList<Prova>();
        ResultSet rs = Database.doSelect("Select * from Prova");

        if(rs.next()){
            do {
                Provas.add(mapModel(rs));
            } while(rs.next());
        }
        return Provas;
    }

}

package dados.datamapper;

import dados.Database;
import dominio.CompeticaoProva;
import exceptions.ModeloNaoExiste;
import org.apache.commons.lang3.ArrayUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompeticaoProvaDM {

    private static CompeticaoProva mapModel(ResultSet rs) throws ClassNotFoundException, SQLException {
        return new CompeticaoProva(
                rs.getInt("id"),
                rs.getInt("competicao_id"),
                rs.getInt("prova_id")
        );
    }

    public static CompeticaoProva get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        CompeticaoProva a = null;
        String query = String.format("Select * from competicao_prova where id=%d",id);

        ResultSet rs = Database.doSelect(query);

        while(rs.next()){
            a = mapModel(rs);
        }

        if(a == null) {
            throw new ModeloNaoExiste("competicao_prova",id);
        }

        return a;
    }

    public static boolean create(CompeticaoProva modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into competicao_prova (competicao_id,prova_id) " +
                        "values(%d,%d);",
                modelo.getCompeticao_id(),
                modelo.getProva_id()
            );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
    }

    public static int[] findAllProvaInCompeticao(int competicao_id) throws ClassNotFoundException, SQLException {
        int[] listaProvas= {};

        String query = String.format("Select prova_id from competicao_prova where competicao_id=%d",competicao_id);
        ResultSet rs = Database.doSelect(query);

        if(rs.next()){
            do {
                listaProvas = ArrayUtils.add(listaProvas,rs.getInt("prova_id"));
            } while(rs.next());
        }

        return listaProvas;
    }
}

package dados.datamapper;

import dados.Database;
import dominio.ProvaAtleta;
import exceptions.ModeloNaoExiste;
import org.apache.commons.lang3.ArrayUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvaAtletaDM {

    private static ProvaAtleta mapModel(ResultSet rs) throws ClassNotFoundException, SQLException {
        return new ProvaAtleta(
                rs.getInt("id"),
                rs.getInt("prova_id"),
                rs.getInt("atleta_id")
        );
    }

    public static ProvaAtleta get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        ProvaAtleta a = null;
        String query = String.format("Select * from prova_atleta where id=%d",id);

        ResultSet rs = Database.doSelect(query);

        if(rs.next()){
            a = mapModel(rs);
        }

        if(a == null) {
            throw new ModeloNaoExiste("prova_atleta",id);
        }

        return a;
    }

    public static boolean create(ProvaAtleta modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into prova_atleta (prova_id,atleta_id) " +
                        "values(%d,%d);",
                modelo.getProva_id(),
                modelo.getAtleta_id()
            );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
    }

    public static int[] findAllAtletaInProva(int idProva) throws ClassNotFoundException, SQLException {
        int[] listaAtletas= {};

        String query = String.format("Select id_atleta from prova_atleta where id_prova=%d",idProva);
        ResultSet rs = Database.doSelect(query);

        if(rs.next()){
            do {
                listaAtletas = ArrayUtils.add(listaAtletas,rs.getInt("id_atleta"));
            } while(rs.next());
        }

        return listaAtletas;
    }
}

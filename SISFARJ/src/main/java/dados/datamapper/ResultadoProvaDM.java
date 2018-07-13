package dados.datamapper;

import dados.Database;
import dominio.ResultadoProva;
import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultadoProvaDM {

    private static ResultadoProva mapModel(ResultSet rs) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        return new ResultadoProva(
                rs.getString("tempo"),
                rs.getInt("prova_id"),
                rs.getInt("atleta_id")
        );
    }

    public static ResultadoProva get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        ResultadoProva a = null;

        String query = String.format("Select * from resultado_provas where prova_id=%d",id);

        ResultSet rs = Database.doSelect(query);

        while(rs.next()){
            a = mapModel(rs);
        }

        if(a == null) {
            throw new ModeloNaoExiste("resultado_provas",id);
        }

        return a;
    }

    public static boolean create(ResultadoProva rp) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into resultado_provas (tempo, prova_id,atleta_id, pontuacao) " +
                        "values(%d,%d,%d,%d);",
                Integer.valueOf(rp.getTempo()),
                rp.getProva_id(),
                rp.getAtleta_id(),
                rp.getPontuacao()

        );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
    }


    public static ArrayList<ResultadoProva> findAllByTempo(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        ArrayList<ResultadoProva> rp = new ArrayList<>();
        ResultSet rs = Database.doSelect("Select * from resultado_provas WHERE prova_id="+id+" ORDER BY tempo");

        if(rs.next()){
            do {
                rp.add(mapModel(rs));
            } while(rs.next());
        }
        return rp;
    }
}


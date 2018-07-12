package dados.datamapper;

import dados.Database;
import dominio.Competicao;
import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompeticaoDM {

    private static Competicao mapModel(ResultSet rs) throws ClassNotFoundException, SQLException {

        return new Competicao(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("centroAquaticoId"),
                rs.getDate("dataCompeticao"),
                rs.getInt("tamanhoPiscina"));
    }

    public static ArrayList<Competicao> findAll() throws SQLException, ClassNotFoundException{
        ArrayList<Competicao> competicaos = new ArrayList<Competicao>();
        ResultSet rs = Database.doSelect("Select * from Competicao");

        if(rs.next()){
            do {
                competicaos.add(mapModel(rs));
            } while(rs.next());
        }
        return competicaos;
    }

    public static Competicao get(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Competicao c = null;
        String query = String.format("Select * from Competicao where id =%d", id);
        ResultSet rs = Database.doSelect(query);

        while(rs.next()){
                c = mapModel(rs);
        }

        if(c == null){
            throw new ModeloNaoExiste("competicao",id);
        }
        return c;
    }

    public static boolean create(Competicao modelo) throws SQLException,ClassNotFoundException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into Atleta (nome,centro_aquatico_id,data_competicao,tamanho_piscina)" +
                        "values('%s',%d,'%s',%d);",
                modelo.getNome(),
                modelo.getCentroAquaticoId(),
                modelo.getDataCompeticao(),
                modelo.getTamanhoPiscina()
        );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
    }

    public static boolean update(Competicao modelo) throws SQLException, ClassNotFoundException {
        int linhasAtualizadas;

        String query = String.format(
                "UPDATE Atleta SET nome='%s',centro_aquatico_id=%d,data_competicao='%s',tamanho_piscina=%d where id=%d;",
                modelo.getNome(),
                modelo.getCentroAquaticoId(),
                modelo.getDataCompeticao(),
                modelo.getTamanhoPiscina(),
                modelo.getId()
        );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
    }
}

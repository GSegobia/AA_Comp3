package dados.datamapper;

import dados.Database;
import dominio.CentroAquatico;
import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CentroAquaticoDM {
    private static CentroAquatico mapModel(ResultSet rs) throws ClassNotFoundException, SQLException {
        return new CentroAquatico(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("endereco"),
                rs.getInt("tamanho_piscina"));
    }

    public static ArrayList<CentroAquatico> findAll() throws SQLException, ClassNotFoundException{
        ArrayList<CentroAquatico> centroAquaticos = new ArrayList<CentroAquatico>();
        ResultSet rs = Database.doSelect("Select * from centro_aquatico");

        if(rs.next()){
            do {
                centroAquaticos.add(mapModel(rs));
            } while(rs.next());
        }
        return centroAquaticos;
    }

    public static CentroAquatico get(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        CentroAquatico c = null;
        String query = String.format("Select * from centro_aquatico where id =%d", id);
        ResultSet rs = Database.doSelect(query);

        while(rs.next()){
            c = mapModel(rs);
        }

        return c;
    }

    public static boolean create(CentroAquatico modelo) throws SQLException,ClassNotFoundException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into centro_aquatico (nome,endereco,tamanho_piscina)" +
                        "values('%s','%s',%d);",
                modelo.getNome(),
                modelo.getEndereco(),
                modelo.getTamanho_piscina()
        );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
    }

    public static boolean update(CentroAquatico modelo) throws SQLException, ClassNotFoundException {
        int linhasAtualizadas;

        String query = String.format(
                "UPDATE CentroAquatico SET nome='%s',endereco='%s',tamanho_piscina=%d where id=%d;",
                modelo.getNome(),
                modelo.getEndereco(),
                modelo.getTamanho_piscina(),
                modelo.getId()
        );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
    }
}

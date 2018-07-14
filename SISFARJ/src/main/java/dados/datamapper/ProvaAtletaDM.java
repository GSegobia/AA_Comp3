package dados.datamapper;

import dados.DataMapper;
import dados.Database;
import dominio.ProvaAtleta;
import exceptions.ModeloNaoExiste;
import org.apache.commons.lang3.ArrayUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProvaAtletaDM implements DataMapper<ProvaAtleta> {

    @Override
    public ProvaAtleta mapModel(ResultSet rs) throws SQLException {
        return new ProvaAtleta(
                rs.getInt("id"),
                rs.getInt("id_prova"),
                rs.getInt("id_atleta")
        );
    }

    @Override
    public ProvaAtleta get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        ProvaAtleta a = null;
        String query = String.format("Select * from prova_atleta where id=%d",id);

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        if(rs.next()) a = mapModel(rs);
        if(a == null) throw new ModeloNaoExiste("prova_atleta",id);

        return a;
    }

    @Override
    public boolean create(ProvaAtleta modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into prova_atleta (id_prova,id_atleta) " +
                        "values(%d,%d);",
                modelo.getProva_id(),
                modelo.getAtleta_id()
            );

        Database db = new Database();
        linhasAtualizadas = db.doUpdate(query);
        db.closeConnection();

        return linhasAtualizadas > 0;
    }

    @Override
    public boolean update(ProvaAtleta provaAtleta) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<ProvaAtleta> findAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public int[] findAllAtletaInProva(int idProva) throws ClassNotFoundException, SQLException {
        int[] listaAtletas= {};

        String query = String.format("Select id_atleta from prova_atleta where id_prova=%d",idProva);

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        while(rs.next()) listaAtletas = ArrayUtils.add(listaAtletas,rs.getInt("id_atleta"));
        return listaAtletas;
    }
}

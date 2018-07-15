package dados.datamapper;

import dados.DataMapper;
import dados.Database;
import dominio.ResultadoProva;
import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultadoProvaDM implements DataMapper<ResultadoProva> {

    @Override
    public ResultadoProva mapModel(ResultSet rs) throws SQLException {
        return new ResultadoProva(
                rs.getString("tempo"),
                rs.getInt("prova_id"),
                rs.getInt("atleta_id"),
                rs.getString("pontuacao")
        );
    }

    @Override
    public ResultadoProva get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        ResultadoProva rp = null;

        String query = String.format("SELECT * from resultado_provas where prova_id=%d",id);

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        if(rs.next()) rp = mapModel(rs);
        if(rp == null) throw new ModeloNaoExiste("resultado_provas",id);

        return rp;
    }

    @Override
    public boolean create(ResultadoProva rp) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into resultado_provas (tempo, prova_id,atleta_id, pontuacao) " +
                        "values('%s',%d,%d,'%s');",
                rp.getTempo(),
                rp.getProva_id(),
                rp.getAtleta_id(),
                rp.getPontuacao()

        );

        Database db = new Database();
        linhasAtualizadas = db.doUpdate(query);
        db.closeConnection();

        return linhasAtualizadas > 0;
    }

    @Override
    public boolean update(ResultadoProva resultadoProva) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<ResultadoProva> findAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public ArrayList<ResultadoProva> findAllByTempo(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        ArrayList<ResultadoProva> rp = new ArrayList<>();

        Database db = new Database();
        ResultSet rs = db.doSelect("SELECT * from resultado_provas WHERE prova_id="+id+" ORDER BY tempo");
        db.closeConnection();

        while(rs.next()) rp.add(mapModel(rs));
        return rp;
    }

    public ArrayList<ResultadoProva> findAllBy8(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        ArrayList<ResultadoProva> rp = new ArrayList<>();

        Database db = new Database();
        ResultSet rs = db.doSelect("SELECT * from resultado_provas WHERE prova_id="+id+" ORDER BY id LIMIT 8");
        db.closeConnection();

        while(rs.next()) rp.add(mapModel(rs));
        return rp;
    }
}


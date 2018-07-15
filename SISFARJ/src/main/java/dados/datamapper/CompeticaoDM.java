package dados.datamapper;

import dados.DataMapper;
import dados.Database;
import dominio.Competicao;
import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompeticaoDM implements DataMapper<Competicao> {

    @Override
    public Competicao mapModel(ResultSet rs) throws SQLException {
        return new Competicao(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("centro_aquatico_id"),
                rs.getDate("data_competicao"),
                rs.getInt("tamanho_piscina"));
    }

    @Override
    public List<Competicao> findAll() throws SQLException, ClassNotFoundException{
        ArrayList<Competicao> competicaos = new ArrayList<Competicao>();

        Database db = new Database();
        ResultSet rs = db.doSelect("SELECT * from Competicao");
        db.closeConnection();

        while(rs.next()) competicaos.add(mapModel(rs));
        return competicaos;
    }

    @Override
    public Competicao get(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Competicao c = null;
        String query = String.format("SELECT * from Competicao where id =%d", id);

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        if(rs.next()) c = mapModel(rs);
        if(c == null) throw new ModeloNaoExiste("Competicao",id);
        return c;
    }

    @Override
    public boolean create(Competicao modelo) throws SQLException,ClassNotFoundException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into competicao (nome,centro_aquatico_id,data_competicao,tamanho_piscina)" +
                        "values('%s',%d,'%s',%d);",
                modelo.getNome(),
                modelo.getCentroAquaticoId(),
                modelo.getDataCompeticao(),
                modelo.getTamanhoPiscina()
        );

        Database db = new Database();
        linhasAtualizadas = db.doUpdate(query);
        db.closeConnection();

        return linhasAtualizadas > 0;
    }

    @Override
    public boolean update(Competicao modelo) throws SQLException, ClassNotFoundException {
        int linhasAtualizadas;

        String query = String.format(
                "UPDATE competicao SET nome='%s',centro_aquatico_id=%d,data_competicao='%s',tamanho_piscina=%d where id=%d;",
                modelo.getNome(),
                modelo.getCentroAquaticoId(),
                modelo.getDataCompeticao(),
                modelo.getTamanhoPiscina(),
                modelo.getId()
        );

        Database db = new Database();
        linhasAtualizadas = db.doUpdate(query);
        db.closeConnection();

        return linhasAtualizadas > 0;
    }


    public int getCompeticaoId(Competicao modelo) throws SQLException, ClassNotFoundException {
        int id = 0;

        String query = String.format(
                "Select id from Competicao where nome='%s'and centro_aquatico_id=%d and data_competicao='%s'and tamanho_piscina=%d;",
                modelo.getNome(),
                modelo.getCentroAquaticoId(),
                modelo.getDataCompeticao(),
                modelo.getTamanhoPiscina(),
                modelo.getId()
        );
        ResultSet rs;
        Database db = new Database();
        rs = db.doSelect(query);
        db.closeConnection();

        while(rs.next()) id = rs.getInt("id");

        return id;
    }
}

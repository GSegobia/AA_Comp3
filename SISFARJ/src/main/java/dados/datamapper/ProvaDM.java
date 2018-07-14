package dados.datamapper;

import dados.DataMapper;
import dados.Database;
import dominio.Prova;
import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProvaDM implements DataMapper<Prova> {

    @Override
    public Prova mapModel(ResultSet rs) throws SQLException {
        return new Prova(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("classe_id"),
                rs.getInt("categoria_id"),
                rs.getInt("competicao_id")
        );
    }

    @Override
    public Prova get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        Prova p = null;
        String query = String.format("SELECT * from Prova where id=%d",id);

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        if(rs.next()) p = mapModel(rs);
        if(p == null) throw new ModeloNaoExiste("Prova",id);

        return p;
    }

    @Override
    public boolean create(Prova modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into Prova (nome,classe_id,categoria_id,competicao_id) " +
                        "values('%s',%d,%d,%d);",
                modelo.getNome(),
                modelo.getClasse_id(),
                modelo.getCategoria_id(),
                modelo.getCompeticao_id()
            );

        Database db = new Database();
        linhasAtualizadas = db.doUpdate(query);
        db.closeConnection();

        return linhasAtualizadas > 0;
    }

    @Override
    public boolean update(Prova prova) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Prova> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Prova> Provas = new ArrayList<>();

        Database db = new Database();
        ResultSet rs = db.doSelect("SELECT * from Prova");
        db.closeConnection();

        while(rs.next()) Provas.add(mapModel(rs));
        return Provas;
    }

}

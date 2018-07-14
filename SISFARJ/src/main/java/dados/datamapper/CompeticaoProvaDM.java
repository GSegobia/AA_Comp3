package dados.datamapper;

import dados.DataMapper;
import dados.Database;
import dominio.CompeticaoProva;
import exceptions.ModeloNaoExiste;
import org.apache.commons.lang3.ArrayUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CompeticaoProvaDM implements DataMapper<CompeticaoProva> {

    @Override
    public CompeticaoProva mapModel(ResultSet rs) throws SQLException {
        return new CompeticaoProva(
                rs.getInt("id"),
                rs.getInt("id_prova"),
                rs.getInt("id_atleta")
        );
    }

    @Override
    public CompeticaoProva get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        CompeticaoProva a = null;
        String query = String.format("Select * from competicao_prova where id=%d",id);

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        if(rs.next()) a = mapModel(rs);
        if(a == null) throw new ModeloNaoExiste("Competicao Prova",id);

        return a;
    }

    @Override
    public boolean create(CompeticaoProva modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into competicao_prova (id_prova, id_atleta) " +
                        "values(%d,%d);",
                modelo.getCompeticao_id(),
                modelo.getProva_id()
            );

        Database db = new Database();
        linhasAtualizadas = db.doUpdate(query);
        db.closeConnection();

        return linhasAtualizadas > 0;
    }

    @Override
    public boolean update(CompeticaoProva competicaoProva) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<CompeticaoProva> findAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public int[] findAllProvaInCompeticao(int competicao_id) throws ClassNotFoundException, SQLException {
        int[] listaProvas= {};

        String query = String.format("Select id_atleta from competicao_prova where id_prova=%d",competicao_id);

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        while (rs.next()) listaProvas = ArrayUtils.add(listaProvas,rs.getInt("id_atleta"));
        return listaProvas;
    }
}

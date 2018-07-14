package dados.datamapper;

import dados.DataMapper;
import dados.Database;
import dominio.CentroAquatico;
import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CentroAquaticoDM implements DataMapper<CentroAquatico> {

    @Override
    public CentroAquatico mapModel(ResultSet rs) throws SQLException {
        return new CentroAquatico(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("endereco"),
                rs.getInt("tamanho_piscina"));
    }

    @Override
    public List<CentroAquatico> findAll() throws SQLException, ClassNotFoundException{
        ArrayList<CentroAquatico> centrosAquaticos = new ArrayList<>();

        Database db = new Database();
        ResultSet rs = db.doSelect("SELECT * from centro_aquatico");
        db.closeConnection();

        while(rs.next()) centrosAquaticos.add(mapModel(rs));
        return centrosAquaticos;
    }

    @Override
    public CentroAquatico get(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        CentroAquatico c = null;
        String query = String.format("SELECT * from centro_aquatico where id =%d", id);

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        if(rs.next()) c = mapModel(rs);
        if(c == null) throw new ModeloNaoExiste("Centro Aquatico",id);

        return c;
    }

    @Override
    public boolean create(CentroAquatico modelo) throws SQLException,ClassNotFoundException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into centro_aquatico (nome,endereco,tamanho_piscina)" +
                        "values('%s','%s',%d);",
                modelo.getNome(),
                modelo.getEndereco(),
                modelo.getTamanho_piscina()
        );

        Database db = new Database();
        linhasAtualizadas = db.doUpdate(query);
        db.closeConnection();

        return linhasAtualizadas > 0;
    }

    @Override
    public boolean update(CentroAquatico modelo) throws SQLException, ClassNotFoundException {
        int linhasAtualizadas;

        String query = String.format(
                "UPDATE centro_aquatico SET nome='%s',endereco='%s',tamanho_piscina=%d where id=%d;",
                modelo.getNome(),
                modelo.getEndereco(),
                modelo.getTamanho_piscina(),
                modelo.getId()
        );

        Database db = new Database();
        linhasAtualizadas = db.doUpdate(query);
        db.closeConnection();

        return linhasAtualizadas > 0;
    }
}

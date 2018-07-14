package dados.datamapper;

import dados.DataMapper;
import dados.Database;
import dominio.Atleta;
import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtletaDM implements DataMapper<Atleta> {

    @Override
    public Atleta mapModel(ResultSet rs) throws SQLException {
        return new Atleta(
                rs.getInt("id"),
                rs.getInt("associacao_id"),
                rs.getInt("categoria_id"),
                rs.getString("matricula"),
                rs.getString("nome"),
                rs.getDate("data_nascimento"),
                rs.getDate("data_oficio"),
                rs.getString("numero_oficio"),
                rs.getDate("data_entrada_associacao"),
                rs.getString("num_comprovante_pgto")
        );
    }

    @Override
    public Atleta get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        Atleta a = null;
        String query = String.format("SELECT * FROM Atleta WHERE id=%d",id);

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        if(rs.next()) a = mapModel(rs);
        if(a == null) throw new ModeloNaoExiste("Atleta",id);

        return a;
    }

    @Override
    public boolean create(Atleta modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into Atleta (associacao_id,categoria_id,matricula,nome,data_nascimento,data_oficio,numero_oficio,data_entrada_associacao, num_comprovante_pgto) " +
                        "values(%d,%d,'%s','%s','%s','%s','%s','%s','%s');",
                modelo.getAssociacao_id(),
                modelo.getCategoria_id(),
                modelo.getMatricula(),
                modelo.getNome(),
                modelo.getData_nascimento(),
                modelo.getData_oficio(),
                modelo.getNumero_oficio(),
                modelo.getData_entrada_associacao(),
                modelo.getNum_comprovante_pgto()
            );

        Database db = new Database();
        linhasAtualizadas = db.doUpdate(query);
        db.closeConnection();

        return linhasAtualizadas > 0;
    }

    @Override
    public boolean update(Atleta modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas;

        String query = String.format(
                "UPDATE Atleta SET associacao_id=%d,categoria_id=%d,matricula=\'%s\',nome=\'%s\',data_nascimento=\'%s\'," +
                        "data_oficio=\'%s\',numero_oficio=\'%s\',data_entrada_associacao=\'%s\', num_comprovante_pgto='%s' WHERE id=%d;",
                modelo.getAssociacao_id(),
                modelo.getCategoria_id(),
                modelo.getMatricula(),
                modelo.getNome(),
                modelo.getData_nascimento(),
                modelo.getData_oficio(),
                modelo.getNumero_oficio(),
                modelo.getData_entrada_associacao(),
                modelo.getNum_comprovante_pgto(),
                modelo.getId()
        );

        Database db = new Database();
        linhasAtualizadas = db.doUpdate(query);
        db.closeConnection();

        return linhasAtualizadas > 0;
    }

    @Override
    public List<Atleta> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Atleta> a = new ArrayList<>();

        Database db = new Database();
        ResultSet rs = db.doSelect("SELECT * FROM Atleta");
        db.closeConnection();

        while(rs.next()) a.add(mapModel(rs));
        return a;
    }

}

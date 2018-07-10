package main.java.dados.atleta;

import main.java.dados.DAO;
import main.java.dados.Database;
import main.java.dominio.Atleta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by over on 06/07/18.
 */

public class AtletaDAO implements DAO<Atleta> {

    public Atleta mapModel(ResultSet rs) throws ClassNotFoundException, SQLException {
        Atleta u = new Atleta(
                rs.getInt("id"),
                rs.getInt("associacao_id"),
                rs.getInt("categoria_id"),
                rs.getString("matricula"),
                rs.getString("nome"),
                rs.getString("data_nascimento"),
                rs.getString("data_oficio"),
                rs.getString("numero_oficio"),
                rs.getString("data_entrada_associacao")
        );
        return u;
    }

    public boolean exists(int id) throws ClassNotFoundException, SQLException {
        ResultSet rs = Database.doSelect("Select count(id) from Atleta where id=" +id);
        int numeroOcorrencias = 0;

        while(rs.next()){
            numeroOcorrencias = rs.getInt("count");
        }

        return numeroOcorrencias > 0;
    }

    public Atleta get(int id) throws ClassNotFoundException, SQLException {
        Atleta u = null;
        String query = String.format("Select * from Atleta where id=%d",id);

        ResultSet rs = Database.doSelect(query);

        while(rs.next()){
            u = mapModel(rs);
        }
        return u;
    }

    public boolean create(Atleta modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas = 0;

        String query = String.format(
                "Insert into Atleta (associacao_id,categoria_id,matricula,nome,data_nascimento,data_oficio,numero_oficio,data_entrada_associacao) " +
                        "values(%d,%d,\'%s\',\'%s\',\'%s\',\'%s\',\'%s\',\'%s\');",
                modelo.getAssociacao_id(),
                modelo.getCategoria_id(),
                modelo.getMatricula(),
                modelo.getNome(),
                modelo.getData_nascimento(),
                modelo.getData_oficio(),
                modelo.getNumero_oficio(),
                modelo.getData_entrada_associacao()
            );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
    }

    public boolean update(Atleta modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas;

        String query = String.format(
                "UPDATE Atleta SET associacao_id=%d,categoria_id=%d,matricula=\'%s\',nome=\'%s\',data_nascimento=\'%s\'," +
                        "data_oficio=\'%s\',numero_oficio=\'%s\',data_entrada_associacao=\'%s\' where id=%d;",
                modelo.getAssociacao_id(),
                modelo.getCategoria_id(),
                modelo.getMatricula(),
                modelo.getNome(),
                modelo.getData_nascimento(),
                modelo.getData_oficio(),
                modelo.getNumero_oficio(),
                modelo.getData_entrada_associacao(),
                modelo.getId()
        );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
    }

    public ArrayList<Atleta> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Atleta> Atletas = new ArrayList<Atleta>();
        ResultSet rs = Database.doSelect("Select * from Atleta");

        if(rs.next()){
            do {
                Atletas.add(mapModel(rs));
            } while(rs.next());
        }
        return Atletas;
    }

}

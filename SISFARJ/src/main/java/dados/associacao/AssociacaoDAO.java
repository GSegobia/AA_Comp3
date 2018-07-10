package dados.associacao;

import dados.DAO;
import dados.Database;
import dominio.Associacao;
import dominio.Endereco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Fellipe Bravo on 10/07/18.
 */
public class AssociacaoDAO implements DAO<Associacao> {
    public Associacao mapModel(ResultSet rs) throws ClassNotFoundException, SQLException {
        Endereco endereco = new Endereco(
                rs.getInt("endereco_id"),
                rs.getString("cep"),
                rs.getString("rua"),
                rs.getInt("numero"),
                rs.getString("cidade"),
                rs.getString("estado"),
                rs.getString("complemento")
        );
        Associacao associacao = new Associacao(
                rs.getInt("id"),
                rs.getString("numero_oficio"),
                rs.getDate("data_oficio"),
                rs.getString("nome"),
                rs.getString("sigla"),
                rs.getString("matricula"),
                endereco,
                rs.getString("telefone"),
                rs.getString("num_comprovante_pgto")
        );
        return associacao;
    }

    public boolean exists(int id) throws ClassNotFoundException, SQLException {
        return false;
    }

    public Associacao get(int id) throws ClassNotFoundException, SQLException {
        return null;
    }

    public boolean create(Associacao modelo) throws ClassNotFoundException, SQLException {
        return false;
    }

    public boolean update(Associacao modelo) throws ClassNotFoundException, SQLException {
        return false;
    }

    public ArrayList<Associacao> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Associacao> associacoes = new ArrayList<Associacao>();
        ResultSet rs = Database.doSelect("SELECT a.id,\n" +
                "a.numero_oficio,\n" +
                "a.data_oficio,\n" +
                "a.nome,\n" +
                "a.sigla,\n" +
                "a.matricula,\n" +
                "a.telefone,\n" +
                "a.num_comprovante_pgto,\n" +
                "a.endereco_id,\n" +
                "e.cep,\n" +
                "e.rua,\n" +
                "e.numero,\n" +
                "e.cidade,\n" +
                "e.estado,\n" +
                "e.complemento FROM associacao AS a LEFT JOIN endereco AS e ON e.id = a.endereco_id\n" +
                "ORDER BY\n" +
                "a.nome ASC\n");

        while(rs.next()){
            Associacao u = mapModel(rs);
            associacoes.add(u);
        }

        return associacoes;
    }
}

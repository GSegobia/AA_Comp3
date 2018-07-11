package dados.endereco;

import dados.DAO;
import dados.Database;
import dominio.Endereco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoDAO implements DAO<Endereco> {
    public Endereco mapModel(ResultSet rs) throws ClassNotFoundException, SQLException {
        return new Endereco(
                rs.getInt("id"),
                rs.getString("cep"),
                rs.getString("rua"),
                rs.getInt("numero"),
                rs.getString("cidade"),
                rs.getString("estado"),
                rs.getString("complemento")
        );
    }

    public boolean exists(int id) throws ClassNotFoundException, SQLException {
        return true;
    }

    public Endereco get(int id) throws ClassNotFoundException, SQLException {
        Endereco e = null;

        String query = String.format("Select * from Endereco where id=%d",id);

        ResultSet rs = Database.doSelect(query);

        while(rs.next()){
            e = mapModel(rs);
        }

        return e;
    }

    public boolean create(Endereco modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into Endereco (cep,rua,numero,cidade,estado,complemento) " +
                        "values(\'%s\',\'%s\',%d,\'%s\',\'%s\',\'%s\');",
                modelo.getCep(),
                modelo.getRua(),
                modelo.getNumero(),
                modelo.getCidade(),
                modelo.getEstado(),
                modelo.getComplemento()
        );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
    }

    public boolean update(Endereco modelo) throws ClassNotFoundException, SQLException {
        return true;
    }

    public ArrayList<Endereco> findAll() throws ClassNotFoundException, SQLException {
        return null;
    }
}

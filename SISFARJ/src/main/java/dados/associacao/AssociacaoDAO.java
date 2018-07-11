package dados.associacao;

import dados.DAO;
import dados.Database;
import dominio.Associacao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AssociacaoDAO implements DAO<Associacao> {
    public Associacao mapModel(ResultSet rs) throws ClassNotFoundException, SQLException {
        return new Associacao(
                rs.getInt("id"),
                rs.getString("numero_oficio"),
                rs.getDate("data_oficio"),
                rs.getString("nome"),
                rs.getString("sigla"),
                rs.getString("matricula"),
                rs.getInt("endereco_id"),
                rs.getString("telefone"),
                rs.getString("num_comprovante_pgto")
        );
    }

    public boolean exists(int id) throws ClassNotFoundException, SQLException {
        return false;
    }

    public Associacao get(int id) throws ClassNotFoundException, SQLException {
        Associacao a = null;

        String query = String.format("Select * from Associacao where id=%d",id);

        ResultSet rs = Database.doSelect(query);

        while(rs.next()){
            a = mapModel(rs);
        }

        return a;
    }

    public boolean create(Associacao modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas;

        String query = String.format(
                "Insert into Endereco (numero_oficio,data_oficio,nome,sigla,matricula,endereco_id,telefone,num_comprovante_pgto) " +
                        "values(\'%s\',\'%s\',\'%s\',\'%s\',\'%s\',%d,\'%s\',\'%s\');",
                modelo.getNumeroOficio(),
                modelo.getDataOficio(),
                modelo.getNome(),
                modelo.getSigla(),
                modelo.getMatricula(),
                modelo.getEndereco_id(),
                modelo.getTelefone(),
                modelo.getNumComprovantePgto()
        );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
    }

    public boolean update(Associacao modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas;

        String query = String.format(
                "UPDATE Associacao SET numero_oficio=\'%s\',data_oficio=\'%s\',nome=\'%s\',sigla=\'%s\'," +
                        "matricula=\'%s\',endereco_id=%d,telefone=\'%s\',num_comprovante_pgto=\'%s\' where id=%d;",
                modelo.getNumeroOficio(),
                modelo.getDataOficio(),
                modelo.getNome(),
                modelo.getSigla(),
                modelo.getMatricula(),
                modelo.getEndereco_id(),
                modelo.getTelefone(),
                modelo.getNumComprovantePgto(),
                modelo.getId()
        );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
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

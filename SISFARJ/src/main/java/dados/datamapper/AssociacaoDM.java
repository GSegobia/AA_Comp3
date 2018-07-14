package dados.datamapper;

import dados.DataMapper;
import dados.Database;
import dominio.Associacao;
import exceptions.MatriculaAssociacaoNaoEncontrada;
import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssociacaoDM implements DataMapper<Associacao> {

    @Override
    public Associacao mapModel(ResultSet rs) throws SQLException {
        return new Associacao(
                rs.getInt("id"),
                rs.getString("numero_oficio"),
                rs.getDate("data_oficio"),
                rs.getString("nome"),
                rs.getString("sigla"),
                rs.getString("matricula"),
                rs.getString("endereco"),
                rs.getString("telefone"),
                rs.getString("num_comprovante_pgto")
        );
    }

    @Override
    public Associacao get(int id) throws SQLException, ModeloNaoExiste, ClassNotFoundException {
        Associacao a = null;
        String query = String.format("SELECT * FROM Associacao WHERE id=%d",id);

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        if(rs.next()) a = mapModel(rs);
        if(a == null) throw new ModeloNaoExiste("Associacao", id);

        return a;
    }

    public Associacao get(String matricula) throws ClassNotFoundException, SQLException, MatriculaAssociacaoNaoEncontrada {
        Associacao a = null;
        String query = String.format("SELECT * FROM Associacao WHERE matricula='%s'",matricula);

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        if(rs.next()) a = mapModel(rs);
        if(a == null) throw new MatriculaAssociacaoNaoEncontrada(matricula);

        return a;
    }

    @Override
    public boolean create(Associacao modelo) throws SQLException, ClassNotFoundException {
        int linhasAtualizadas;

        String query = String.format(
                "INSERT INTO Associacao (numero_oficio,data_oficio,nome,sigla,matricula,endereco,telefone,num_comprovante_pgto) " +
                        "VALUES(\'%s\',\'%s\',\'%s\',\'%s\',\'%s\',\'%s\',\'%s\',\'%s\');",
                modelo.getNumeroOficio(),
                modelo.getDataOficio(),
                modelo.getNome(),
                modelo.getSigla(),
                modelo.getMatricula(),
                modelo.getEndereco(),
                modelo.getTelefone(),
                modelo.getNumComprovantePgto()
        );

        Database db = new Database();
        linhasAtualizadas = db.doUpdate(query);
        db.closeConnection();

        return linhasAtualizadas > 0;
    }

    @Override
    public boolean update(Associacao modelo) throws SQLException, ClassNotFoundException {
        int linhasAtualizadas;

        String query = String.format(
                "UPDATE Associacao SET numero_oficio=\'%s\',data_oficio=\'%s\',nome=\'%s\',sigla=\'%s\'," +
                        "matricula=\'%s\',endereco=\'%s\',telefone=\'%s\',num_comprovante_pgto=\'%s\' where id=%d;",
                modelo.getNumeroOficio(),
                modelo.getDataOficio(),
                modelo.getNome(),
                modelo.getSigla(),
                modelo.getMatricula(),
                modelo.getEndereco(),
                modelo.getTelefone(),
                modelo.getNumComprovantePgto(),
                modelo.getId()
        );

        Database db = new Database();
        linhasAtualizadas = db.doUpdate(query);
        db.closeConnection();

        return linhasAtualizadas > 0;
    }

    @Override
    public List<Associacao> findAll() throws SQLException, ClassNotFoundException {
        ArrayList<Associacao> associacoes = new ArrayList<>();

        String query = "SELECT a.id,\n" +
                "a.numero_oficio,\n" +
                "a.data_oficio,\n" +
                "a.nome,\n" +
                "a.sigla,\n" +
                "a.matricula,\n" +
                "a.telefone,\n" +
                "a.num_comprovante_pgto,\n" +
                "a.endereco\n" +
                " FROM associacao AS a\n" +
                "ORDER BY\n" +
                "a.nome ASC\n";

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        while(rs.next()) associacoes.add(mapModel(rs));
        return associacoes;
    }
}

package dados.datamapper;

import dados.DataMapper;
import dados.Database;
import dominio.Usuario;
import exceptions.ModeloNaoExiste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDM implements DataMapper<Usuario> {

    @Override
    public Usuario mapModel(ResultSet rs) throws SQLException {
        return new Usuario(
                rs.getInt("id"),
                rs.getString("matricula"),
                rs.getString("nome"),
                rs.getString("senha"),
                rs.getInt("permissao_id")
        );
    }

    @Override
    public Usuario get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        Usuario u = null;
        String query = String.format("SELECT * from usuario where id=%d",id);

        Database db = new Database();
        ResultSet rs = db.doSelect(query);
        db.closeConnection();

        if(rs.next()) u = mapModel(rs);
        if(u == null) throw new ModeloNaoExiste("Usuario",id);

        return u;
    }

    @Override
    public boolean create(Usuario modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas = 0;

        String query = String.format(
                "Insert into usuario (matricula, nome, senha,permissao_id) values(\'%s\',\'%s\',\'%s\',%d);",
                modelo.getMatricula(), modelo.getNome(), modelo.getSenha(),modelo.getPermissaoId()
            );

        Database db = new Database();
        linhasAtualizadas = db.doUpdate(query);
        db.closeConnection();

        return linhasAtualizadas > 0;
    }

    @Override
    public boolean update(Usuario modelo) throws ClassNotFoundException, SQLException {
        int linhasAtualizadas = 0;

        String query = String.format(
                "UPDATE usuario SET nome=\'%s\', senha=\'%s\',permissao_id=%d where id=%d;",
                modelo.getNome(),modelo.getSenha(),modelo.getPermissaoId(),modelo.getId()
        );

        Database db = new Database();
        linhasAtualizadas = db.doUpdate(query);
        db.closeConnection();

        return linhasAtualizadas > 0;
    }

    @Override
    public List<Usuario> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        Database db = new Database();
        ResultSet rs = db.doSelect("SELECT * from usuario");
        db.closeConnection();

        while(rs.next()) usuarios.add(mapModel(rs));
        return usuarios;
    }
}

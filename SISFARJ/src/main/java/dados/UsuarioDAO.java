package dados;

import dominio.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by over on 06/07/18.
 */

public class UsuarioDAO implements DAO<Usuario> {

    public Usuario mapModel(ResultSet rs) throws ClassNotFoundException, SQLException {
        Usuario u = new Usuario(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("senha"),
                rs.getInt("permissao_id")
        );
        return u;
    }

    public boolean exists(int id) throws ClassNotFoundException, SQLException {
        ResultSet rs = Database.doSelect("Select count(id) from usuario where id=" +id);
        int numeroOcorrencias = 0;

        while(rs.next()){
            numeroOcorrencias = rs.getInt("count");
        }

        return numeroOcorrencias > 0;
    }

    public Usuario get(int id) throws ClassNotFoundException, SQLException {
        Usuario u = null;
        String query = String.format("Select * from usuario where id=%d",id);

        ResultSet rs = Database.doSelect(query);

        while(rs.next()){
            u = mapModel(rs);
        }
        return u;
    }

    public boolean create(Usuario modelo) throws ClassNotFoundException, SQLException {
        Usuario u = modelo;
        int linhasAtualizadas = 0;

        String query = String.format(
                "Insert into usuario (nome,email,senha,permissao_id) values(\'%s\',\'%s\',\'%s\',%d);",
                u.getNome(),u.getEmail(),u.getSenha(),u.getPermissaoId()
            );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
    }

    public boolean update(Usuario modelo) throws ClassNotFoundException, SQLException {
        Usuario u = modelo;
        int linhasAtualizadas = 0;
        String query = String.format(
                "UPDATE usuario SET nome=\'%s\', email=\'%s\', senha=\'%s\',permissao_id=%d where id=%d;",
                u.getNome(),u.getEmail(),u.getSenha(),u.getPermissaoId(),u.getId()
        );

        linhasAtualizadas = Database.doUpdate(query);

        return linhasAtualizadas > 0;
    }

    public ArrayList<Usuario> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Usuario> usuarios = null;
        ResultSet rs = Database.doSelect("Select * from usuario");

        while(rs.next()){
            Usuario u = mapModel(rs);
            usuarios.add(u);
        }

        return usuarios;

    }

}

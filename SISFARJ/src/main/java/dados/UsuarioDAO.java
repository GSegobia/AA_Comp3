package dados;
import dominio.Modelo;
import dominio.Usuario;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by over on 06/07/18.
 */

public class UsuarioDAO extends DAO {

    public Modelo mapModel(ResultSet rs) {
        Usuario u = null;
        try{
            u = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getInt("permissao_id")
            );
        } catch (Exception e){
            System.err.println(e.toString());
        }

        return u;
    }

    public boolean find(int id) {

        try {
            ResultSet rs = Database.doSelect("Select count(id) from usuario where id=" +id);
            int numeroOcorrencias = 0;

            while(rs.next()){
                numeroOcorrencias = rs.getInt("count");
            }

            return numeroOcorrencias > 0;

        } catch(Exception e) {
            System.err.println(e.toString());
        }

        return false;
    }

    public Modelo findAndGet(int id) {
        Usuario u = null;

        try {
            String query = String.format("Select * from usuario where id=%d",id);

            ResultSet rs = Database.doSelect(query);

            while(rs.next()){
                u = (Usuario) mapModel(rs);
            }

        } catch(Exception e) {
            System.err.println(e.toString());
        }

        return u;
    }

    public boolean create(Modelo modelo) {
        Usuario u = (Usuario) modelo;
        int linhasAtualizadas = 0;

        try{
            String query = String.format(
                    "Insert into usuario (nome,email,senha,permissao_id) values(\'%s\',\'%s\',\'%s\',%d);",
                    u.getNome(),u.getEmail(),u.getSenha(),u.getPermissaoId()
                );

            linhasAtualizadas = Database.doUpdate(query);

        } catch (Exception e) {
            System.err.println(e.toString());
        }

        return linhasAtualizadas > 0;
    }

    public boolean update(Modelo modelo) {
        Usuario u = (Usuario) modelo;
        int linhasAtualizadas = 0;

        try{
            String query = String.format(
                    "UPDATE usuario SET nome=\'%s\', email=\'%s\', senha=\'%s\',permissao_id=%d where id=%d;",
                    u.getNome(),u.getEmail(),u.getSenha(),u.getPermissaoId(),u.getId()
            );

            linhasAtualizadas = Database.doUpdate(query);

        } catch (Exception e) {
            System.err.println(e.toString());
        }

        return linhasAtualizadas > 0;
    }

    public ArrayList<Modelo> findAll() {
        ArrayList<Modelo> usuarios = null;

        try {
            ResultSet rs = Database.doSelect("Select * from usuario");

            while(rs.next()){
                Usuario u = (Usuario) mapModel(rs);
                usuarios.add(u);
            }

            return usuarios;

        } catch(Exception e) {
            System.err.println(e.toString());
        }

        return usuarios;

    }

}

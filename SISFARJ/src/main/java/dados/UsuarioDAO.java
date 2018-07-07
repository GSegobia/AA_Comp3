package dados;
import dominio.Usuario;

import java.sql.ResultSet;

/**
 * Created by over on 06/07/18.
 */

public class UsuarioDAO {

    public static boolean find(int id) {

        try {
            ResultSet rs = Database.doQuery("Select count(id) from usuario where id=" +id);
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

    public static Usuario findAndGet(int id) {
        Usuario u = null;

        try {
            ResultSet rs = Database.doQuery("Select * from usuario where id=" +id);

            while(rs.next()){
                u = new Usuario(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),rs.getString("senha"),rs.getInt("permissao_id"));
            }

        } catch(Exception e) {
            System.err.println(e.toString());
        }

        return u;
    }

    public static void main(String[] args) {
    }

}

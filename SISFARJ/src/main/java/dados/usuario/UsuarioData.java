package dados.usuario;

import dominio.Usuario;

import java.sql.SQLException;

/**
 * Created by over on 05/07/18.
 */
public class UsuarioData {

    private static String gerarSenha(){
        return "123456";
    }

    public static Usuario get(int usuarioId) throws SQLException, ClassNotFoundException {
        UsuarioDAO DAO = new UsuarioDAO();
        return DAO.get(usuarioId);
    }

    public static boolean checaExistencia(Usuario usuario) throws SQLException, ClassNotFoundException {
        UsuarioDAO DAO = new UsuarioDAO();
        return DAO.exists(usuario.getId());
    }

    public static boolean checaPermissao(int numeroPermissao, int idUsuario) throws SQLException, ClassNotFoundException {
        return numeroPermissao == getPermissao(idUsuario);
    }

    private static int getPermissao(int idUsuario) throws SQLException, ClassNotFoundException {
        UsuarioDAO DAO = new UsuarioDAO();

        Usuario u = DAO.get(idUsuario);

        return u.getPermissaoId();
    }

    public static boolean create(Usuario usuario) throws SQLException, ClassNotFoundException{
        UsuarioDAO DAO = new UsuarioDAO();

        return DAO.create(usuario);
    }

    public static boolean update(Usuario usuario) throws SQLException, ClassNotFoundException {
        UsuarioDAO DAO = new UsuarioDAO();

        return DAO.update(usuario);
    }

    public static boolean gerarNovaSenha(Usuario usuario) throws SQLException, ClassNotFoundException {
        String novaSenha = gerarSenha();

        usuario.setSenha(novaSenha);

        return update(usuario);
    }
}

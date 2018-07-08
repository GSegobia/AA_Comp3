package dados;

import dominio.Usuario;

import java.sql.SQLException;

/**
 * Created by over on 05/07/18.
 */
public class UsuarioData {

    private Usuario usuario;

    private static String gerarSenha(){
        return "123456";
    }

    public static Usuario get(int usuarioId) throws SQLException, ClassNotFoundException {
        UsuarioDAO DAO = new UsuarioDAO();
        return DAO.get(usuarioId);
    }

    public static Usuario get(String nome, String email) {
        //return UsuarioDAO.get(nome,email);
        return new Usuario(-1,nome,email, "123456", 1);
    }

    public static boolean checaExistencia(Usuario usuario) throws SQLException, ClassNotFoundException {
        UsuarioDAO DAO = new UsuarioDAO();
        return DAO.exists(usuario.getId());
    }

    public static boolean checaPermissao(int numeroPermissao, Usuario usuario) {
        return numeroPermissao == usuario.getPermissaoId();
    }

    private int getPermissao(Usuario usuario) {
        return usuario.getPermissaoId();
    }

    public static boolean create(Usuario usuario) {
        //return UsuarioDAO.create(usuario);
        return true;
    }

    private static boolean update(Usuario usuario) {
        //return UsuarioDAO.update(usuario);
        return true;
    }

    public static boolean gerarNovaSenha(Usuario usuario){
        String novaSenha = gerarSenha();

        usuario.setSenha(novaSenha);

        return update(usuario);
    }
}

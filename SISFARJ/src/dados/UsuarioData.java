package dados;
import dominio.Usuario;
import org.jetbrains.annotations.NotNull;
/**
 * Created by over on 05/07/18.
 */
public class UsuarioData {

    private Usuario usuario;

    private static String gerarSenha(){
        return "123456";
    }

    @NotNull
    public static Usuario get(int usuarioId) {
        //return UsuarioDAO.findAndGetById(usuarioId);
        return new Usuario("Secretario Padrao","secretario-rj@sisfarj.com", "123456", 1);
    }

    @NotNull
    public static Usuario get(String nome, String email) {
        //return UsuarioDAO.findAndGet(nome,email);
        return new Usuario(nome,email, "123456", 1);
    }

    public static boolean checaExistencia(Usuario usuario) {
        //return UsuarioDAO.find(usuario);
        return true;
    }

    public static boolean checaPermissao() {
        return true;
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

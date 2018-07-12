package dominio;

/**
 * Created by Fellipe Bravo on 11/07/18.
 */
public enum PermissaoUsuario {

    DIRETOR_TECNICO(1),
    TECNICO_ASSOCIACAO(2),
    SECRETARIO(3);

    public Integer id;
    PermissaoUsuario(Integer id) {
        this.id = id;
    }

}

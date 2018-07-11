package exceptions;

/**
 * Created by Fellipe Bravo on 11/07/18.
 */
public class NaoPossuiPermissao extends Exception {

    public NaoPossuiPermissao() {
        super("O ator não possui permissão para acessar esta página.");
    }

}

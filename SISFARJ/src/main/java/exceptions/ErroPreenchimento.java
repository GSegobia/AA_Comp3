package exceptions;

/**
 * Created by Fellipe Bravo on 14/07/18.
 */
public class ErroPreenchimento extends Exception {

    public ErroPreenchimento(String modelo) {
        super(String.format("O modelo [%s] não teve todos os seus campos preenchidos corretamente.", modelo));
    }

}

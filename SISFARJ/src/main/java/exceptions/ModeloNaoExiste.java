package exceptions;

public class ModeloNaoExiste extends Exception {

    public ModeloNaoExiste(String nomeModelo, int id) {
        super(String.format("O %s de %d não existe",nomeModelo, id));
    }
}

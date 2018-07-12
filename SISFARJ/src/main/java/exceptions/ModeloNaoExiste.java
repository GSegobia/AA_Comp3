package exceptions;

public class ModeloNaoExiste extends Exception {

    public ModeloNaoExiste(String nomeModelo, int id) {
        super(String.format("O objeto de ID %d, do Modelo %s não existe", id, nomeModelo));
    }
}

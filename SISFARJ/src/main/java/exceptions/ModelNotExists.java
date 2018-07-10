package exceptions;

public class ModelNotExists extends Exception {

    public ModelNotExists(String nomeModelo, int id) {
        super(String.format("O %s de %d não existe",nomeModelo, id));
    }
}

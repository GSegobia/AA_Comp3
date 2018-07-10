package exceptions;

/**
 * Created by Fellipe Bravo on 10/07/18.
 */
public class MatriculaAssociacaoNaoEncontrada extends Exception {

    private String matricula;

    public MatriculaAssociacaoNaoEncontrada(String matricula) {
        super(String.format("A matrícula de associação [%s] não foi encontrada.", matricula));
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

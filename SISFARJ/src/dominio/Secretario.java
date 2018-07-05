package dominio;

/**
 * Created by over on 05/07/18.
 */
public class Secretario extends Usuario {

    public Secretario(String nome,String email, String senha){
        super(nome,email,senha,3);
    }

    public void cadastrarAtleta() {}
    public void alterarAtleta() {}
    public void listarAtletasEdicao() {}
    public void selecionarAtletaEdicao() {}
    public void transferirAtleta() {}

}

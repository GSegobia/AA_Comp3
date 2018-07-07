package dominio;

/**
 * Created by over on 05/07/18.
 */
public class Secretario extends Usuario {

    public Secretario(int id,String nome,String email, String senha){
        super(id,nome,email,senha,3);
    }

    public void cadastrarAtleta() {}
    public void alterarAtleta() {}
    public void listarAtletasEdicao() {}
    public void selecionarAtletaEdicao() {}
    public void transferirAtleta() {}

}

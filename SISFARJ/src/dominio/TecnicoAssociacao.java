package dominio;

import dados.UsuarioData;

/**
 * Created by over on 05/07/18.
 */
public class TecnicoAssociacao extends Usuario {

    public TecnicoAssociacao(String nome,String email, String senha){
        super(nome,email,senha,2);
    }

    public void listarCompeticoesParaInscreverAtleta() {}
    public void selecionaCompeticao() {}
    public void selecionarProvaParaInscricaoAtleta() {}
    public void inscreverAtletaProva() {}

}

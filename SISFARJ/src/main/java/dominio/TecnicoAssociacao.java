package dominio;

/**
 * Created by over on 05/07/18.
 */
public class TecnicoAssociacao extends Usuario {

    public TecnicoAssociacao(int id,String nome, String senha){
        super(id,nome,senha,2);
    }

    public void listarCompeticoesParaInscreverAtleta() {}
    public void selecionaCompeticao() {}
    public void selecionarProvaParaInscricaoAtleta() {}
    public void inscreverAtletaProva() {}

}

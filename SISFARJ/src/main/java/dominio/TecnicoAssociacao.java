package dominio;

/**
 * Created by over on 05/07/18.
 */
public class TecnicoAssociacao extends Usuario {

    public TecnicoAssociacao(int id,String nome, String matricula, String senha, int permissao){
        super(id,nome, matricula, senha, permissao);
    }

    public TecnicoAssociacao(String nome, String matricula, String senha, int permissao){
        super(matricula, nome, senha, permissao);
    }

    public void listarCompeticoesParaInscreverAtleta() {}
    public void selecionaCompeticao() {}
    public void selecionarProvaParaInscricaoAtleta() {}
    public void inscreverAtletaProva() {}

}

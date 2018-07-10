package dominio;

/**
 * Created by over on 05/07/18.
 */
public class DiretorTecnico extends Usuario {

    public DiretorTecnico(int id,String nome, String senha){
        super(id,nome,senha,1);
    }

    public void listarCompeticoes() {}
    public void selecionarCompeticao() {}
    public void selecionarProva() {}
    public void informarTempoProva() {}
    public void informarTerminoLancamentoTempoDaProva() {}

}

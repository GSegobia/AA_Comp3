package dominio;

import java.util.ArrayList;

/**
 * Created by over on 05/07/18.
 */
public class DiretorTecnico extends Secretario {

    public DiretorTecnico(int id,String nome, String matricula, String senha, int permissao){
        super(id,nome, matricula, senha, permissao);
    }

    public ArrayList<Competicao> listarCompeticoes() {

        ArrayList<Competicao> competicoes = Competicao.findAll();

        return competicoes;
    }

    public Competicao selecionarCompeticao(int idCompeticao) {

        Competicao competicao = Competicao.get(idCompeticao);

        return competicao;
    }

    public void selecionarProva() {}
    public void informarTempoProva() {}
    public void informarTerminoLancamentoTempoDaProva() {}

}

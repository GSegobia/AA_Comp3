package dominio;

import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by over on 05/07/18.
 */
public class DiretorTecnico extends Secretario {

    public DiretorTecnico(int id,String nome, String matricula, String senha, int permissao){
        super(id,nome, matricula, senha, permissao);
    }

    public ArrayList<Competicao> listarCompeticoes() throws SQLException, ModeloNaoExiste, ClassNotFoundException {

        ArrayList<Competicao> competicoes = Competicao.findAll();

        return competicoes;
    }

    public Competicao selecionarCompeticao(int idCompeticao) throws SQLException, ModeloNaoExiste, ClassNotFoundException {

        return Competicao.get(idCompeticao);
    }

    public void selecionarProva() {}
    public void informarTempoProva() {}
    public void informarTerminoLancamentoTempoDaProva() {}

}

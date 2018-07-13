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

    public void incluirLocalCompeticao(CentroAquatico centro) throws SQLException, ClassNotFoundException{

        CentroAquatico.create(centro);
    }

    public ArrayList<CentroAquatico> listarLocaisCompeticao() throws SQLException, ClassNotFoundException{

        return CentroAquatico.findAll();
    }

    public void alterarLocalCompeticao(CentroAquatico centro) throws SQLException, ClassNotFoundException{

        CentroAquatico.update(centro);
    }

    public void criarCompeticao(Competicao competicao) throws SQLException, ClassNotFoundException{

        Competicao.create(competicao);
    }

    public void inserirTempoAtleta(ResultadoProva rp) throws SQLException, ClassNotFoundException{
        ResultadoProva.create(rp);
    }

    public void alterarCompeticao(Competicao competicao) throws SQLException, ClassNotFoundException{

        Competicao.update(competicao);
    }

    public ArrayList<Competicao> listarCompeticoes() throws SQLException, ModeloNaoExiste, ClassNotFoundException {

        ArrayList<Competicao> competicoes = Competicao.findAll();

        return competicoes;
    }

    public ArrayList<Prova> listarProvas(int id) throws SQLException, ModeloNaoExiste, ClassNotFoundException {

        ArrayList<Prova> provas = Competicao.listarProvas(id);

        return provas;
    }

    public ArrayList<Atleta> listarAtletaInProva(int id) throws SQLException, ModeloNaoExiste, ClassNotFoundException {

        ArrayList<Atleta> atletas = Prova.listarAtletas(id);

        return atletas;
    }


    public Competicao selecionarCompeticao(int idCompeticao) throws SQLException, ModeloNaoExiste, ClassNotFoundException {

        return Competicao.get(idCompeticao);
    }

    public void selecionarProva() {}
    public void informarTempoProva() {}
    public void informarTerminoLancamentoTempoDaProva() {}

}

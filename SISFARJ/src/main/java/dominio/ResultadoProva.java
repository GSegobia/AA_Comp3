package dominio;

import dados.datamapper.ResultadoProvaDM;
import exceptions.ErroPreenchimento;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;

public class ResultadoProva {

    private String tempo;
    private int prova_id;
    private int atleta_id;
    private String pontuacao;

    public ResultadoProva(String tempo, int prova_id, int atleta_id){
        this.tempo = tempo;
        this.prova_id = prova_id;
        this.atleta_id = atleta_id;
        this.pontuacao = Prova.calcularPontuacao(tempo);
    }

    public ResultadoProva(String tempo, int prova_id, int atleta_id, String pontuacao){
        this.tempo = tempo;
        this.prova_id = prova_id;
        this.atleta_id = atleta_id;
        this.pontuacao = pontuacao;
    }

    public String getTempo(){return  this.tempo;}

    public int getProva_id(){return  this.prova_id;}

    public int getAtleta_id(){return  this.atleta_id;}

    public String getPontuacao(){return  this.pontuacao;}

    public void setTempo(String tempo){ this.tempo = tempo;}

    public void setProva_id(int id){ this.prova_id = id;}

    public void setAtleta_id(int id){ this.atleta_id = id;}

    public void setPontuacao(String pontuacao){ this.pontuacao = pontuacao;}

    public boolean create(ResultadoProva rp) throws SQLException, ClassNotFoundException, ErroPreenchimento {
        if(rp.getTempo().equals("")) throw new ErroPreenchimento(ResultadoProva.class.getName());
        ResultadoProvaDM dm = new ResultadoProvaDM();
        return dm.create(rp);
    }

    public static ArrayList<ResultadoProva> findAllByTempo(int id_competicao, int id_prova) throws SQLException, ModeloNaoExiste, ClassNotFoundException {
        int provaCompeticao = CompeticaoProva.findProvaCompeticao(id_competicao, id_prova);
        ResultadoProvaDM dm = new ResultadoProvaDM();
        return dm.findAllByTempo(provaCompeticao);
    }

    public static ArrayList<ResultadoProva> findAllBy8(int id_competicao, int id_prova) throws SQLException, ModeloNaoExiste, ClassNotFoundException {
        int provaCompeticao = CompeticaoProva.findProvaCompeticao(id_competicao, id_prova);
        ResultadoProvaDM dm = new ResultadoProvaDM();
        return dm.findAllBy8(provaCompeticao);
    }

}

package dominio;

import dados.datamapper.ResultadoProvaDM;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.List;

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

    public static boolean create(ResultadoProva rp) throws SQLException, ClassNotFoundException {
        ResultadoProvaDM dm = new ResultadoProvaDM();
        return dm.create(rp);
    }

    public static List<ResultadoProva> findAllByTempo(int id) throws SQLException, ModeloNaoExiste, ClassNotFoundException {
        ResultadoProvaDM dm = new ResultadoProvaDM();
        return dm.findAllByTempo(id);
    }

}

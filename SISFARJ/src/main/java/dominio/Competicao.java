package dominio;

import java.util.ArrayList;
import java.util.Date;

public class Competicao {

    private int id;
    private String nome;
    private int centroAquaticoId;
    private Date dataCompeticao;
    private int tamanhoPiscina;

    public Competicao(int id, String nome, int centroAquaticoId, Date dataCompeticao, int tamanhoPiscina){
        this.id = id;
        this.nome = nome;
        this.centroAquaticoId = centroAquaticoId;
        this.dataCompeticao = dataCompeticao;
        this.tamanhoPiscina = tamanhoPiscina;
    }

    public Competicao(String nome, int centroAquaticoId, Date dataCompeticao, int tamanhoPiscina){
        this.nome = nome;
        this.centroAquaticoId = centroAquaticoId;
        this.dataCompeticao = dataCompeticao;
        this.tamanhoPiscina = tamanhoPiscina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCentroAquaticoId() {
        return centroAquaticoId;
    }

    public void setCentroAquaticoId(int centroAquaticoId) {
        this.centroAquaticoId = centroAquaticoId;
    }

    public Date getDataCompeticao() {
        return dataCompeticao;
    }

    public void setDataCompeticao(Date dataCompeticao) {
        this.dataCompeticao = dataCompeticao;
    }

    public int getTamanhoPiscina() {
        return tamanhoPiscina;
    }

    public void setTamanhoPiscina(int tamanhoPiscina) {
        this.tamanhoPiscina = tamanhoPiscina;
    }

    public static ArrayList<Competicao> findAll(){

        ArrayList<Competicao> lista = new ArrayList<Competicao>();

        return lista;
    }

    public static Competicao get(int competicaoId){

        Competicao competicao = null;

        return competicao;
    }
}

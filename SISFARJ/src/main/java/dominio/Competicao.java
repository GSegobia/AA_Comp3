package dominio;

import java.util.Date;

public class Competicao {

    private int id;
    private String nome;
    private int centroAquaticoId;
    private Date dataCompeticao;
    private int piscinaId;

    public Competicao(int id, String nome, int centroAquaticoId, Date dataCompeticao, int piscinaId){
        this.id = id;
        this.nome = nome;
        this.centroAquaticoId = centroAquaticoId;
        this.dataCompeticao = dataCompeticao;
        this.piscinaId = piscinaId;
    }

    public Competicao(String nome, int centroAquaticoId, Date dataCompeticao, int piscinaId){
        this.nome = nome;
        this.centroAquaticoId = centroAquaticoId;
        this.dataCompeticao = dataCompeticao;
        this.piscinaId = piscinaId;
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

    public int getPiscinaId() {
        return piscinaId;
    }

    public void setPiscinaId(int piscinaId) {
        this.piscinaId = piscinaId;
    }
}

package dominio;

import dados.datamapper.CompeticaoDM;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
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

    public static ArrayList<Competicao> findAll() throws SQLException, ClassNotFoundException {

        return CompeticaoDM.findAll();
    }

    public static Competicao get(int competicaoId) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        return CompeticaoDM.get(competicaoId);
    }

    public static boolean create(Competicao c) throws SQLException,ClassNotFoundException {
        return CompeticaoDM.create(c);
    }

    public static boolean update(Competicao c) throws SQLException, ClassNotFoundException {
        return CompeticaoDM.update(c);
    }
}

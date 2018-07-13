package dominio;

import dados.datamapper.CompeticaoDM;
import dados.datamapper.CompeticaoProvaDM;
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

    public static ArrayList<Prova> listarProvas(int competicaoId) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        ArrayList<Prova> provas = new ArrayList<Prova>();
        int prova[] = CompeticaoProvaDM.findAllProvaInCompeticao(competicaoId);
        for (int i =0; i < prova.length; i++){
            Prova p = Prova.get(prova[i]);
            if(p ==null){
                throw new ModeloNaoExiste("prova",prova[i]);
            }else{
                provas.add(p);
            }
        }
        return provas;
    }

    public static void create(Competicao c) throws SQLException,ClassNotFoundException {
        CompeticaoDM.create(c);
    }

    public static boolean update(Competicao c) throws SQLException, ClassNotFoundException {
        return CompeticaoDM.update(c);
    }
}

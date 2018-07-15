package dominio;

import dados.datamapper.CompeticaoDM;
import dados.datamapper.CompeticaoProvaDM;
import exceptions.ErroPreenchimento;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public Competicao(String nome, Integer centroAquaticoId, Date dataCompeticao, Integer tamanhoPiscina) {
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

    public static List<Competicao> findAll() throws SQLException, ClassNotFoundException {
        CompeticaoDM dm = new CompeticaoDM();
        return dm.findAll();
    }

    public static Competicao get(int competicaoId) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        CompeticaoDM dm = new CompeticaoDM();
        return dm.get(competicaoId);
    }

    public static List<Prova> listarProvas(int competicaoId) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        ArrayList<Prova> provas = new ArrayList<>();

        CompeticaoProvaDM dm = new CompeticaoProvaDM();
        int prova[] = dm.findAllProvaInCompeticao(competicaoId);

        for (int i =0; i < prova.length; i++){
            Prova p = Prova.get(prova[i]);

            if(p ==null) throw new ModeloNaoExiste("prova",prova[i]);
            else provas.add(p);
        }

        return provas;
    }

    public boolean create(Competicao c) throws SQLException, ClassNotFoundException, ErroPreenchimento {
        if(c.getNome().equals("") || (Integer) c.getCentroAquaticoId() == null || c.getDataCompeticao() == null || (Integer)c.getTamanhoPiscina()== null) throw new ErroPreenchimento(Competicao.class.getName());
        CompeticaoDM dm = new CompeticaoDM();
        return dm.create(c);
    }

    public boolean update(Competicao c) throws SQLException, ClassNotFoundException, ErroPreenchimento {
        if(c.getNome().equals("") || (Integer) c.getCentroAquaticoId() == null || c.getDataCompeticao() == null || (Integer)c.getTamanhoPiscina()== null) throw new ErroPreenchimento(Competicao.class.getName());
        CompeticaoDM dm = new CompeticaoDM();
        return dm.update(c);
    }
}

package dominio;

import dados.datamapper.ProvaDM;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;

public class Prova {

    private int id;
    private String nome;
    private int classe_id;
    private int categoria_id;
    private int competicao_id;
    private int prova_atleta_id;

    public Prova(String nome, int classe_id, int categoria_id, int competicao_id, int prova_atleta_id) {
        this.nome = nome;
        this.classe_id = classe_id;
        this.categoria_id = categoria_id;
        this.competicao_id = competicao_id;
        this.prova_atleta_id = prova_atleta_id;
    }

    public Prova(int id, String nome, int classe_id, int categoria_id, int competicao_id, int prova_atleta_id) {

        this.id = id;
        this.nome = nome;
        this.classe_id = classe_id;
        this.categoria_id = categoria_id;
        this.competicao_id = competicao_id;
        this.prova_atleta_id = prova_atleta_id;
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

    public int getClasse_id() {
        return classe_id;
    }

    public void setClasse_id(int classe_id) {
        this.classe_id = classe_id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public int getCompeticao_id() {
        return competicao_id;
    }

    public void setCompeticao_id(int competicao_id) {
        this.competicao_id = competicao_id;
    }

    public int getProva_atleta_id() {
        return prova_atleta_id;
    }

    public void setProva_atleta_id(int prova_atleta_id) {
        this.prova_atleta_id = prova_atleta_id;
    }

    public static void get(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        ProvaDM.get(id);
    }

    public static void create(Prova prova) throws SQLException, ClassNotFoundException {
        ProvaDM.create(prova);
    }

    public static ArrayList<Prova> findAll() throws SQLException, ClassNotFoundException {
        return ProvaDM.findAll();
    }
}

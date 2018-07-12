package dominio;

import dados.datamapper.CentroAquaticoDM;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;

public class CentroAquatico {
    private int id;
    private String nome;
    private String endereco;
    private int tamanho_piscina;

    public CentroAquatico(int id, String nome, String endereco, int tamanho_piscina) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.tamanho_piscina = tamanho_piscina;
    }

    public CentroAquatico(String nome, String endereco, int tamanho_piscina) {
        this.nome = nome;
        this.endereco = endereco;
        this.tamanho_piscina = tamanho_piscina;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTamanho_piscina() {
        return tamanho_piscina;
    }

    public void setTamanho_piscina(int tamanho_piscina) {
        this.tamanho_piscina = tamanho_piscina;
    }

    public static ArrayList<CentroAquatico> findAll() throws SQLException, ClassNotFoundException {

        return CentroAquaticoDM.findAll();
    }

    public static CentroAquatico get(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {

        return CentroAquaticoDM.get(id);
    }

    public static void create(CentroAquatico c) throws SQLException,ClassNotFoundException {
        CentroAquaticoDM.create(c);
    }

    public static void update(CentroAquatico c) throws SQLException, ClassNotFoundException {
        CentroAquaticoDM.update(c);
    }

}

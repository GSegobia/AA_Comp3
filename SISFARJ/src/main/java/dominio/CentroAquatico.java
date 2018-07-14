package dominio;

import dados.datamapper.CentroAquaticoDM;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.List;

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

    public static List<CentroAquatico> findAll() throws SQLException, ClassNotFoundException {
        CentroAquaticoDM dm = new CentroAquaticoDM();
        return dm.findAll();
    }

    public static CentroAquatico get(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        CentroAquaticoDM dm = new CentroAquaticoDM();
        return dm.get(id);
    }

    public static boolean create(CentroAquatico c) throws SQLException,ClassNotFoundException {
        CentroAquaticoDM dm = new CentroAquaticoDM();
        return dm.create(c);
    }

    public static boolean update(CentroAquatico c) throws SQLException, ClassNotFoundException {
        CentroAquaticoDM dm = new CentroAquaticoDM();
        return dm.update(c);
    }

}

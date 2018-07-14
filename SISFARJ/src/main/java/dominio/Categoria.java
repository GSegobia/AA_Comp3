package dominio;

import dados.datamapper.CategoriaDM;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.List;

public class Categoria {
    private int id;
    private String nome;

    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Categoria(String nome) {
        this.nome = nome;
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

    public Categoria get(int id) throws ClassNotFoundException,SQLException, ModeloNaoExiste {
        CategoriaDM dm = new CategoriaDM();
        return dm.get(id);
    }

    public List<Categoria> findAll() throws ClassNotFoundException, SQLException {
        CategoriaDM dm = new CategoriaDM();
        return dm.findAll();
    }
}

package dominio;

import dados.datamapper.CategoriaDM;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria get(int id) throws ClassNotFoundException,SQLException, ModeloNaoExiste {
        Categoria c = CategoriaDM.get(id);

        if(c==null) {
           throw new ModeloNaoExiste("categoria",id);
        }

        return c;
    }

    public ArrayList<Categoria> findAll() throws ClassNotFoundException, SQLException {
        return CategoriaDM.findAll();
    }
}

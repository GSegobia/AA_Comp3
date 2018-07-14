package dominio;

import dados.datamapper.ClasseDM;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by over on 11/07/18.
 */
public class Classe {
    private int id;
    private String nome;

    public Classe(String nome) {
        this.nome = nome;
    }

    public Classe(int id, String nome) {

        this.id = id;
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

    public Classe get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        ClasseDM dm = new ClasseDM();
        return dm.get(id);
    }

    public List<Classe> findAll() throws ClassNotFoundException, SQLException {
        ClasseDM dm = new ClasseDM();
        return dm.findAll();
    }
}

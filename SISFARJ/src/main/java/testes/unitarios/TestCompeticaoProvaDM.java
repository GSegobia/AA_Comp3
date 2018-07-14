package testes.unitarios;

import dados.datamapper.CompeticaoProvaDM;
import dominio.CompeticaoProva;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testes.mock.MockCompeticaoProvaDM;

import java.sql.SQLException;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestCompeticaoProvaDM {

    CompeticaoProvaDM dm = new MockCompeticaoProvaDM();

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        CompeticaoProva cp = dm.get(1);
        assert(cp != null);
    }

    @Test
    public void getInvalido() {
        Assertions.assertThrows(ModeloNaoExiste.class, () -> {
            dm.get(-1);
        });
    }

    @Test
    public void create() throws SQLException, ClassNotFoundException {
        CompeticaoProva cp = new CompeticaoProva(1,2,1);
        assert(dm.create(cp));
    }

    @Test
    public void createInvalido() throws SQLException, ClassNotFoundException {
        CompeticaoProva cp = new CompeticaoProva(1,1,1);
        assert(!dm.create(cp));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        CompeticaoProva c = dm.get(1);
        assert(c.getProva_id() == 1);
        c.setProva_id(3);
        assert(c.getProva_id() == 3);
        assert(dm.update(c));
    }

    @Test
    public void updateInvalido() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        CompeticaoProva c = dm.get(1);
        assert(c.getProva_id() == 1);
        c.setProva_id(2);
        assert(c.getProva_id() == 2);
        assert(!dm.update(c));
    }

    @Test
    public void findAllProvaInCompeticao() throws SQLException, ClassNotFoundException {
        int[] cp = dm.findAllProvaInCompeticao(1);
        assert(cp.length > 0);
    }

    @Test
    public void findAllProvaInCompeticaoInvalida() throws SQLException, ClassNotFoundException {
        int[] cp = dm.findAllProvaInCompeticao(2);
        assert(cp.length == 0);
    }

}

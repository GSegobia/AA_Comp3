package testes.unitarios;

import dados.datamapper.CategoriaDM;
import dominio.Categoria;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testes.mock.MockCategoriaDM;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestCategoriaDM {

    CategoriaDM dm = new MockCategoriaDM();

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Categoria c = dm.get(1);
        assert(c != null);
    }

    @Test
    public void getInvalido() {
        Assertions.assertThrows(ModeloNaoExiste.class, () -> {
            dm.get(-1);
        });
    }

    @Test
    public void create() throws SQLException, ClassNotFoundException {
        Categoria c = new Categoria("caso_teste");
        assert(dm.create(c));
    }

    @Test
    public void createInvalido() throws SQLException, ClassNotFoundException {
        Categoria c = new Categoria("TESTANDO");
        assert(!dm.create(c));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Categoria c = dm.get(1);
        assert(c.getNome().equals("mock"));
        c.setNome("TESTANDO");
        assert(c.getNome().equals("TESTANDO"));
        assert(dm.update(c));
    }

    @Test
    public void updateInvalido() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Categoria c = dm.get(1);
        assert(c.getNome().equals("mock"));
        c.setNome("TESTANDOa");
        assert(c.getNome().equals("TESTANDOa"));
        assert(!dm.update(c));
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        List<Categoria> c = dm.findAll();
        assert(c != null);
    }

}

package testes.unitarios;

import dados.datamapper.CentroAquaticoDM;
import dominio.CentroAquatico;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testes.mock.MockCentroAquaticoDM;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestCentroAquaticoDM {

    CentroAquaticoDM dm = new MockCentroAquaticoDM();

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        CentroAquatico c = dm.get(1);
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
        CentroAquatico c = new CentroAquatico(1, "caso_teste", "caso_teste", 1);
        assert(dm.create(c));
    }

    @Test
    public void createInvalido() throws SQLException, ClassNotFoundException {
        CentroAquatico c = new CentroAquatico(1, "TESTANDO", "TESTANDO", 1);
        assert(!dm.create(c));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        CentroAquatico c = dm.get(1);
        assert(c.getNome().equals("mock"));
        c.setNome("TESTANDO");
        assert(c.getNome().equals("TESTANDO"));
        assert(dm.update(c));
    }

    @Test
    public void updateInvalido() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        CentroAquatico c = dm.get(1);
        assert(c.getNome().equals("mock"));
        c.setNome("TESTANDOa");
        assert(c.getNome().equals("TESTANDOa"));
        assert(!dm.update(c));
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        List<CentroAquatico> c = dm.findAll();
        assert(c != null);
    }

}

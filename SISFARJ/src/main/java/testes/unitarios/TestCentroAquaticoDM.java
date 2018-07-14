package testes.unitarios;

import dados.datamapper.CentroAquaticoDM;
import dominio.CentroAquatico;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestCentroAquaticoDM {

    CentroAquaticoDM dm = new CentroAquaticoDM();

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
        CentroAquatico c = new CentroAquatico("caso_teste","caso_teste",1);
        assert(dm.create(c));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        CentroAquatico c = CentroAquatico.get(1);
        c.setNome("TESTANDO");
        assert(dm.update(c));
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        List<CentroAquatico> c = dm.findAll();
        assert(c != null);
    }

}

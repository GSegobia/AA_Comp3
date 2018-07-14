package testes.unitarios;

import dados.datamapper.CompeticaoDM;
import dominio.Competicao;
import exceptions.ErroPreenchimento;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testes.mock.MockCompeticaoDM;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestCompeticaoDM {

    CompeticaoDM dm = new MockCompeticaoDM();

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Competicao c = dm.get(1);
        assert(c != null);
    }

    @Test
    public void getInvalido() {
        Assertions.assertThrows(ModeloNaoExiste.class, () -> {
            dm.get(-1);
        });
    }

    @Test
    public void create() throws SQLException, ClassNotFoundException, ErroPreenchimento {
        Competicao c = new Competicao("caso_teste", 1, Calendar.getInstance().getTime(), 1);
        assert(dm.create(c));
    }

    @Test
    public void createInvalido() throws SQLException, ClassNotFoundException {
        Competicao c = new Competicao("TESTANDO", 1, Calendar.getInstance().getTime(), 1);
        assert(!dm.create(c));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Competicao c = dm.get(1);
        assert(c.getNome().equals("mock"));
        c.setNome("TESTANDO");
        assert(c.getNome().equals("TESTANDO"));
        assert(dm.update(c));
    }

    @Test
    public void updateInvalido() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Competicao c = dm.get(1);
        assert(c.getNome().equals("mock"));
        c.setNome("TESTANDOa");
        assert(c.getNome().equals("TESTANDOa"));
        assert(!dm.update(c));
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        List<Competicao> c = dm.findAll();
        assert(c != null);
    }

}

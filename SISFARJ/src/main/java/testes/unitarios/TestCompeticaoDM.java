package testes.unitarios;

import dados.datamapper.CompeticaoDM;
import dominio.Competicao;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestCompeticaoDM {

    CompeticaoDM dm = new CompeticaoDM();

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
    public void create() throws SQLException, ClassNotFoundException {
        Competicao c = new Competicao("caso_teste", 1, Calendar.getInstance().getTime(), 1);
        assert(dm.create(c));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Competicao c = Competicao.get(1);
        c.setNome("TESTANDO");
        assert(dm.update(c));
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        List<Competicao> c = dm.findAll();
        assert(c != null);
    }

}

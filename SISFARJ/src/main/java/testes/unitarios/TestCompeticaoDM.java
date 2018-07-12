package testes.unitarios;

import dados.datamapper.CompeticaoDM;
import dominio.Competicao;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestCompeticaoDM {

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Competicao c = CompeticaoDM.get(1);
        assert(c != null);
    }

    @Test
    public void getInvalido() {
        Assertions.assertThrows(ModeloNaoExiste.class, () -> {
            CompeticaoDM.get(-1);
        });
    }

    @Test
    public void create() throws SQLException, ClassNotFoundException {
        Competicao c = new Competicao("caso_teste", 1, Calendar.getInstance().getTime(), 1);
        assert(CompeticaoDM.create(c));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Competicao c = Competicao.get(1);
        c.setNome("TESTANDO");
        assert(CompeticaoDM.update(c));
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        ArrayList<Competicao> c = CompeticaoDM.findAll();
        assert(c != null);
    }

}

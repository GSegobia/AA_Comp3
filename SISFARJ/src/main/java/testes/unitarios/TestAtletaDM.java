package testes.unitarios;

import dados.datamapper.AtletaDM;
import dominio.Atleta;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testes.mock.MockAtletaDM;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestAtletaDM {

    AtletaDM dm = new MockAtletaDM();

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Atleta a = dm.get(1);
        assert(a != null);
    }

    @Test
    public void getInvalido() {
        Assertions.assertThrows(ModeloNaoExiste.class, () -> {
            dm.get(-1);
        });
    }

    @Test
    public void create() throws SQLException, ClassNotFoundException {
        Atleta a = new Atleta(1, 1, "caso_teste", "caso_teste", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "caso_teste", Calendar.getInstance().getTime(), "caso_teste");
        assert(dm.create(a));
    }

    @Test
    public void createInvalido() throws SQLException, ClassNotFoundException {
        Atleta a = new Atleta(1, 1, "caso_teste", "Esse é um teste inválido", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "caso_teste", Calendar.getInstance().getTime(), "caso_teste");
        assert(!dm.create(a));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Atleta a = dm.get(1);
        assert(a.getNome().equals("mock"));
        a.setNome("TESTANDO");
        assert(a.getNome().equals("TESTANDO"));
        assert(dm.update(a));
    }

    @Test
    public void updateInvalido() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Atleta a = dm.get(1);
        assert(a.getNome().equals("mock"));
        a.setAssociacao_id(2);
        assert(a.getAssociacao_id() == 2);
        assert(!dm.update(a));
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        List<Atleta> a = dm.findAll();
        assert(a != null);
    }

}

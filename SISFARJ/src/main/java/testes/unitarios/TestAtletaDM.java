package testes.unitarios;

import dados.datamapper.AtletaDM;
import dominio.Atleta;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestAtletaDM {

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Atleta a = AtletaDM.get(1);
        assert(a != null);
    }

    @Test
    public void getInvalido() {
        Assertions.assertThrows(ModeloNaoExiste.class, () -> {
            AtletaDM.get(-1);
        });
    }

    @Test
    public void create() throws SQLException, ClassNotFoundException {
        Atleta a = new Atleta(1, 1, "caso_teste", "caso_teste", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "caso_teste", Calendar.getInstance().getTime(), "caso_teste");
        assert(AtletaDM.create(a));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Atleta a = Atleta.get(1);
        a.setNome("TESTANDO");
        assert(AtletaDM.update(a));
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        ArrayList<Atleta> a = AtletaDM.findAll();
        assert(a != null);
    }

}

package testes.unitarios;

import dados.datamapper.ProvaDM;
import dominio.Prova;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestProvaDM {

    ProvaDM dm = new ProvaDM();

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Prova p = dm.get(1);
        assert(p != null);
    }

    @Test
    public void getInvalido() {
        Assertions.assertThrows(ModeloNaoExiste.class, () -> {
            dm.get(-1);
        });
    }

    @Test
    public void create() throws SQLException, ClassNotFoundException {
        Prova p = new Prova("caso_teste",1,1,1);
        assert(dm.create(p));
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        List<Prova> p = dm.findAll();
        assert(p != null);
    }

}

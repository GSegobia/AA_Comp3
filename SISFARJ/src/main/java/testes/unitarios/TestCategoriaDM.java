package testes.unitarios;

import dados.datamapper.CategoriaDM;
import dominio.Categoria;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestCategoriaDM {

    CategoriaDM dm = new CategoriaDM();

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
    public void findAll() throws SQLException, ClassNotFoundException {
        List<Categoria> c = dm.findAll();
        assert(c != null);
    }

}

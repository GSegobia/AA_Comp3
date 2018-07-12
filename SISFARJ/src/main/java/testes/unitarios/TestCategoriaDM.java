package testes.unitarios;

import dados.datamapper.CategoriaDM;
import dominio.Categoria;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestCategoriaDM {

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Categoria c = CategoriaDM.get(1);
        assert(c != null);
    }

    @Test
    public void getInvalido() {
        Assertions.assertThrows(ModeloNaoExiste.class, () -> {
            CategoriaDM.get(-1);
        });
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        ArrayList<Categoria> c = CategoriaDM.findAll();
        assert(c != null);
    }

}

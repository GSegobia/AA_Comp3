package testes.unitarios;

import dados.datamapper.CompeticaoProvaDM;
import dominio.CompeticaoProva;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestCompeticaoProvaDM {

    CompeticaoProvaDM dm = new CompeticaoProvaDM();

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        CompeticaoProva cp = dm.get(1);
        assert(cp != null);
    }

    @Test
    public void getInvalido() {
        Assertions.assertThrows(ModeloNaoExiste.class, () -> {
            dm.get(-1);
        });
    }

    @Test
    public void create() throws SQLException, ClassNotFoundException {
        CompeticaoProva cp = new CompeticaoProva(1,1);
        assert(dm.create(cp));
    }

    @Test
    public void findAllProvaInCompeticao() throws SQLException, ClassNotFoundException {
        int[] cp = dm.findAllProvaInCompeticao(1);
        assert(cp != null);
    }

}

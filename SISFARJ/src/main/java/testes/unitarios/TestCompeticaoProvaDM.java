package testes.unitarios;

import dados.datamapper.CompeticaoDM;
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

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        CompeticaoProva cp = CompeticaoProvaDM.get(1);
        assert(cp != null);
    }

    @Test
    public void getInvalido() {
        Assertions.assertThrows(ModeloNaoExiste.class, () -> {
            CompeticaoDM.get(-1);
        });
    }

    @Test
    public void create() throws SQLException, ClassNotFoundException {
        CompeticaoProva cp = new CompeticaoProva(1,1);
        assert(CompeticaoProvaDM.create(cp));
    }

    @Test
    public void findAllProvaInCompeticao() throws SQLException, ClassNotFoundException {
        int[] cp = CompeticaoProvaDM.findAllProvaInCompeticao(1);
        assert(cp != null);
    }

}

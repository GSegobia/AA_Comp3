package testes.unitarios;

import dados.datamapper.ProvaAtletaDM;
import dominio.ProvaAtleta;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestProvaAtletaDM {

    ProvaAtletaDM dm = new ProvaAtletaDM();

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        ProvaAtleta pa = dm.get(1);
        assert(pa != null);
    }

    @Test
    public void getInvalido() {
        Assertions.assertThrows(ModeloNaoExiste.class, () -> {
            dm.get(-1);
        });
    }

    @Test
    public void create() throws SQLException, ClassNotFoundException {
        ProvaAtleta pa = new ProvaAtleta(1,1);
        assert(dm.create(pa));
    }

    @Test
    public void findAllAtletaInProva() throws SQLException, ClassNotFoundException {
        int[] pa = dm.findAllAtletaInProva(1);
        assert(pa != null);
    }

}

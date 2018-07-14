package testes.unitarios;

import dados.datamapper.ProvaAtletaDM;
import dominio.ProvaAtleta;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testes.mock.MockProvaAtletaDM;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestProvaAtletaDM {

    ProvaAtletaDM dm = new MockProvaAtletaDM();

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
        ProvaAtleta pa = new ProvaAtleta(1,2,3);
        assert(dm.create(pa));
    }

    @Test
    public void createInvalido() throws SQLException, ClassNotFoundException {
        ProvaAtleta pa = new ProvaAtleta(1,1,1);
        assert(!dm.create(pa));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        ProvaAtleta c = dm.get(1);
        assert(c.getProva_id() == 2);
        c.setProva_id(2);
        assert(c.getProva_id() == 2);
        assert(dm.update(c));
    }

    @Test
    public void updateInvalido() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        ProvaAtleta c = dm.get(1);
        assert(c.getProva_id() == 2);
        c.setProva_id(40);
        assert(c.getProva_id() == 40);
        assert(!dm.update(c));
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        List<ProvaAtleta> c = dm.findAll();
        assert(c != null);
    }

    @Test
    public void findAllAtletaInProva() throws SQLException, ClassNotFoundException {
        int[] pa = dm.findAllAtletaInProva(1);
        assert(pa != null);
    }

    @Test
    public void findAllProvaInCompeticaoInvalida() throws SQLException, ClassNotFoundException {
        int[] cp = dm.findAllAtletaInProva(2);
        assert(cp.length == 0);
    }

}

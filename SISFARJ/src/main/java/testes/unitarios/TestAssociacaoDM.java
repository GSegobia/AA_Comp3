package testes.unitarios;

import dados.datamapper.AssociacaoDM;
import dominio.Associacao;
import exceptions.ErroPreenchimento;
import exceptions.MatriculaAssociacaoNaoEncontrada;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testes.mock.MockAssociacaoDM;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestAssociacaoDM {

    AssociacaoDM dm = new MockAssociacaoDM();

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Associacao a = dm.get(1);
        assert(a != null);
    }

    @Test
    public void getInvalido() {
        Assertions.assertThrows(ModeloNaoExiste.class, () -> {
            dm.get(-1);
        });
    }

    @Test
    public void getMatricula() throws SQLException, ClassNotFoundException, MatriculaAssociacaoNaoEncontrada {
        Associacao a = dm.get("mock");
        assert (a != null);
    }

    @Test
    public void getMatriculaInvalida() {
        Assertions.assertThrows(MatriculaAssociacaoNaoEncontrada.class, () -> {
            dm.get("");
        });
    }

    @Test
    public void create() throws SQLException, ClassNotFoundException, ErroPreenchimento, ParseException {
        Associacao a = new Associacao("caso_teste", Calendar.getInstance().getTime(), "caso_teste", "caso_teste", "caso_teste", "caso_teste", "caso_teste", "caso_teste", "caso_teste");
        assert(dm.create(a));
    }

    @Test
    public void createInvalido() throws SQLException, ClassNotFoundException, ErroPreenchimento, ParseException {
        Associacao a = new Associacao("caso_teste", Calendar.getInstance().getTime(), "caso_teste", "testando", "caso_teste", "caso_teste", "caso_teste", "caso_teste", "caso_teste");
        assert(!dm.create(a));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException, MatriculaAssociacaoNaoEncontrada {
        Associacao a = dm.get("mock");
        assert(a.getSigla().equals("mock"));
        a.setSigla("TESTANDO");
        assert(a.getSigla().equals("TESTANDO"));
        assert(dm.update(a));
    }

    @Test
    public void updateInvalido() throws SQLException, ClassNotFoundException, MatriculaAssociacaoNaoEncontrada {
        Associacao a = dm.get("mock");
        assert(a.getSigla().equals("mock"));
        a.setSigla("TESTANDOa");
        assert(a.getSigla().equals("TESTANDOa"));
        assert(!dm.update(a));
    }


    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        List<Associacao> a = dm.findAll();
        assert(a != null);
    }

}

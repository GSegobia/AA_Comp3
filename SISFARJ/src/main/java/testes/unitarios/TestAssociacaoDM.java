package testes.unitarios;

import dados.datamapper.AssociacaoDM;
import dominio.Associacao;
import exceptions.ErroPreenchimento;
import exceptions.MatriculaAssociacaoNaoEncontrada;
import exceptions.ModeloNaoExiste;
import org.easymock.EasyMockSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestAssociacaoDM extends EasyMockSupport {

    AssociacaoDM dm = new AssociacaoDM();

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Associacao a = dm.get(1);
        assert(a != null);
    }

    @Test
    public void getInvalido() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Associacao a = dm.get(-1);
        assert(a == null);
    }

    @Test
    public void getMatricula() throws SQLException, ClassNotFoundException, MatriculaAssociacaoNaoEncontrada {
        Associacao a = dm.get("12838128");
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
        Associacao a = new Associacao("caso_teste", "2018-07-01", "caso_teste", "caso_teste", "caso_teste", "caso_teste", "caso_teste", "caso_teste");
        assert(dm.create(a));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException, MatriculaAssociacaoNaoEncontrada {
        Associacao a = Associacao.get("caso_teste");
        a.setSigla("TESTANDO");
        assert(dm.update(a));
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        List<Associacao> a = dm.findAll();
        assert(a != null);
    }

}

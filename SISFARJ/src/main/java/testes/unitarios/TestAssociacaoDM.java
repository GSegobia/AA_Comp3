package testes.unitarios;

import dados.datamapper.AssociacaoDM;
import dominio.Associacao;
import exceptions.MatriculaAssociacaoNaoEncontrada;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestAssociacaoDM {

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Associacao a = AssociacaoDM.get(1);
        assert(a != null);
    }

    @Test
    public void getInvalido() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Associacao a = AssociacaoDM.get(-1);
        assert(a == null);
    }

    @Test
    public void getMatricula() throws SQLException, ClassNotFoundException, MatriculaAssociacaoNaoEncontrada {
        Associacao a = AssociacaoDM.get("12838128");
        assert (a != null);
    }

    @Test
    public void getMatriculaInvalida() {
        Assertions.assertThrows(MatriculaAssociacaoNaoEncontrada.class, () -> {
            AssociacaoDM.get("");
        });
    }

    @Test
    public void create() throws SQLException, ClassNotFoundException {
        Associacao a = new Associacao("caso_teste", Calendar.getInstance().getTime(), "caso_teste", "caso_teste", "caso_teste", "caso_teste", "caso_teste", "caso_teste");
        assert(AssociacaoDM.create(a));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException, MatriculaAssociacaoNaoEncontrada {
        Associacao a = Associacao.get("caso_teste");
        a.setSigla("TESTANDO");
        assert(AssociacaoDM.update(a));
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        ArrayList<Associacao> a = Associacao.findAll();
        assert(a != null);
    }

}

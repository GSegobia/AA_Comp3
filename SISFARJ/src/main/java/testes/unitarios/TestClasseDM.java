package testes.unitarios;

import dados.datamapper.ClasseDM;
import dominio.Classe;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestClasseDM {

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Classe c = ClasseDM.get(1);
        assert(c != null);
    }

    @Test
    public void getInvalido() {
        Assertions.assertThrows(ModeloNaoExiste.class, () -> {
            ClasseDM.get(-1);
        });
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        ArrayList<Classe> c = ClasseDM.findAll();
        assert(c != null);
    }

}

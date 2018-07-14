package testes.mock;

import dados.datamapper.CompeticaoDM;
import dominio.Competicao;
import exceptions.ErroPreenchimento;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by Fellipe Bravo on 14/07/18.
 */
public class MockCompeticaoDM extends CompeticaoDM {

    Competicao c = new Competicao("mock", 1, Calendar.getInstance().getTime(), 1);

    public MockCompeticaoDM() throws ErroPreenchimento {
    }

    @Override
    public Competicao get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        if(id != 1) throw new ModeloNaoExiste("CentroAquatico",id);
        return c;
    }

    @Override
    public boolean create(Competicao modelo) throws SQLException, ClassNotFoundException {
        return modelo.getNome().equals("caso_teste");
    }

    @Override
    public boolean update(Competicao modelo) throws SQLException, ClassNotFoundException {
        return modelo.getNome().equals("TESTANDO");
    }

    @Override
    public List<Competicao> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Competicao> classes = new ArrayList<>();
        for(int i = 0; i < new Random().nextInt(30); i++) {
            classes.add(c);
        }
        return classes;
    }

}

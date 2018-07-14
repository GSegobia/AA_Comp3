package testes.mock;

import dados.datamapper.ClasseDM;
import dominio.Classe;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Fellipe Bravo on 14/07/18.
 */
public class MockClasseDM extends ClasseDM {

    Classe c = new Classe(1, "mock");

    @Override
    public Classe get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        if(id != 1) throw new ModeloNaoExiste("CentroAquatico",id);
        return c;
    }

    @Override
    public boolean create(Classe modelo) throws SQLException, ClassNotFoundException {
        return modelo.getNome().equals("caso_teste");
    }

    @Override
    public boolean update(Classe modelo) throws SQLException, ClassNotFoundException {
        return modelo.getNome().equals("TESTANDO");
    }

    @Override
    public List<Classe> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Classe> classes = new ArrayList<>();
        for(int i = 0; i < new Random().nextInt(30); i++) {
            classes.add(c);
        }
        return classes;
    }

}

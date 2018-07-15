package testes.mock;

import dados.datamapper.ProvaDM;
import dominio.Prova;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Fellipe Bravo on 14/07/18.
 */
public class MockProvaDM extends ProvaDM {

    Prova p = new Prova(1, "mock", 1 , 1);

    @Override
    public Prova get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        if(id != 1) throw new ModeloNaoExiste("CentroAquatico",id);
        return p;
    }

    @Override
    public boolean create(Prova modelo) throws SQLException, ClassNotFoundException {
        return modelo.getCategoria_id() == 3;
    }

    @Override
    public boolean update(Prova modelo) throws SQLException, ClassNotFoundException {
        return modelo.getNome().equals("TESTANDO");
    }

    @Override
    public List<Prova> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Prova> classes = new ArrayList<>();
        for(int i = 0; i < new Random().nextInt(30); i++) {
            classes.add(p);
        }
        return classes;
    }

}

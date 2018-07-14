package testes.mock;

import dados.datamapper.AtletaDM;
import dominio.Atleta;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by Fellipe Bravo on 14/07/18.
 */
public class MockAtletaDM extends AtletaDM {

    Atleta a = new Atleta(1, 1, 1, "mock", "mock", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "mock", Calendar.getInstance().getTime(), "mock");

    @Override
    public Atleta get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        if(id != 1) throw new ModeloNaoExiste("Atleta",id);
        return a;
    }

    @Override
    public boolean create(Atleta modelo) throws SQLException, ClassNotFoundException {
        return modelo.getNome().equals("caso_teste");
    }

    @Override
    public boolean update(Atleta modelo) throws SQLException, ClassNotFoundException {
        return modelo.getAssociacao_id() == 1;
    }

    @Override
    public List<Atleta> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Atleta> atletas = new ArrayList<>();
        for(int i = 0; i < new Random().nextInt(30); i++) {
            atletas.add(a);
        }
        return atletas;
    }

}

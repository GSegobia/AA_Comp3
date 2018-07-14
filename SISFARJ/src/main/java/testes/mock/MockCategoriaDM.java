package testes.mock;

import dados.datamapper.CategoriaDM;
import dominio.Categoria;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Fellipe Bravo on 14/07/18.
 */
public class MockCategoriaDM extends CategoriaDM {

    Categoria c = new Categoria(1, "mock");

    @Override
    public Categoria get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        if(id != 1) throw new ModeloNaoExiste("Categoria",id);
        return c;
    }

    @Override
    public boolean create(Categoria modelo) throws SQLException, ClassNotFoundException {
        return modelo.getNome().equals("caso_teste");
    }

    @Override
    public boolean update(Categoria modelo) throws SQLException, ClassNotFoundException {
        return modelo.getNome().equals("TESTANDO");
    }

    @Override
    public List<Categoria> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<Categoria> atletas = new ArrayList<>();
        for(int i = 0; i < new Random().nextInt(30); i++) {
            atletas.add(c);
        }
        return atletas;
    }

}

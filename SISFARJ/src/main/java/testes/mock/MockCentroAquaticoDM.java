package testes.mock;

import dados.datamapper.CentroAquaticoDM;
import dominio.CentroAquatico;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Fellipe Bravo on 14/07/18.
 */
public class MockCentroAquaticoDM extends CentroAquaticoDM {

    CentroAquatico ca = new CentroAquatico(1, "mock", "mock", 1);

    @Override
    public CentroAquatico get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        if(id != 1) throw new ModeloNaoExiste("CentroAquatico",id);
        return ca;
    }

    @Override
    public boolean create(CentroAquatico modelo) throws SQLException, ClassNotFoundException {
        return modelo.getNome().equals("caso_teste");
    }

    @Override
    public boolean update(CentroAquatico modelo) throws SQLException, ClassNotFoundException {
        return modelo.getNome().equals("TESTANDO");
    }

    @Override
    public List<CentroAquatico> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<CentroAquatico> atletas = new ArrayList<>();
        for(int i = 0; i < new Random().nextInt(30); i++) {
            atletas.add(ca);
        }
        return atletas;
    }

}

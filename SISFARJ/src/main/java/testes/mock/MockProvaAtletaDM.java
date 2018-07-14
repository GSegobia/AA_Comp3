package testes.mock;

import dados.datamapper.ProvaAtletaDM;
import dominio.ProvaAtleta;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Fellipe Bravo on 14/07/18.
 */
public class MockProvaAtletaDM extends ProvaAtletaDM {

    ProvaAtleta pa = new ProvaAtleta(1, 2, 3);

    @Override
    public ProvaAtleta get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        if(id != 1) throw new ModeloNaoExiste("CentroAquatico",id);
        return pa;
    }

    @Override
    public boolean create(ProvaAtleta modelo) throws SQLException, ClassNotFoundException {
        return modelo.getAtleta_id() == 3;
    }

    @Override
    public boolean update(ProvaAtleta modelo) throws SQLException, ClassNotFoundException {
        return modelo.getProva_id() == 2;
    }

    @Override
    public List<ProvaAtleta> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<ProvaAtleta> classes = new ArrayList<>();
        for(int i = 0; i < new Random().nextInt(30); i++) {
            classes.add(pa);
        }
        return classes;
    }

    @Override
    public int[] findAllAtletaInProva(int idProva) throws ClassNotFoundException, SQLException {
        return idProva == 1 ? new int[]{0,2,3} : new int[]{};
    }
}

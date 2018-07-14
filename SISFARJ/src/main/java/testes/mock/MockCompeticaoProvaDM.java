package testes.mock;

import dados.datamapper.CompeticaoProvaDM;
import dominio.CompeticaoProva;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Fellipe Bravo on 14/07/18.
 */
public class MockCompeticaoProvaDM extends CompeticaoProvaDM {

    CompeticaoProva cp = new CompeticaoProva(1,1,1);

    @Override
    public CompeticaoProva get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        if(id != 1) throw new ModeloNaoExiste("CentroAquatico",id);
        return cp;
    }

    @Override
    public boolean create(CompeticaoProva modelo) throws SQLException, ClassNotFoundException {
        return modelo.getCompeticao_id() == 2;
    }

    @Override
    public boolean update(CompeticaoProva modelo) throws SQLException, ClassNotFoundException {
        return modelo.getProva_id() == 3;
    }

    @Override
    public List<CompeticaoProva> findAll() throws ClassNotFoundException, SQLException {
        ArrayList<CompeticaoProva> classes = new ArrayList<>();
        for(int i = 0; i < new Random().nextInt(30); i++) {
            classes.add(cp);
        }
        return classes;
    }

    @Override
    public int[] findAllProvaInCompeticao(int competicao_id) throws ClassNotFoundException, SQLException {
        return competicao_id == 1 ? new int[]{0,2,3} : new int[]{};
    }
}

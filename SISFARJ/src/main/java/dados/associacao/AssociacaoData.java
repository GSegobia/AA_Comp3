package dados.associacao;

import dominio.Associacao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Fellipe Bravo on 10/07/18.
 */
public class AssociacaoData {

    public static boolean create(Associacao associacao) throws SQLException, ClassNotFoundException{
        AssociacaoDAO DAO = new AssociacaoDAO();
        return DAO.create(associacao);
    }

    public static ArrayList<Associacao> getAll() throws SQLException, ClassNotFoundException {
        AssociacaoDAO DAO = new AssociacaoDAO();
        return DAO.findAll();
    }

    public static boolean update(Associacao associacao) throws SQLException, ClassNotFoundException {
        AssociacaoDAO DAO = new AssociacaoDAO();
        return DAO.update(associacao);
    }

}

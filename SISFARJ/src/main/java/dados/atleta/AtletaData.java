package dados.atleta;

import dominio.Atleta;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;

public class AtletaData {

    public static Atleta get(int AtletaId) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        AtletaDAO DAO = new AtletaDAO();
        Atleta a = DAO.get(AtletaId);

        if(a == null) throw new ModeloNaoExiste("atleta",AtletaId);

        return a;
    }

    public static boolean checaExistencia(int atleta_id) throws SQLException, ClassNotFoundException {
        AtletaDAO DAO = new AtletaDAO();
        return DAO.exists(atleta_id);
    }

    public static boolean create(Atleta atleta) throws SQLException, ClassNotFoundException{
        AtletaDAO DAO = new AtletaDAO();
        return DAO.create(atleta);
    }

    public static boolean update(Atleta atleta) throws SQLException, ClassNotFoundException {
        AtletaDAO DAO = new AtletaDAO();
        return DAO.update(atleta);
    }

    public static ArrayList<Atleta> findAll() throws ClassNotFoundException, SQLException {
        AtletaDAO DAO = new AtletaDAO();
        return DAO.findAll();
    }
}

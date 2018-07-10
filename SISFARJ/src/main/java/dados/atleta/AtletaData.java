package main.java.dados.atleta;
import main.java.dominio.Atleta;
import main.java.exceptions.ModelNotExists;
import java.sql.SQLException;

public class AtletaData {

    public static Atleta get(int AtletaId) throws SQLException, ClassNotFoundException, ModelNotExists {
        AtletaDAO DAO = new AtletaDAO();
        Atleta u = DAO.get(AtletaId);
        if(u == null) throw new ModelNotExists("atleta",AtletaId);
        return DAO.get(AtletaId);
    }

    public static boolean checaExistencia(int atleta_id) throws SQLException, ClassNotFoundException {
        AtletaDAO DAO = new AtletaDAO();
        return DAO.exists(atleta_id);
    }


    public static boolean create(Atleta Atleta) throws SQLException, ClassNotFoundException{
        AtletaDAO DAO = new AtletaDAO();

        return DAO.create(Atleta);
    }

    public static boolean update(Atleta Atleta) throws SQLException, ClassNotFoundException {
        AtletaDAO DAO = new AtletaDAO();

        return DAO.update(Atleta);
    }
}

package dados.atleta;

import dominio.Atleta;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;

public class AtletaData {

    public static Atleta get(int AtletaId) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        AtletaDAO DAO = new AtletaDAO();
        Atleta u = DAO.get(AtletaId);
        if(u == null) throw new ModeloNaoExiste("atleta",AtletaId);
        return DAO.get(AtletaId);
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
}

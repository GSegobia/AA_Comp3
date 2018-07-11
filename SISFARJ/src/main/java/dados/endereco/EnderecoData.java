package dados.endereco;

import dominio.Endereco;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;

public class EnderecoData {

    public static Endereco get(int EnderecoId) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        EnderecoDAO DAO = new EnderecoDAO();
        Endereco e = DAO.get(EnderecoId);
        if(e == null) throw new ModeloNaoExiste("endereco",EnderecoId);
        return e;
    }

    public static boolean create(Endereco endereco) throws SQLException, ClassNotFoundException{
        EnderecoDAO DAO = new EnderecoDAO();
        return DAO.create(endereco);
    }
}

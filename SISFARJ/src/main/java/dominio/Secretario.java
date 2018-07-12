package dominio;

import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by over on 05/07/18.
 */
public class Secretario extends Usuario {

    public Secretario(int id,String nome, String matricula, String senha, int permissao) {
        super(id,nome, matricula, senha,permissao);
    }

    public void cadastrarAtleta(Atleta atleta) throws ClassNotFoundException, SQLException {

        Atleta.create(atleta);
    }

    public void alterarAtleta(Atleta atleta) throws ClassNotFoundException, SQLException {

        Atleta.update(atleta);
    }

    public ArrayList<Atleta> listarAtletas() throws ClassNotFoundException, SQLException{

        return Atleta.findAll();
    }

    public Atleta selecionarAtleta(int idAtleta) throws ClassNotFoundException, SQLException, ModeloNaoExiste {

        return Atleta.get(idAtleta);
    }
    public void transferirAtleta() {}

}

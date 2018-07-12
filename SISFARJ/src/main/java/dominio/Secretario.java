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

    public void filiarAssociacao(Associacao associacao) throws ClassNotFoundException, SQLException, ModeloNaoExiste{

        Usuario tecnico = new TecnicoAssociacao("Técnico " + associacao.getSigla(), associacao.getMatricula(),
                                            "123456", 2);

        Associacao.create(associacao);
        Usuario.create(tecnico);
    }

    public void alterarFiliacao(Associacao associacao) throws ClassNotFoundException, SQLException{

        Associacao.update(associacao);
    }

    public ArrayList<Associacao> listarAssociacao() throws ClassNotFoundException, SQLException {

        return Associacao.findAll();
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
    public void transferirAtleta(int idAssociacao, Atleta atleta) throws ClassNotFoundException, SQLException{

        atleta.setAssociacao_id(idAssociacao);

        Atleta.update(atleta);
    }

}

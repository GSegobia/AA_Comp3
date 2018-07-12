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

    public Secretario(String matricula, String nome, String senha, int permissao) {
        super(matricula, nome, senha, permissao);
    }

    public Secretario(String matricula, String nome, String senha) {
        super(matricula, nome, senha, PermissaoUsuario.SECRETARIO.id);
    }

    public boolean filiarAssociacao(Associacao associacao) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        Usuario tecnico = new TecnicoAssociacao("Tecnico " + associacao.getSigla(), associacao.getMatricula(),
                                            "123456", 2);
        return Associacao.create(associacao) && Usuario.create(tecnico);
    }

    public boolean alterarFiliacao(Associacao associacao) throws ClassNotFoundException, SQLException{
        return Associacao.update(associacao);
    }

    public Associacao selecionarAssociacao(int idAssociacao) throws ClassNotFoundException, SQLException,
                                                            ModeloNaoExiste{
        return Associacao.get(idAssociacao);
    }

    public ArrayList<Associacao> listarAssociacao() throws ClassNotFoundException, SQLException {
        return Associacao.findAll();
    }

    public boolean cadastrarAtleta(Atleta atleta) throws ClassNotFoundException, SQLException {
        return Atleta.create(atleta);
    }

    public boolean alterarAtleta(Atleta atleta) throws ClassNotFoundException, SQLException {
        return Atleta.update(atleta);
    }

    public ArrayList<Atleta> listarAtletas() throws ClassNotFoundException, SQLException{
        return Atleta.findAll();
    }

    public Atleta selecionarAtleta(int idAtleta) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        return Atleta.get(idAtleta);
    }

    public boolean transferirAtleta(int idAssociacao, Atleta atleta) throws ClassNotFoundException, SQLException{
        atleta.setAssociacao_id(idAssociacao);
        return Atleta.update(atleta);
    }

}

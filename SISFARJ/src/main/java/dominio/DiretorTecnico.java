package dominio;

import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by over on 05/07/18.
 */
public class DiretorTecnico extends Secretario {

    public DiretorTecnico(int id,String nome, String matricula, String senha, int permissao){
        super(id,nome, matricula, senha, permissao);
    }

    public DiretorTecnico(String nome, String matricula, String senha){
        super(nome, matricula, senha, PermissaoUsuario.DIRETOR_TECNICO.id);
    }

    public static boolean incluirLocalCompeticao(CentroAquatico centro) throws SQLException, ClassNotFoundException{
        return CentroAquatico.create(centro);
    }

    public static List<CentroAquatico> listarLocaisCompeticao() throws SQLException, ClassNotFoundException{
        return CentroAquatico.findAll();
    }

    public static boolean alterarLocalCompeticao(CentroAquatico centro) throws SQLException, ClassNotFoundException{
        return CentroAquatico.update(centro);
    }

    public static void criarCompeticao(Competicao competicao) throws SQLException, ClassNotFoundException{
        Competicao.create(competicao);
    }

    public static void inserirTempoAtleta(ResultadoProva rp) throws SQLException, ClassNotFoundException{
        ResultadoProva.create(rp);
    }

    public static void alterarCompeticao(Competicao competicao) throws SQLException, ClassNotFoundException{
        Competicao.update(competicao);
    }

    public static List<Competicao> listarCompeticoes() throws SQLException, ClassNotFoundException {
        return Competicao.findAll();
    }

    public static List<Prova> listarProvas(int id) throws SQLException, ModeloNaoExiste, ClassNotFoundException {
        return Competicao.listarProvas(id);
    }

    public static ArrayList<Atleta> listarAtletaInProva(int id) throws SQLException, ModeloNaoExiste, ClassNotFoundException {
        ArrayList<Atleta> atletas = Prova.listarAtletas(id);
        return atletas;
    }

    public static Competicao selecionarCompeticao(int idCompeticao) throws SQLException, ModeloNaoExiste, ClassNotFoundException {
        return Competicao.get(idCompeticao);
    }
}

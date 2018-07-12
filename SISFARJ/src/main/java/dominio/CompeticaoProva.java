package dominio;

import dados.datamapper.CompeticaoProvaDM;
import dados.datamapper.ProvaAtletaDM;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;

public class CompeticaoProva {

    private int competicao_id;
    private int prova_id;

    public CompeticaoProva(int competicao_id, int prova_id) {
        this.competicao_id = competicao_id;
        this.prova_id = prova_id;
    }

    public int getCompeticao_id() {
        return competicao_id;
    }

    public void setCompeticao_id(int competicao_id) {
        this.competicao_id = competicao_id;
    }

    public int getProva_id() {
        return prova_id;
    }

    public void setProva_id(int prova_id) {
        this.prova_id = prova_id;
    }

    public static void get(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        CompeticaoProvaDM.get(id);
    }

    public static void create(CompeticaoProva prova) throws SQLException, ClassNotFoundException {
        CompeticaoProvaDM.create(prova);
    }

    public static int[] findAllProvaInCompeticao(int competicao_id) throws SQLException, ClassNotFoundException {
        return CompeticaoProvaDM.findAllProvaInCompeticao(competicao_id);
    }

}

package dominio;

import dados.datamapper.ProvaAtletaDM;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;

public class ProvaAtleta {

    private int id;
    private int prova_id;
    private int atleta_id;

    public ProvaAtleta(int id, int prova_id, int atleta_id) {
        this.id = id;
        this.prova_id = prova_id;
        this.atleta_id = atleta_id;
    }

    public ProvaAtleta(int prova_id, int atleta_id) {
        this.prova_id = prova_id;
        this.atleta_id = atleta_id;
    }

    public int getProva_id() {
        return prova_id;
    }

    public void setProva_id(int prova_id) {
        this.prova_id = prova_id;
    }

    public int getAtleta_id() {
        return atleta_id;
    }

    public void setAtleta_id(int atleta_id) {
        this.atleta_id = atleta_id;
    }

    public static ProvaAtleta get(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        ProvaAtletaDM dm = new ProvaAtletaDM();
        return dm.get(id);
    }

    public static boolean create(ProvaAtleta prova) throws SQLException, ClassNotFoundException {
        ProvaAtletaDM dm = new ProvaAtletaDM();
        return dm.create(prova);
    }

    public static int[] findAllAtletaInProva(int provaId) throws SQLException, ClassNotFoundException {
        ProvaAtletaDM dm = new ProvaAtletaDM();
        return dm.findAllAtletaInProva(provaId);
    }

}

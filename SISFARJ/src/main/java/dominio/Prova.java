package dominio;

import dados.datamapper.ProvaDM;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Prova {

    private int id;
    private String nome;
    private int classe_id;
    private int categoria_id;
    private int competicao_id;

    public Prova(String nome, int classe_id, int categoria_id, int competicao_id) {
        this.nome = nome;
        this.classe_id = classe_id;
        this.categoria_id = categoria_id;
        this.competicao_id = competicao_id;

    }

    public Prova(int id, String nome, int classe_id, int categoria_id, int competicao_id) {

        this.id = id;
        this.nome = nome;
        this.classe_id = classe_id;
        this.categoria_id = categoria_id;
        this.competicao_id = competicao_id;

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getClasse_id() {
        return classe_id;
    }

    public void setClasse_id(int classe_id) {
        this.classe_id = classe_id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public int getCompeticao_id() {
        return competicao_id;
    }

    public void setCompeticao_id(int competicao_id) {
        this.competicao_id = competicao_id;
    }

    public static boolean create(Prova prova) throws SQLException, ClassNotFoundException {
        ProvaDM dm = new ProvaDM();
        return dm.create(prova);
    }

    public static Prova get(int id) throws ClassNotFoundException,SQLException, ModeloNaoExiste {
        ProvaDM dm = new ProvaDM();
        return dm.get(id);
    }

    public static List<Prova> findAll() throws SQLException, ClassNotFoundException {
        ProvaDM dm = new ProvaDM();
        return dm.findAll();
    }

    public static ArrayList<Atleta> listarAtletas(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        int atleta[] =  ProvaAtleta.findAllAtletaInProva(id);
        ArrayList<Atleta> atletas = new ArrayList<>();

        for(int i = 0; i < atleta.length; i++){
            Atleta a = Atleta.get(atleta[i]);

            if(a == null) throw new ModeloNaoExiste("prova",atleta[i]);
            else atletas.add(a);
        }

        return atletas;
    }

    public static String calcularPontuacao(String tempo) {
        if (tempo.equals("") || Integer.valueOf(tempo) == 0) return "Desclassificado";
        else {
            String timeStamp = new SimpleDateFormat("mmss").format(Calendar.getInstance().getTime());
            return "0" + timeStamp;
        }
    }
}

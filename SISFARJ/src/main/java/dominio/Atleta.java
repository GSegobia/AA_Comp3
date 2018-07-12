package dominio;

import dados.datamapper.AtletaDM;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Atleta {

    private int id,associacao_id,categoria_id;
    private String matricula,nome,numero_oficio;
    private Date data_nascimento, data_entrada_associacao, data_oficio;

    public Atleta(int id, int associacao_id, int categoria_id, String matricula, String nome, Date data_nascimento,
                  Date data_oficio, String numero_oficio, Date data_entrada_associacao) {
        this.id = id;
        this.associacao_id = associacao_id;
        this.categoria_id = categoria_id;
        this.matricula = matricula;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.data_oficio = data_oficio;
        this.numero_oficio = numero_oficio;
        this.data_entrada_associacao = data_entrada_associacao;

    }

    public Atleta(int associacao_id, int categoria_id, String matricula, String nome, Date data_nascimento,
                  Date data_oficio, String numero_oficio, Date data_entrada_associacao) {
        this.associacao_id = associacao_id;
        this.categoria_id = categoria_id;
        this.matricula = matricula;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.data_oficio = data_oficio;
        this.numero_oficio = numero_oficio;
        this.data_entrada_associacao = data_entrada_associacao;

    }

    public int getId() {
        return id;
    }

    public int getAssociacao_id() {
        return associacao_id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public Date getData_oficio() {
        return data_oficio;
    }

    public String getNumero_oficio() {
        return numero_oficio;
    }

    public Date getData_entrada_associacao() {
        return data_entrada_associacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAssociacao_id(int associacao_id) {
        this.associacao_id = associacao_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setData_oficio(Date data_oficio) {
        this.data_oficio = data_oficio;
    }

    public void setNumero_oficio(String numero_oficio) {
        this.numero_oficio = numero_oficio;
    }

    public void setData_entrada_associacao(Date data_entrada_associacao) {
        this.data_entrada_associacao = data_entrada_associacao;
    }

    public static Atleta get(int id) throws ClassNotFoundException,SQLException, ModeloNaoExiste {
        Atleta a = AtletaDM.get(id);

        if(a==null){
            throw new ModeloNaoExiste("atleta",id);
        }

        return a;
    }

    public static boolean create(Atleta atleta) throws ClassNotFoundException,SQLException {
        return AtletaDM.create(atleta);
    }
    public static boolean update(Atleta atleta) throws ClassNotFoundException,SQLException {
        return AtletaDM.update(atleta);
    }

    public static ArrayList<Atleta> findAll() throws ClassNotFoundException,SQLException {
        return AtletaDM.findAll();
    }
}

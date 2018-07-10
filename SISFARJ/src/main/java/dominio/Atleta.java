package main.java.dominio;

public class Atleta {

    private int id,associacao_id,categoria_id;
    private String matricula,nome,data_nascimento,data_oficio,numero_oficio,data_entrada_associacao;

    public Atleta(int id, int associacao_id, int categoria_id, String matricula, String nome, String data_nascimento, String data_oficio, String numero_oficio, String data_entrada_associacao) {
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

    public String getData_nascimento() {
        return data_nascimento;
    }

    public String getData_oficio() {
        return data_oficio;
    }

    public String getNumero_oficio() {
        return numero_oficio;
    }

    public String getData_entrada_associacao() {
        return data_entrada_associacao;
    }


}

package dominio;

import java.sql.Date;

/**
 * Created by Fellipe Bravo on 10/07/18.
 */
public class Associacao {
    private Integer id;
    private String numeroOficio;
    private Date dataOficio;
    private String nome;
    private String sigla;
    private String matricula;
    private Endereco endereco;
    private String telefone;
    private String numComprovantePgto;

    public Associacao(Integer id, String numeroOficio, Date dataOficio, String nome, String sigla, String matricula, Endereco endereco, String telefone, String numComprovantePgto) {
        this.id = id;
        this.numeroOficio = numeroOficio;
        this.dataOficio = dataOficio;
        this.nome = nome;
        this.sigla = sigla;
        this.matricula = matricula;
        this.endereco = endereco;
        this.telefone = telefone;
        this.numComprovantePgto = numComprovantePgto;
    }

    public Associacao(String numeroOficio, Date dataOficio, String nome, String sigla, String matricula, Endereco endereco, String telefone, String numComprovantePgto) {
        this.numeroOficio = numeroOficio;
        this.dataOficio = dataOficio;
        this.nome = nome;
        this.sigla = sigla;
        this.matricula = matricula;
        this.endereco = endereco;
        this.telefone = telefone;
        this.numComprovantePgto = numComprovantePgto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroOficio() {
        return numeroOficio;
    }

    public void setNumeroOficio(String numeroOficio) {
        this.numeroOficio = numeroOficio;
    }

    public Date getDataOficio() {
        return dataOficio;
    }

    public void setDataOficio(Date dataOficio) {
        this.dataOficio = dataOficio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNumComprovantePgto() {
        return numComprovantePgto;
    }

    public void setNumComprovantePgto(String numComprovantePgto) {
        this.numComprovantePgto = numComprovantePgto;
    }
}

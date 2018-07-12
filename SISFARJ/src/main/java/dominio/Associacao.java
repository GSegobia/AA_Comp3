package dominio;

import dados.datamapper.AssociacaoDM;
import exceptions.ModeloNaoExiste;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

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
    private String endereco;
    private String telefone;
    private String numComprovantePgto;

    public Associacao(Integer id, String numeroOficio, Date dataOficio, String nome, String sigla, String matricula, String endereco, String telefone, String numComprovantePgto) {
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

    public Associacao(String numeroOficio, Date dataOficio, String nome, String sigla, String matricula, String endereco, String telefone, String numComprovantePgto) {
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
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

    public static Associacao get(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Associacao a = AssociacaoDM.get(id);

        if(a == null){
            throw new ModeloNaoExiste("associacao",id);
        }

        return AssociacaoDM.get(id);
    }

    public static boolean create(Associacao a) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        return AssociacaoDM.create(a);
    }

    public static boolean update(Associacao a) throws SQLException, ClassNotFoundException{
        return AssociacaoDM.update(a);
    }

    public static ArrayList<Associacao> findAll() throws SQLException, ClassNotFoundException {
        return AssociacaoDM.findAll();
    }
}

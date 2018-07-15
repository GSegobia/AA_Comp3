package dominio;

import dados.datamapper.AssociacaoDM;
import exceptions.DadosIdentificacaoIncorretos;
import exceptions.ErroPreenchimento;
import exceptions.MatriculaAssociacaoNaoEncontrada;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Fellipe Bravo on 10/07/18.
 */
public class Associacao {
    private int id;
    private String numeroOficio;
    private Date dataOficio;
    private String nome;
    private String sigla;
    private String matricula;
    private String senha;
    private String endereco;
    private String telefone;
    private String numComprovantePgto;

    public Associacao(int id, String numeroOficio, Date dataOficio, String nome, String sigla, String matricula, String endereco, String telefone, String numComprovantePgto, String senha) {

        this.id = id;
        this.numeroOficio = numeroOficio;
        this.dataOficio = dataOficio;
        this.nome = nome;
        this.sigla = sigla;
        this.matricula = matricula;
        this.endereco = endereco;
        this.telefone = telefone;
        this.numComprovantePgto = numComprovantePgto;
        this.senha = senha;


    }

    public Associacao(String numeroOficio, Date dataOficio, String nome, String sigla, String matricula, String endereco, String telefone, String numComprovantePgto, String senha) throws ErroPreenchimento, ParseException {


        this.numeroOficio = numeroOficio;
        this.dataOficio = dataOficio;
        this.nome = nome;
        this.sigla = sigla;
        this.matricula = matricula;
        this.endereco = endereco;
        this.telefone = telefone;
        this.numComprovantePgto = numComprovantePgto;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
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

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public static Associacao get(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        AssociacaoDM dm = new AssociacaoDM();
        return dm.get(id);
    }

    public static Associacao get(String matricula) throws SQLException, ClassNotFoundException, MatriculaAssociacaoNaoEncontrada {
        AssociacaoDM dm = new AssociacaoDM();
        return dm.get(matricula);
    }

    public boolean create() throws SQLException, ClassNotFoundException, ErroPreenchimento {

        if(this.nome.equals("") || this.sigla.equals("") || this.numeroOficio.equals("") || this.telefone.equals("") ||
                this.dataOficio == null || this.numComprovantePgto.equals("") || this.endereco.equals("") ||
                this.senha.equals("") || this.matricula.equals(""))
            throw new ErroPreenchimento(Associacao.class.getName());

        AssociacaoDM dm = new AssociacaoDM();
        return dm.create(this);
    }

    public boolean update() throws SQLException, ClassNotFoundException, ErroPreenchimento{
        if(this.id == 0 ||  this.nome.equals("") || this.sigla.equals("") || this.numeroOficio.equals("") || this.telefone.equals("") ||
                this.dataOficio == null || this.numComprovantePgto.equals("") || this.endereco.equals("") ||
                this.senha.equals("") || this.matricula.equals(""))
            throw new ErroPreenchimento(Associacao.class.getName());

        AssociacaoDM dm = new AssociacaoDM();
        return dm.update(this);
    }

    public static List<Associacao> findAll() throws SQLException, ClassNotFoundException {
        AssociacaoDM dm = new AssociacaoDM();
        return dm.findAll();
    }

    public static Associacao identificar(String matricula, String senha) throws SQLException, ClassNotFoundException, DadosIdentificacaoIncorretos {
        AssociacaoDM dm = new AssociacaoDM();
        return dm.get(matricula, senha);
    }

    public String geraSenha(){
        return "123456";
    }
}

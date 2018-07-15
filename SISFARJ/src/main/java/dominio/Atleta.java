package dominio;

import dados.datamapper.AtletaDM;
import exceptions.ErroPreenchimento;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Atleta {

    private int id,associacao_id,categoria_id;
    private String matricula,nome,numero_oficio,num_comprovante_pgto;
    private Date data_nascimento, data_entrada_associacao, data_oficio;

    public Atleta(int id, int associacao_id, int categoria_id, String matricula, String nome, Date data_nascimento,
                  Date data_oficio, String numero_oficio, Date data_entrada_associacao, String num_comprovante_pgto) {

            this.id = id;
            this.associacao_id = associacao_id;
            this.categoria_id = categoria_id;
            this.matricula = matricula;
            this.nome = nome;
            this.data_nascimento = data_nascimento;
            this.data_oficio = data_oficio;
            this.numero_oficio = numero_oficio;
            this.data_entrada_associacao = data_entrada_associacao;
            this.num_comprovante_pgto = num_comprovante_pgto;
    }

    public Atleta(int associacao_id, int categoria_id, String matricula, String nome, Date data_nascimento,
                  Date data_oficio, String numero_oficio, Date data_entrada_associacao, String num_comprovante_pgto) {

        this.associacao_id = associacao_id;
        this.categoria_id = categoria_id;
        this.matricula = matricula;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.data_oficio = data_oficio;
        this.numero_oficio = numero_oficio;
        this.data_entrada_associacao = data_entrada_associacao;
        this.num_comprovante_pgto = num_comprovante_pgto;

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

    public String getNum_comprovante_pgto() {
        return num_comprovante_pgto;
    }

    public void setNum_comprovante_pgto(String num_comprovante_pgto) {
        this.num_comprovante_pgto = num_comprovante_pgto;
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

    public static Atleta get(int id) throws ClassNotFoundException, SQLException, ModeloNaoExiste {
        AtletaDM dm = new AtletaDM();
        return dm.get(id);
    }

    public String gerarMatricula() {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        return "002018" + timeStamp;
    }

    public boolean create() throws ClassNotFoundException, SQLException, ErroPreenchimento {

        if (this.associacao_id == 0 || this.categoria_id == 0 || this.matricula.equals("") ||
                this.nome.equals("") || this.data_nascimento == null || this.data_oficio == null ||
                this.numero_oficio.equals("") || this.data_entrada_associacao.equals("") ||
                this.num_comprovante_pgto.equals("")) {

            throw new ErroPreenchimento(Atleta.class.getName());
        } else{

            AtletaDM dm = new AtletaDM();
            return dm.create(this);
        }
    }

    public boolean update() throws ClassNotFoundException, SQLException, ErroPreenchimento {

        if (this.id == 0 || this.associacao_id == 0 || this.categoria_id == 0 || this.matricula.equals("") ||
                this.nome.equals("") || this.data_nascimento == null || this.data_oficio == null ||
                this.numero_oficio.equals("") || this.data_entrada_associacao.equals("") ||
                this.num_comprovante_pgto.equals("")) {

            throw new ErroPreenchimento(Atleta.class.getName());
        } else {

            AtletaDM dm = new AtletaDM();
            return dm.update(this);
        }
    }

    public static List<Atleta> findAll() throws ClassNotFoundException, SQLException {
        AtletaDM dm = new AtletaDM();
        return dm.findAll();
    }
}

package dominio;

import dados.datamapper.UsuarioDM;
import exceptions.DadosIdentificacaoIncorretos;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;

/**
 * Created by over on 05/07/18.
 */
public class Usuario {
    private int id;
    private String matricula;
    private String nome;
    private String senha;
    private int permissao_id;

    public Usuario(int id,String nome, String matricula, String senha, int permissao_id){
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
        this.permissao_id = permissao_id;
    }

    public Usuario(String matricula, String nome, String senha, int permissao_id) {

        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
        this.permissao_id = permissao_id;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPermissao_id() {
        return permissao_id;
    }
    public void setPermissao_id(int permissao_id) {
        this.permissao_id = permissao_id;
    }
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public String getSenha(){
        return this.senha;
    }
    public int getPermissaoId() {
        return this.permissao_id;
    }
    public void setSenha(String novaSenha){
        this.senha = novaSenha;
    }

    public static Usuario get(int id) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        return UsuarioDM.get(id);
    }

    public static boolean create(Usuario usuario) throws SQLException, ClassNotFoundException{
        return UsuarioDM.create(usuario);
    }

    public static boolean update(Usuario usuario) throws SQLException, ClassNotFoundException {
        return UsuarioDM.update(usuario);
    }

    public static boolean checaPermissao(int numeroPermissao, int idUsuario) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        return numeroPermissao == UsuarioDM.get(idUsuario).getPermissaoId();
    }

    private static String gerarSenha(){
        return "123456";
    }

    public static Usuario identificar(String matricula, String senha) throws SQLException, ClassNotFoundException, DadosIdentificacaoIncorretos {
        return UsuarioDM.get(matricula, senha);
    }
}

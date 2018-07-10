package dominio;

import dados.usuario.UsuarioData;
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

    public void setId(int id) {
        this.id = id;
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

    public static Usuario getUsuario(int usuarioId) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        return UsuarioData.get(usuarioId);
    }

    public static boolean criarUsuario(int id,String nome, String matricula, String senha, int permissao_id) throws SQLException, ClassNotFoundException{
        Usuario novo_usuario = new Usuario(id, nome, matricula, senha, permissao_id);

        return UsuarioData.create(novo_usuario);
    }

    public static boolean updateUsuario(int id, String nome, String matricula, String senha, int permissao_id) throws SQLException, ClassNotFoundException {
        Usuario usuarioAtualizado = new Usuario(id, nome, matricula, senha, permissao_id);

        return UsuarioData.update(usuarioAtualizado);
    }

    public static boolean updateUsuario(Usuario usuarioAtualizado) throws SQLException, ClassNotFoundException {
        return UsuarioData.update(usuarioAtualizado);
    }

    public static boolean checaPermissao(int numeroPermissao, int idUsuario) throws SQLException, ClassNotFoundException {
        return UsuarioData.checaPermissao(numeroPermissao,idUsuario);
    }

    public static boolean solicitarNovaSenha(int idUsuario) throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        return UsuarioData.gerarNovaSenha(getUsuario(idUsuario));
    }

    public static Usuario identificar(String matricula, String senha) throws SQLException, ClassNotFoundException, DadosIdentificacaoIncorretos {
        return UsuarioData.identificar(matricula, senha);
    }
}

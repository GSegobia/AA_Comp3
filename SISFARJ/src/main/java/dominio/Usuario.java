package dominio;
import dados.UsuarioData;

import java.sql.SQLException;

/**
 * Created by over on 05/07/18.
 */
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private int permissao_id;

    public Usuario(int id,String nome,String email, String senha, int permissao_id){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.permissao_id = permissao_id;
    }

    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public String getEmail() {
        return this.email;
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

    public Usuario getUsuario(int usuarioId) throws SQLException, ClassNotFoundException {
        return UsuarioData.get(usuarioId);
    }

    public boolean criarUsuario(int id,String nome,String email, String senha, int permissao_id) throws SQLException, ClassNotFoundException{
        Usuario novo_usuario = new Usuario(id,nome,email, senha, permissao_id);
        return UsuarioData.create(novo_usuario);
    }

    public boolean updateUsuario(int id,String nome,String email, String senha, int permissao_id) throws SQLException, ClassNotFoundException {
        Usuario usuarioAtualizado = new Usuario(id,nome,email, senha, permissao_id);

        return UsuarioData.update(usuarioAtualizado);
    }

    public boolean checaPermissao(int numeroPermissao, int idUsuario) throws SQLException, ClassNotFoundException {
        return UsuarioData.checaPermissao(numeroPermissao,idUsuario);
    }

    public boolean solicitarNovaSenha(int idUsuario) throws SQLException, ClassNotFoundException {
        return UsuarioData.gerarNovaSenha(this.getUsuario(idUsuario));
    }

    public boolean verificarExistencia(int idUsuario) throws SQLException, ClassNotFoundException {
        return UsuarioData.checaExistencia(this.getUsuario(idUsuario));
    }
}

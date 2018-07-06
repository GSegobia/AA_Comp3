package dominio;
import dados.UsuarioData;

/**
 * Created by over on 05/07/18.
 */
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private int permissao_id;

    public Usuario(String nome,String email, String senha, int permissao_id){
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

    public void setSenha(String novaSenha){
        this.senha = novaSenha;
    }

    public Usuario getUsuario(int id) {
        return UsuarioData.get(id);
    }

    public boolean checaPermissao(int numeroPermissao){
        return numeroPermissao == this.getPermissaoId();
    }

    public int getPermissaoId() {
        return this.permissao_id;
    }

    public boolean criarUsuario(String nome,String email, String senha, int permissao_id) {
        Usuario novo_usuario = new Usuario(nome,email, senha, permissao_id);

        return UsuarioData.create(novo_usuario);
    }

    public boolean solicitarNovaSenha() {
        return UsuarioData.gerarNovaSenha(this.getUsuario(this.id));
    }

    public boolean verificarExistencia() {
        return UsuarioData.checaExistencia(this.getUsuario(this.id));
    }
}

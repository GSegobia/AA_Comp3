package testes.unitarios;

import dados.datamapper.UsuarioDM;
import dominio.DiretorTecnico;
import dominio.Secretario;
import dominio.Usuario;
import exceptions.DadosIdentificacaoIncorretos;
import exceptions.ModeloNaoExiste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Fellipe Bravo on 12/07/18.
 */
public class TestUsuarioDM {

    @Test
    public void get() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Usuario u = UsuarioDM.get(1);
        assert(u != null);
    }

    @Test
    public void getInvalido() {
        Assertions.assertThrows(ModeloNaoExiste.class, () -> {
            UsuarioDM.get(-1);
        });
    }

    @Test
    public void getMatricula() throws SQLException, ClassNotFoundException, DadosIdentificacaoIncorretos {
        Usuario u = UsuarioDM.get("teste", "teste");
        assert(u != null);
    }

    @Test
    public void getMatriculaInvalida() {
        Assertions.assertThrows(DadosIdentificacaoIncorretos.class, () -> {
            UsuarioDM.get("","");
        });
    }

    @Test
    public void createDiretorTecnico() throws SQLException, ClassNotFoundException {
        DiretorTecnico u = new DiretorTecnico("caso_teste", "caso_teste", "caso_teste");
        assert(UsuarioDM.create(u));
    }

    @Test
    public void createSecretario() throws SQLException, ClassNotFoundException {
        Secretario u = new Secretario("caso_teste", "caso_teste", "caso_teste");
        assert(UsuarioDM.create(u));
    }

    @Test
    public void createTecnicoAssociacao() throws SQLException, ClassNotFoundException {
        DiretorTecnico u = new DiretorTecnico("caso_teste", "caso_teste", "caso_teste");
        assert(UsuarioDM.create(u));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException, ModeloNaoExiste {
        Usuario u = Usuario.get(1);
        u.setNome("TESTANDO");
        assert(UsuarioDM.update(u));
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        ArrayList<Usuario> u = UsuarioDM.findAll();
        assert(u != null);
    }

}

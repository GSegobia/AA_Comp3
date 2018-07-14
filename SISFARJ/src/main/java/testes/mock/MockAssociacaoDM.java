package testes.mock;

import dados.datamapper.AssociacaoDM;
import dominio.Associacao;
import exceptions.DadosIdentificacaoIncorretos;
import exceptions.MatriculaAssociacaoNaoEncontrada;
import exceptions.ModeloNaoExiste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by Fellipe Bravo on 14/07/18.
 */
public class MockAssociacaoDM extends AssociacaoDM {

    Associacao a = new Associacao(1,"mock", Calendar.getInstance().getTime(), "mock", "mock", "mock", "mock", "mock", "mock");

    @Override
    public Associacao get(int id) throws SQLException, ModeloNaoExiste, ClassNotFoundException {
        if(id != 1) throw new ModeloNaoExiste("Associacao", id);
        return a;
    }

    public Associacao get(String matricula) throws ClassNotFoundException, SQLException, MatriculaAssociacaoNaoEncontrada {
        if(!matricula.equals("mock")) throw new MatriculaAssociacaoNaoEncontrada(matricula);
        return a;
    }

    public Associacao get(String matricula, String senha) throws ClassNotFoundException, SQLException, DadosIdentificacaoIncorretos {
        if(!matricula.equals("mock") && !senha.equals("mock")) throw new DadosIdentificacaoIncorretos();
        return a;
    }

    @Override
    public boolean create(Associacao modelo) throws SQLException, ClassNotFoundException {
        return true;
    }

    @Override
    public boolean update(Associacao modelo) throws SQLException, ClassNotFoundException {
        return true;
    }

    @Override
    public List<Associacao> findAll() throws SQLException, ClassNotFoundException {
        ArrayList<Associacao> associacoes = new ArrayList<>();
        for(int i = 0; i < new Random().nextInt(30); i++) {
            associacoes.add(a);
        }
        return associacoes;
    }
}

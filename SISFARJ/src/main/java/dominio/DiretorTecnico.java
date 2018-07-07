    package dominio;

    /**
     * Created by over on 05/07/18.
     */
    public class DiretorTecnico extends Usuario {

        public DiretorTecnico(int id,String nome,String email, String senha){
            super(id,nome,email,senha,1);
        }

        public void listarCompeticoes() {}
        public void selecionarCompeticao() {}
        public void selecionarProva() {}
        public void informarTempoProva() {}
        public void informarTerminoLancamentoTempoDaProva() {}

    }

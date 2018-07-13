package dominio;

/**
 * Created by João V. Araújo on 11/07/18.
 */

public enum CategoriaMap {

    FEMININO(1),
    MASCULINO(2);

    public Integer id;
    CategoriaMap(Integer id){ this.id = id; }

    public static String getValue(Integer id) {
        switch(id){
            case 1:
                return "FEMININO";
            case 2:
                return "MASCULINO";
            default:
                throw new IllegalArgumentException();
        }
    }
}


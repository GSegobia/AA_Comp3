package dominio;

public enum ClasseMap {

    MIRIM(1),
    MIRIM_I(2),
    MIRIM_II(3),
    PETIZ_I(4),
    PETIZ_II(5),
    INFANTIL_I(6),
    INFANTIL_II(7),
    JUVENIL_I(8),
    JUVENIL_II(9),
    JUNIOR_I(10),
    JUNIOR_II(11),
    SENIOR(12),
    MASTER(13);

    public Integer id;
    ClasseMap(Integer id) {
        this.id = id;
    }

    public static String getValue(Integer id) {
        switch(id){
            case 1:
                return "MIRIM";
            case 2:
                return "MIRIM_I";
            case 3:
                return "MIRIM_II";
            case 4:
                return "PETIZ_I";
            case 5:
                return "PETIZ_II";
            case 6:
                return "INFANTIL_I";
            case 7:
                return "INFANTIL_II";
            case 8:
                return "JUVENIL_I";
            case 9:
                return "JUVENIL_II";
            case 10:
                return "JUNIOR_I";
            case 11:
                return "JUNIOR_II";
            case 12:
                return "SENIOR";
            case 13:
                return "MASTER";
            default:
                throw new IllegalArgumentException();
        }
    }
}

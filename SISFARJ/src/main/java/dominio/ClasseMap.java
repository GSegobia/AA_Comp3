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
                return MIRIM.toString();
            case 2:
                return MIRIM_I.toString();
            case 3:
                return MIRIM_II.toString();
            case 4:
                return PETIZ_I.toString();
            case 5:
                return PETIZ_II.toString();
            case 6:
                return INFANTIL_I.toString();
            case 7:
                return INFANTIL_II.toString();
            case 8:
                return JUVENIL_I.toString();
            case 9:
                return JUVENIL_II.toString();
            case 10:
                return JUNIOR_I.toString();
            case 11:
                return JUNIOR_II.toString();
            case 12:
                return SENIOR.toString();
            case 13:
                return MASTER.toString();
            default:
                throw new IllegalArgumentException();
        }
    }
}

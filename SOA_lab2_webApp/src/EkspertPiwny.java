public class EkspertPiwny {
    public String polecPiwo(String kolor) {
        String piwo;
        switch (kolor) {
            case "jasny":
                piwo = "tyskie";
                break;
            case "ciemny":
                piwo = "romper";
                break;
            case "czerwony":
                piwo = "kustosz tequilla";
                break;
            default:
                piwo = "brak poleceń";
        }
        return piwo;
    }
}
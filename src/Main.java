// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Actividad a = new Actividad("fsfsgsf", 34);
        Restaurante r = new Restaurante("rrrr", 324);
        System.out.println(a.getId());
        System.out.println(r.getId());
        Bungalo b = new BungaloAdaptado("Paco bungalos", 1, 1);
        System.out.println(b.getNombre());
        ServicioCatering prueba = new ServicioCatering(new ServicioAsistente(b));
        System.out.println(prueba.getNombre());
        System.out.println(b.getId());
        System.out.println(prueba.getId());

    }
}
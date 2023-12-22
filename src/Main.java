// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        GestorBungalos gb = new GestorBungalos();
        Bungalo b = new Bungalo("Paquito", 0, 0);
        gb.agregar_bungalo(b);
        System.out.println(gb.getBungalos().get(0).getId());
        System.out.println(gb.recuperar_bungalo("B0"));
        gb.eliminar_bungalo(b);
        System.out.println(gb.getBungalos());

    }
}
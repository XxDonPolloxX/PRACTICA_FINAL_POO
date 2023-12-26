// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        GestorGeneralSingleton g = GestorGeneralSingleton.ObtenerInstancia();
        Menu m = new Menu(g);
        m.ejecutar();
        MyInput.serialize(g, "fichero.dat");


    }
}
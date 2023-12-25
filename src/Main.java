// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

       GestorClientes gc = new GestorClientes();
       GestorBungalos gb = new GestorBungalos(gc);
       gc.agregarCliente();
       gb.agregar_bungalo();
       gb.agregarReserva();
       gb.agregarReserva();

    }
}
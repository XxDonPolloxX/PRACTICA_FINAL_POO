/**
 * Esta clase es la encargada de ejecutar el programa.
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class Main {
    /**
     * Este método es el que ejecuta el programa.
     * @param args son los argumentos que se le pasan al programa.
     */
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        GestorGeneralSingleton g = GestorGeneralSingleton.ObtenerInstancia();
        Menu m = new Menu(g);
        m.ejecutar();

        MyInput.serialize(g, "fichero.dat");


    }
}
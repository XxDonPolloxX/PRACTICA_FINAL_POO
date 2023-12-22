// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Bungalo b, b1;
        b = new Bungalo("paco", 2, 3);
        b1 = new BungaloAdaptado("paco", 2, 3);
        System.out.println(b.getId());
        System.out.println(b1.getId());
    }
}
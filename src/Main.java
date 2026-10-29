import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        // Stvaranje barem tri proizvoda
        Proizvod p1 = new Proizvod("   Čaj od kamilice   ", 3.50, 15);
        Proizvod p2 = new Proizvod("Kava Arabica", 8.20);
        Proizvod p3 = new Proizvod("Mlijeko 2.8%", 1.25, 50);

        // Ispis proizvoda
        System.out.println(p1.opis());
        System.out.println(p2.opis());
        System.out.println(p3.opis());

        // Korištenje dopuštenih operacija
        p2.dodaj(30);
        p1.prodaj(5);

        System.out.println("\nNakon promjena stanja:");
        System.out.println(p1.opis());
        System.out.println(p2.opis());

        // Korištenje preopterećenih metoda
        System.out.printf("Ukupna vrijednost proizvoda %s: %.2f EUR%n", p1.getSifra(), p1.ukupnaVrijednost());
        System.out.printf("Ukupna vrijednost proizvoda %s s 10%% popusta: %.2f EUR%n", p2.getSifra(), p2.ukupnaVrijednost(10));

        // Ispis broja stvorenih proizvoda pomoću statičke metode
        System.out.println("Ukupno stvorenih proizvoda: " + Proizvod.getBrojStvorenihProizvoda());

        // Prikaz odbijanja neispravnih vrijednosti pomoću try-catch blokova
        System.out.println("\nTestiranje iznimaka:");

        try {
            p1.prodaj(1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }

        try {
            p3.setCijena(-5.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: " + e.getMessage());
        }

       try {
    Proizvod neispravni = new Proizvod("   ", 10.00);
} catch (IllegalArgumentException e) {
    System.out.println("Odbijeno: " + e.getMessage());
}
    }
}

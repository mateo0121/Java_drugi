public class Proizvod {


    private static int proizvodCount = 0;

    private final String sifra;
    private String naziv;
    private double cijena;
    private int kolicina;

    public Proizvod(String naziv, double cijena, int kolicina) {
        this.naziv = validirajNaziv(naziv);
        this.cijena = validirajCijenu(cijena);
        checkKolicina(kolicina);
        this.kolicina = kolicina;

        proizvodCount++;
        this.sifra = "P" + String.format("%03d", proizvodCount);
    }

    public Proizvod(String naziv, double cijena) {
        this(naziv, cijena, 0);
    }

    // Getteri
    public String getSifra() {
        return sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public int getKolicina() {
        return kolicina;
    }

    // Setteri s validacijom
    public void setNaziv(String naziv) {
        this.naziv = validirajNaziv(naziv);
    }

    private static String validirajNaziv(String naziv) {
        if (naziv == null || naziv.isBlank()) {
            throw new IllegalArgumentException("Naziv ne smije biti null, prazan ni sastavljen samo od razmaka.");
        }
        return naziv.strip();
    }

    public void setCijena(double cijena) {
        this.cijena = validirajCijenu(cijena);
    }

    private static double validirajCijenu(double cijena) {
        if (cijena < 0) {
            throw new IllegalArgumentException("Cijena ne smije biti negativna.");
        }
        return cijena;
    }

    // Samostalna validacijska funkcija za količinu
    private void checkKolicina(int kolicina) {
        if (kolicina < 0) {
            throw new IllegalArgumentException("Količina ne može biti negativna.");
        }
    }

    // Metode za promjenu količine
    public void dodaj(int kolicina) {
        checkKolicina(kolicina);
        this.kolicina += kolicina;
    }

    public void prodaj(int kolicina) {
        checkKolicina(kolicina);
        if (kolicina > this.kolicina) {
            throw new IllegalArgumentException("Količina na skladištu ne može pasti ispod nule. Traženo: " + kolicina + ", dostupno: " + this.kolicina);
        }
        this.kolicina -= kolicina;
    }

    public double ukupnaVrijednost() {
        return cijena * kolicina;
    }

    public double ukupnaVrijednost(double popust) {
        if (popust < 0 || popust > 100) {
            throw new IllegalArgumentException("Popust mora biti između 0 i 100.");
        }
        return ukupnaVrijednost() * (1 - popust / 100);
    }

    public static int getBrojStvorenihProizvoda() {
        return proizvodCount;
    }


    public String opis() {
        return sifra + " | " + naziv + " | " + String.format("%.2f", cijena) + " EUR | " + kolicina + " kom.";
    }
}
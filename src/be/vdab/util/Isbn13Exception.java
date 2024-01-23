package be.vdab.util;

public class Isbn13Exception extends RuntimeException{

    private String foutIsbnNummer;

    public Isbn13Exception() {
    }

    public Isbn13Exception(String message) {
        super(message);
    }
    public Isbn13Exception(String message, String foutIsbnNummer) {
        super(message);
        this.foutIsbnNummer = foutIsbnNummer;
    }

    public String getFoutIsbnNummer() {
        return foutIsbnNummer;
    }
}

package be.vdab.voorwerpen;

import be.vdab.util.Isbn13Exception;
import be.vdab.util.Voorwerp;

public abstract class Boek implements Voorwerp {

    private String titel;
    private String auteur;
    private float aankoopPrijs;
    private String genre;
    private String isbn13;



    public Boek(String titel, String auteur, float aankoopPrijs, String genre, String isbn13) {
        setIsbn13(isbn13);
        setTitel(titel);
        setAuteur(auteur);
        setAankoopPrijs(aankoopPrijs);
        setGenre(genre);
    }

    public String getTitel() {
        return titel;
    }

    public final void setTitel(String titel) {
        if (!titel.isBlank()) {
            this.titel = titel;
        }
    }

    public String getAuteur() {
        return auteur;
    }

    public final void setAuteur(String auteur) {
        if (!auteur.isBlank()) {
            this.auteur = auteur;
        }
    }

    public float getAankoopPrijs() {
        return aankoopPrijs;
    }

    public final void setAankoopPrijs(float aankoopPrijs) {
        if (aankoopPrijs > 0.0) {
            this.aankoopPrijs = aankoopPrijs;
        }
    }

    public String getGenre() {
        return genre;
    }

    public final void setGenre(String genre) {
        if (!genre.isBlank()) {
            this.genre = genre;
        }
    }

    public String getIsbn13() {
        return isbn13;
    }

    public final void setIsbn13(String isbn13) {
        if (checkISBNnummer(isbn13)) {
            this.isbn13 = isbn13;
        } else {
            throw new Isbn13Exception("Ongelidig ISBN", isbn13);
        }
    }

    private boolean checkISBNnummer (String isbn13) {
        if (isbn13 == null || isbn13.isBlank() || isbn13.replaceAll("-", "").length() != 13) {
            return false;
        }
        isbn13 = isbn13.replaceAll("-", "");
        int sum = 0;
        int tweede = 1;
        try {
            for (int i = 0; i < 12; i++) {
                int eerste = Integer.parseInt(isbn13.substring(i, i+1));
                sum += eerste * tweede;
                tweede = tweede == 1 ? 3 : 1;
            }
            int laatste = Integer.parseInt(isbn13.substring(12,13));
            int verschil = 10 - (sum % 10);
            verschil = verschil == 10 ? 0 : verschil;
            return verschil == laatste;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    @Override
    public void gegevensTonen() {
        System.out.println("GEGEVENS VAN EEN BOEK ") ;
        System.out.println("Titel : " + titel) ;
        System.out.println("Auteur : " + auteur) ;
        System.out.println("Het is eigendom van : " + EIGENAAR);
        System.out.println("Aankoopprijs : " + aankoopPrijs);
        System.out.println("Genre : " + genre);
        System.out.println("ISBN: " + isbn13);
    }
    @Override
    public String toString() {
        return EIGENAAR + "; " + titel + "; " + auteur + "; " + aankoopPrijs + "; " + genre + "; " + isbn13;
    }
}

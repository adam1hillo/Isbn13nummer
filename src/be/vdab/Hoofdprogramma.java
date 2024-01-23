package be.vdab;

import be.vdab.util.Isbn13Exception;
import be.vdab.util.Voorwerp;
import be.vdab.voorwerpen.Boek;
import be.vdab.voorwerpen.Boekenrek;
import be.vdab.voorwerpen.LeesBoek;
import be.vdab.voorwerpen.WoordenBoek;

public class Hoofdprogramma {
    public static void main(String[] args) {

        Boek[] boeken = new Boek[6];
        try {
            boeken[0] = new LeesBoek("Titel", "auteur", 5F, "thriller", "646223364", "leren");
        }
        catch (Isbn13Exception ex) {
            System.out.println(ex.getMessage() + ": " + ex.getFoutIsbnNummer());
        }

        try {
            boeken[1] = new LeesBoek("Titel", "auteur", 5F, "thriller", "", "leren");
        }
        catch (Isbn13Exception ex) {
            System.out.println(ex.getMessage() + ": " + ex.getFoutIsbnNummer());
        }

        try {
            boeken[2] = new WoordenBoek("Titel", "auteur", 5F, "thriller", null, "pools");
        }
        catch (Isbn13Exception ex) {
            System.out.println(ex.getMessage() + ": " + ex.getFoutIsbnNummer());
        }

        try {
            boeken[3] = new WoordenBoek("Titel", "auteur", 5F, "thriller", "126-565ab-987c8", "pools");
        }
        catch (Isbn13Exception ex) {
            System.out.println(ex.getMessage() + ": " + ex.getFoutIsbnNummer());
        }

        try {
            boeken[4] = new WoordenBoek();
        }
        catch (Isbn13Exception ex) {
            System.out.println(ex.getMessage() + ": " + ex.getFoutIsbnNummer());
        }

        try {
            boeken[5] = new LeesBoek();
        }
        catch (Isbn13Exception ex) {
            System.out.println(ex.getMessage() + ": " + ex.getFoutIsbnNummer());
        }

        for (Boek boek : boeken) {
            if (boek != null ) {
                boek.gegevensTonen();
            }
        }

    }
}

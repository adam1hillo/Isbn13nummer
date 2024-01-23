package be.vdab.voorwerpen;



public class LeesBoek extends Boek {

    private String onderwerp;
    private static final float WINSTMARGE = 1.5F;

    public LeesBoek() {
        this("Leesboek Java ", "O Reilly", 10.5F, "genre studie", "978-0-306-40615-7", "onderw Informatica");
    }

    public LeesBoek(String titel, String auteur, float aankoopprijs, String genre, String isbn13, String onderwerp) {
        super(titel, auteur, aankoopprijs, genre, isbn13);
        setOnderwerp(onderwerp);
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public void setOnderwerp(String onderwerp) {
        if (!onderwerp.isBlank()) {
            this.onderwerp = onderwerp;
        }
    }

    public static float getWinstmarge() {
        return WINSTMARGE;
    }

    @Override
    public void gegevensTonen() {
        super.gegevensTonen();
        System.out.println("Onderwerp : " + onderwerp);
        System.out.println("Winst : " + winstBerekenen() );
    }

    @Override
    public float winstBerekenen() {
        return getAankoopPrijs() * getWinstmarge();
    }

    @Override
    public String toString() {
        return super.toString() + "; " + onderwerp + "; " + WINSTMARGE;
    }
}

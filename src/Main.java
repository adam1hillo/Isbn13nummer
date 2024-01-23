public class Main {
    public static void main(String[] args) {
        String isbn13 = "978030407";

        System.out.println(checkISBNnummer(isbn13));

    }
    private static boolean checkISBNnummer (String isbn13) {
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
}

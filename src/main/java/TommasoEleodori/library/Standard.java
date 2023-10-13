package TommasoEleodori.library;

abstract class Standard {
    private String isbn;
    private String title;
    private int publicationYear;
    private int pageNb;


    public Standard(String title, int publicationYear, int pageNb, String isbn) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.pageNb = pageNb;
        setISBN(isbn);
    }

    public void setISBN(String isbn) {
        if (isValidISBN13(isbn)) {
            this.isbn = isbn;
        } else {
            throw new IllegalArgumentException("Invalid ISBN-13");
        }
    }

    private boolean isValidISBN13(String isbn) {
        if (isbn == null) {
            return false;
        }
        isbn = isbn.replaceAll("-", "");
        if (isbn.length() != 13) {
            return false;
        }

        try {
            int total = 0;
            for (int i = 0; i < 12; i++) {
                int digit = Integer.parseInt(isbn.substring(i, i + 1));
                total += (i % 2 == 0) ? digit : digit * 3;
            }
            int checksum = 10 - (total % 10);
            if (checksum == 10) {
                checksum = 0;
            }
            int givenChecksum = Integer.parseInt(isbn.substring(12));
            return checksum == givenChecksum;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}




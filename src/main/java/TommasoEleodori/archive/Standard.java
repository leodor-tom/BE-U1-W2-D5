package TommasoEleodori.archive;

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
        Library.getInstance().addBook(this);


    }

    public void setISBN(String isbn) {
        try {
            isValidISBN13(isbn);
            this.isbn = isbn;
        } catch (InvalidISBNException e) {
            throw new IllegalArgumentException(e.getMessage());

        }
    }

    private void isValidISBN13(String isbn) throws InvalidISBNException {
        if (isbn == null) {
            throw new InvalidISBNException("ISBN cannot be null");
        }
        isbn = isbn.replaceAll("-", "");
        if (isbn.length() != 13) {
            throw new InvalidISBNException("ISBN must be 13 characters long");
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
            if (checksum != givenChecksum) {
                throw new InvalidISBNException("Checksum does not match");
            }
        } catch (NumberFormatException nfe) {
            throw new InvalidISBNException("ISBN contains invalid characters");
        }
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPageNb() {
        return pageNb;
    }


    @Override
    public String toString() {
        return "Standard{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", pageNb=" + pageNb +
                '}';
    }
}




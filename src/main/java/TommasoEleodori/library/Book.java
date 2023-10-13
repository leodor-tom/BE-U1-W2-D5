package TommasoEleodori.library;

public class Book extends Standard {
    private String author;
    private String genre;

    public Book(String title, int publicationYear, int pageNb, String isbn, String author, String genre) {
        super(title, publicationYear, pageNb, isbn);
        this.author = author;
        this.genre = genre;
    }
}

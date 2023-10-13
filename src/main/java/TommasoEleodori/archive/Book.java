package TommasoEleodori.archive;

public class Book extends Standard {
    private String author;
    private String genre;

    public Book(String title, int publicationYear, int pageNb, String isbn, String author, String genre) {
        super(title, publicationYear, pageNb, isbn);
        this.author = author;
        this.genre = genre;

    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + getIsbn() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}

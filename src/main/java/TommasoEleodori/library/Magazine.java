package TommasoEleodori.library;

public class Magazine extends Standard {
    private Periodicity periodicity;


    public Magazine(String title, int publicationYear, int pageNb, String isbn, Periodicity periodicity) {
        super(title, publicationYear, pageNb, isbn);
        this.periodicity = periodicity;
    }
}

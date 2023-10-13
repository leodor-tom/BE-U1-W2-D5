package TommasoEleodori;

import TommasoEleodori.archive.Book;
import TommasoEleodori.archive.Library;
import TommasoEleodori.archive.Magazine;
import TommasoEleodori.archive.Periodicity;
import com.github.javafaker.Faker;

public class Application {

    public static void main(String[] args) {

        Faker faker = new Faker();
        Book book2 = new Book(faker.book().title(), faker.number().numberBetween(1400, 2023), faker.number().numberBetween(50, 400), "978-3-161-48410-0", faker.book().author(), faker.book().genre());
        Book book = new Book("The Book", 2020, 305, "978-3-16-148410-0", "Mr. Nobody", "sci-fi");
        Magazine magazine = new Magazine("The Magszine", 2045, 10, "978-0-262-03384-8", Periodicity.WEEKLY);


      /*  Library.getInstance().showCollection();
        Library.getInstance().deleteByISBN("978-0-262-03384-8");
        Library.getInstance().showCollection(); */
        Library.getInstance().searchByISBN("978-3-161-48410-0");
        Library.getInstance().searchByPublicationYear(2020);
        Library.getInstance().searchByAuthor("Mr. NoBody");

    }
}

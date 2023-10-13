package TommasoEleodori.archive;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Library {
    public static Library instance;
    private HashMap<String, Standard> collection;

    public Library() {
        this.collection = new HashMap<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(Standard book) {
        collection.put(book.getIsbn(), book);
    }

    public Standard searchByISBN(String isbn) {
        Standard foundItem = collection.get(isbn);
        if (foundItem != null) {
            System.out.println("Item found: " + foundItem.toString());
        } else {
            System.err.println("No item found whit ISBN: " + isbn);
        }
        return foundItem;
    }

    public boolean deleteByISBN(String isbn) {
        if (collection.containsKey(isbn)) {
            collection.remove(isbn);
            return true;
        }
        return false;
    }

    public void searchByPublicationYear(int year) {
        boolean itemFound = false;
        for (Map.Entry<String, Standard> entry : collection.entrySet()) {
            if (entry.getValue().getPublicationYear() == year) {
                itemFound = true;
                System.out.println("ISBN: " + entry.getKey() + ", title: " + entry.getValue().getTitle());
            }
        }

        if (!itemFound) {
            System.err.println("No item found with publication year " + year);
        }
    }

    public void searchByAuthor(String author) {
        boolean itemFound = false;
        for (Map.Entry<String, Standard> entry : collection.entrySet()) {
            Standard item = entry.getValue();
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    itemFound = true;
                    System.out.println("ISBN: " + entry.getKey() + ", title: " + book);
                }
            }
        }

        if (!itemFound) {
            System.err.println("No item found with author " + author);
        }
    }

    public void saveToFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Standard> entry : collection.entrySet()) {
            Standard item = entry.getValue();
            builder.append(item.getIsbn()).append(",")
                    .append(item.getTitle()).append(",")
                    .append(item.getPublicationYear()).append(",")
                    .append(item.getPageNb()).append(System.lineSeparator());
        }
        try {
            FileUtils.writeStringToFile(file, builder.toString(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        File file = new File(filename);
        try {
            String content = FileUtils.readFileToString(file, "UTF-8");
            String[] lines = content.split(System.lineSeparator());
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showCollection() {
        for (Map.Entry<String, Standard> entry : collection.entrySet()) {
            System.out.println("ISBN: " + entry.getKey() + ",Titolo: " + entry.getValue().getTitle());
        }
    }
}

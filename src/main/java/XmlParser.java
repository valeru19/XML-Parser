import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XmlParser {
    public static Library parseLibrary(String xmlFilePath) throws IOException {
        Library library = new Library();
        BufferedReader reader = new BufferedReader(new FileReader(xmlFilePath));
        String line;
        Book currentBook = null;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.startsWith("<book")) {
                currentBook = new Book();
                String id = line.split("id=\"")[1].split("\"")[0];
                currentBook.setId(id);
            } else if (line.startsWith("<title>")) {
                String title = line.replace("<title>", "").replace("</title>", "");
                currentBook.setTitle(title);
            } else if (line.startsWith("<author>")) {
                String author = line.replace("<author>", "").replace("</author>", "");
                currentBook.setAuthor(author);
            } else if (line.startsWith("<genre>")) {
                String genre = line.replace("<genre>", "").replace("</genre>", "");
                currentBook.setGenre(genre);
            } else if (line.startsWith("<price>")) {
                String price = line.replace("<price>", "").replace("</price>", "");
                currentBook.setPrice(Double.parseDouble(price));
            } else if (line.startsWith("</book>")) {
                library.addBook(currentBook);
            }
        }
        reader.close();
        return library;
    }
}
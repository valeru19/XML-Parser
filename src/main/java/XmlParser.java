import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XmlParser {
    public static Library parseLibrary(String xmlFilePath) throws IOException { // Читает и обрабатывает строки из указанного XML-файла и возвращает объект Library, заполненный объектами Book
        Library library = new Library(); // объект для хранения коллекции книг
        BufferedReader reader = new BufferedReader(new FileReader(xmlFilePath)); // считывает файл построчно
        String line; // хранит текущую строку из файла
        Book currentBook = null; // временная переменная для хранения текущей книги во время парсинга

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

/**Основная логика:
 Открытие файла и построчное чтение.
 Проверка содержимого каждой строки:
    Если строка начинается с <book>, создается новый объект Book, и парсится атрибут id.
    Если строка содержит теги <title>, <author>, <genre>, или <price>, извлекаются соответствующие данные и устанавливаются в объект currentBook.
    Если встречается </book>, объект currentBook добавляется в Library через метод addBook.**/
import java.util.ArrayList;
import java.util.List;

public class Library {
    // Список книг
    private List<Book> books = new ArrayList<>(); // List<Book> — список объектов класса Book. Хранит все книги, добавленные в библиотеку

    // Добавление книги в библиотеку
    public void addBook(Book book) { // Добавляет книгу в список books
        books.add(book);
    }

    // Получение списка всех книг
    public List<Book> getBooks() { // Предоставляет доступ к списку книг для чтения или модификации
        return books;
    }

    // Переопределение метода toString для вывода информации о всех книгах
    @Override
    public String toString() { // Формирует строку с информацией о всех книгах в библиотеке
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }
}
/**  Отвечает за преобразование объектов модели (Library и содержащих его книг Book) обратно в XML-формат
    Этот класс позволяет преобразовать данные из внутренней структуры (Library) обратно в читаемый XML-файл**/
public class XmlGenerator {
    public static String generateXml(Library library) {
        StringBuilder xml = new StringBuilder();
        xml.append("<library>\n");
        for (Book book : library.getBooks()) {
            xml.append("  <book id=\"").append(book.getId()).append("\">\n");
            xml.append("    <title>").append(book.getTitle()).append("</title>\n");
            xml.append("    <author>").append(book.getAuthor()).append("</author>\n");
            xml.append("    <genre>").append(book.getGenre()).append("</genre>\n");
            xml.append("    <price>").append(book.getPrice()).append("</price>\n");
            xml.append("  </book>\n");
        }
        xml.append("</library>");
        return xml.toString();
    }
}

/**
 Основная логика генерации XML:

 Добавление корневого элемента <library>.
 Проход по всем книгам в библиотеке (for (Book book : library.getBooks())).
 Формирование XML для каждой книги, включая атрибут id и элементы <title>, <author>, <genre>, <price>.
 Закрытие корневого элемента </library>.
 Возвращение полученной строки XML.
 **/
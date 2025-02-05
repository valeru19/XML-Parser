# XML-Parser

Параметризованный конструктор:

java
Copy
public Book(String id, String title, String author, String genre, double price) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.price = price;
}
Этот конструктор принимает значения для всех атрибутов и инициализирует их. Ключевое слово this используется для обращения к атрибутам текущего объекта.




4. Геттеры и сеттеры
Геттеры и сеттеры обеспечивают доступ к атрибутам класса извне.

Геттеры:

java
Copy
public String getId() { return id; }
public String getTitle() { return title; }
public String getAuthor() { return author; }
public String getGenre() { return genre; }
public double getPrice() { return price; }
Эти методы возвращают значения атрибутов.

Сеттеры:

java
Copy
public void setId(String id) { this.id = id; }
public void setTitle(String title) { this.title = title; }
public void setAuthor(String author) { this.author = author; }
public void setGenre(String genre) { this.genre = genre; }
public void setPrice(double price) { this.price = price; }
Эти методы устанавливают значения атрибутов.

Геттеры и сеттеры позволяют контролировать доступ к данным и добавлять дополнительную логику (например, валидацию) при необходимости.






Library хранит список объектов класса Book. Добавление книги: library.addBook(new Book(...)). Получение списка книг: List<Book> books = library.getBooks().

Library используется xml-парсером для хранения данных, извлеченных из XML т.о. что парсер создает объекты Book и добавляет их в Библиотеку через метод addBook

XMLGenerator берет данные из Library, чтобы сгенерировать xml-файл. генератор получает список книг через getBooks() и использует их данные для построения xml-стр-ры

в Main создается объект Library, который передется между парсером и генератором






Пример полного цикла работы 
1)Парсинг XML:
XmlParser читает XML-файл, создает объекты Book и добавляет их в Library.

2)Модификация данных:
Через getBooks() можно получить список книг и, например, изменить цену какой-либо книги.

3)Генерация XML:
XmlGenerator берет данные из Library и формирует новый XML-файл.

4)Валидация:
XmlValidator проверяет, соответствует ли сгенерированный XML схеме library.xsd.


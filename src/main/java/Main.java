public class Main {
    public static void main(String[] args) {
        try {
            // Парсинг XML
            Library library = XmlParser.parseLibrary("resources/library.xml");
            System.out.println("Parsed Library:");
            System.out.println(library);

            // Генерация XML
            String generatedXml = XmlGenerator.generateXml(library);
            System.out.println("Generated XML:");
            System.out.println(generatedXml);

            // Валидация XML
            boolean isValid = XmlValidator.validateXml("resources/library.xml", "resources/library.xsd");
            System.out.println("XML is valid: " + isValid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

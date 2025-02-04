import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {
    /**
     * Валидирует XML-файл по XSD-схеме.
     *
     * @param xmlFilePath Путь к XML-файлу.
     * @param xsdFilePath Путь к XSD-схеме.
     * @return true, если XML валиден, иначе выбрасывает исключение.
     * @throws Exception Если XML не соответствует XSD-схеме или возникла ошибка при валидации.
     */
    public static boolean validateXml(String xmlFilePath, String xsdFilePath) throws Exception {
        // Создаем фабрику для работы с XSD-схемами
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        // Загружаем XSD-схему
        Source schemaSource = new StreamSource(new File(xsdFilePath));
        Schema schema = factory.newSchema(schemaSource);

        // Создаем валидатор на основе схемы
        Validator validator = schema.newValidator();

        // Загружаем XML-файл для валидации
        Source xmlSource = new StreamSource(new File(xmlFilePath));

        // Валидируем XML
        validator.validate(xmlSource);

        // Если ошибок нет, возвращаем true
        return true;
    }
}


/**Класс XmlValidator:
 *
 Проверяет XML-файл на соответствие XSD-схеме.
 Использует стандартные Java-библиотеки (javax.xml.validation).
 Взаимодействует с Main, XmlGenerator и XmlParser.

 Метод validateXml:
 Загружает XSD-схему и XML-файл.
 Выполняет валидацию и возвращает результат.

 Назначение:
 Обеспечивает корректность данных и предотвращает ошибки при работе с XML. **/
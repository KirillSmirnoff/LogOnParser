package ru.k2.WebParser;

import ru.k2.WebParser.JSON.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Launch {

//    public static final String UriString = "/home/k2/Desktop/Onelya/docs/P62G62_test_answerExample.xml";

    public static void main(String[] args) throws IOException {

        SpringApplication.run(Launch.class, args);
//        File file = new File(UriString); //вркменно закаментил путь у xml файл
//        JsonHandler jsonHandler = new JsonHandler();

        /*метод используется, если данный поступают на станддартный ввод-вывод*/
//        jsonHandler.jsonHandlerFromStandardIO();

/*метод используется, если данный считываются с файла
        jsonHandler.jsonHandlerFromFile(file);*/

    }

    /*Парсинг ru.k2.WebParser.XML при помоши SAX ---- мметод не используется в текущей реализации
    private static void xmlParser() {
        XmlHandler xmlHandler = new XmlHandler();
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            saxParser.parse(UriString, xmlHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }
    */
}
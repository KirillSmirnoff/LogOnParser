package dao;

import java.io.*;
import java.util.Properties;

/*ЗАГРУЖАЕТ ФАЙЛ СО ЗНАЧЕНИЯМИ ТЕГОВ*/
public class DataFromProperties {
    public Properties loadProperties()  {
        Properties properties = new Properties();
        try {
            properties.load(new BufferedReader(new InputStreamReader(DataFromProperties.class.getResourceAsStream("/tags.txt"),"UTF-8")));
        } catch (IOException e) {
            System.out.println("ФАЙЛ СО ЗНАЧЕНИЯМИ ТЕГОВ НЕ НАЙДЕН\n");
            e.printStackTrace();
        }

        return properties;
    }
}

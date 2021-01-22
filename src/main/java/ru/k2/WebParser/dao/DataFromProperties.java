package ru.k2.WebParser.dao;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Properties;

/*ЗАГРУЖАЕТ ФАЙЛ СО ЗНАЧЕНИЯМИ ТЕГОВ*/
@Service
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

//    public void addTag(Tag tag){
//        Properties properties = loadProperties();
//                properties.setProperty(tag.getTag(), tag.getMeans());
//        try {
//        properties.store(new FileOutputStream(new File("/tags.txt")),"");
//        } catch (IOException e) {
//            System.out.println("Ошибка при добавлении");
//            e.printStackTrace();
//        }
//        DataFromProperties rf = new DataFromProperties();
//        Properties properties = rf.loadProperties();
//
////        File file = new File("/home/k2/IdeaProjects/LogOnelyaParser/src/main/resources/tags.txt");
////        file.setWritable(true);
////        System.out.println(file.canWrite());
//
//
//
////        Properties properties = new Properties();
//        properties.setProperty("spring", "spring");
//        try {
////            properties.store(new FileOutputStream(new File("/home/k2/IdeaProjects/LogOnelyaParser/src/main/resources/tags.txt")),"");
//            properties.store(new OutputStreamWriter(new FileOutputStream(new File("/home/k2/IdeaProjects/LogOnelyaParser/src/main/resources/tags.txt")),"UTF-8"),"");
//        } catch (IOException e) {
//            System.out.println("Ошибка при добавлении");
//            e.printStackTrace();
//        }
//    }
}

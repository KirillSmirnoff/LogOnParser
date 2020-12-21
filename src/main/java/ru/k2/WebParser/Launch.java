package ru.k2.WebParser;

import ru.k2.WebParser.JSON.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Launch {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Launch.class, args);
    }
}
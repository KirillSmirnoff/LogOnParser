package ru.k2.WebParser.domain;

import org.springframework.stereotype.Component;

@Component
public class InputData {
    String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

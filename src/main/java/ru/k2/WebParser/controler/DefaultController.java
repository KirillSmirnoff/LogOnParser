package ru.k2.WebParser.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.k2.WebParser.JSON.JsonHandler;
import ru.k2.WebParser.domain.InputData;

@Controller
public class DefaultController {

    private  JsonHandler jsonHandler;

    @Autowired
    public void setJsonHandler(JsonHandler jsonHandler) {
        this.jsonHandler = jsonHandler;
    }

    @GetMapping("/")
    public String getFormatFromInput(Model model){
        model.addAttribute(new InputData());
        return "starter";
    }

    @PostMapping("/")
    public String postFormatFromInput(InputData data){
        System.out.println(jsonHandler.webConverter(data.getData()));
        return "redirect:result";
    }

    @GetMapping("/result")
    public String resultInput(Model model){
//        model.addAttribute(new InputData());
        return "result";
    }
}

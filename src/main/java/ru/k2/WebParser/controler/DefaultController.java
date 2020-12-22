package ru.k2.WebParser.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.k2.WebParser.JSON.JsonHandler;
import ru.k2.WebParser.dao.DataFromProperties;
import ru.k2.WebParser.dao.Tag;
import ru.k2.WebParser.domain.InputData;
import ru.k2.WebParser.domain.ResultData;

@Controller
public class DefaultController {

    private  JsonHandler jsonHandler;
    private DataFromProperties dataFromProperties;

    @Autowired
    public void setDataFromProperties(DataFromProperties dataFromProperties) {
        this.dataFromProperties = dataFromProperties;
    }

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
    public String postFormatFromInput(InputData data, Model model){
        String s = jsonHandler.webConverter(data.getData());
        ResultData res = new ResultData();
        res.setResult(s);
        model.addAttribute("res", res);

        return "result";
    }

    @GetMapping("/add")
    public String creatTag(Model model){
        model.addAttribute(new Tag());
        return "add_tag";
    }

    @PostMapping("/add")
    @ResponseBody
    public String resultInput(Tag tag, Model model){
        dataFromProperties.addTag(tag);
        return "Ok";
    }
}

package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.Dictionary;

@Controller
public class DictionaryController {
    @Autowired
    Dictionary dictionary;
    @GetMapping("/")
    public String homePage(){
        return "inputWord";
    }
    @GetMapping("/inputWord")
    public String resultSearch(String txSearch, Model model){
        String result=dictionary.resultSearch(txSearch);
        model.addAttribute("resultWord",result);
        return "result";
    }
}

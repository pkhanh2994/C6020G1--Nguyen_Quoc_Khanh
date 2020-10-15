package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/abc")
    public String homePage(){
        return "home-page";
    }


    @GetMapping("home")
    public String save(@RequestParam String[] condiment, Model model){
        model.addAttribute("message",condiment);

        return "home-page";
    }

}

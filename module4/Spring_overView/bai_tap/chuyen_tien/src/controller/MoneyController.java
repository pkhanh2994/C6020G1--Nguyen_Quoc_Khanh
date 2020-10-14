package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.MoneyConvert;

@Controller
public class MoneyController {
    @Autowired
    private MoneyConvert moneyConvert;
    @GetMapping("/")
    public String homePage(){

        return "inputMoney";

    }
    @GetMapping("/inputMoney")
    public String moneyConvert(String rate, String usd, Model model){
       float result= moneyConvert.moneyConvert(Float.parseFloat(rate),Float.parseFloat(usd));
      model.addAttribute("resultMonney",result);
      return "convertMoney";

    }
}

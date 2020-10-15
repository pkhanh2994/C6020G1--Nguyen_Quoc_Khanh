package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.Calculator;

@Controller
public class CalculatorController {
    @Autowired
    Calculator calculator;
    @GetMapping("/")
    public String homePage(){
        return "home-page";
    }
    @PostMapping("/calculator")
    public String resultCalculator(@RequestParam String nums1, @RequestParam String nums2, @RequestParam String operator, Model model){

        String display="";
        try {
            double result = calculator.calculator(Double.parseDouble(nums1), Double.parseDouble(nums2), operator);
            display = (nums1 + " " + operator + " " + nums2 + " " + "=" + " " + result);
        }catch (RuntimeException e){
            display=e.getMessage();
        }
        model.addAttribute("nums1",nums1);
        model.addAttribute("nums2",nums2);
        model.addAttribute("result",display);

        return "home-page";
    }

}

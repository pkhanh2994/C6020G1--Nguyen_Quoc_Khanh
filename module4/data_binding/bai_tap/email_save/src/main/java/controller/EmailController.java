package controller;

import model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.EmailDao;

import java.util.List;

@Controller
public class EmailController {
@Autowired
    EmailDao emailDao;
    @GetMapping("/")
    public String homPage(Model model,Email email){
        List<Email>emailList=emailDao.findAllEmail();
        model.addAttribute("emailList",emailList);
        return "home-page";
    }

@GetMapping("/create")
   public String create(Email email, Model model){
       model.addAttribute("email", new Email());
       return "create";
   }
   @PostMapping("/saveEmail")
    public String inforEmail(@ModelAttribute("email") Email email, Model model){
       model.addAttribute("email",email);
       return "info";
   }

}

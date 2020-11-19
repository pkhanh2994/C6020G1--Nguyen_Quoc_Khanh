package com.codegym.controller;

import com.codegym.entity.securityFurama.AppUser;
;
import com.codegym.service.employee.EmployeeService;
import com.codegym.service.securirtyFurama.AppUserService;
import com.codegym.service.securirtyFurama.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/signUp")
public class RegisterController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("listEmployee",this.employeeService.findAll());
        model.addAttribute("appUser", new AppUser());
        return "register/register";
    }

    @PostMapping("/register")
    public String saveAccount(@ModelAttribute AppUser appUser, @RequestParam("admin") Long[] admin,
                              RedirectAttributes redirectAttributes, Model model
    ) {
        boolean checkExist = true;
        List<AppUser> appUserList = this.appUserService.findAll();
        for (AppUser appUser1 : appUserList) {
            if (appUser1.getUserName().equals(appUser.getUserName())) {
                checkExist = false;
                break;
            }
        }
        if (checkExist) {
            appUser.setEncrytedPassword(bCryptPasswordEncoder.encode(appUser.getEncrytedPassword()));
            this.appUserService.saveUser(appUser);
          for(int i=0;i<admin.length;i++){
              this.userRoleService.saveUserRole(appUser,admin[i]);
            }
          redirectAttributes.addFlashAttribute("message","successful");
          return "redirect:/";
        } else {
            model.addAttribute("listEmployee",this.employeeService.findAll());
            model.addAttribute("message", "user name exist.Please enter another user name");
            return "register/register";
        }

    }
}
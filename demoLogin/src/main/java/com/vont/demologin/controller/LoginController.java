package com.vont.demologin.controller;

import com.vont.demologin.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {
    @GetMapping("index")
    public String index() {
        return "index";
    }
    @PostMapping("index")
    public String login(@ModelAttribute User user, Model model) {
        StringBuilder mess = new StringBuilder();
        if (user.getUsername().trim().isEmpty()) {
            mess.append("Nhap tai khoan ");
        }else {
            if (!user.getUsername().trim().equals("admin")){
                model.addAttribute("messUser", "Sai tai khoan");
            } else {
                if (user.getPassword().trim().isEmpty()) {
                    mess.append(" Nhap mat khau! ");
                }else {
                    if (!user.getPassword().trim().equals("123")){
                        model.addAttribute("username", user.getUsername());
                        model.addAttribute("messPass", "Sai mat khau");
                    }
                }
            }
        }

        if (mess.toString().length() > 0) {
            model.addAttribute("message", mess.toString());
        }
        model.addAttribute("username", user.getUsername());
        return "index";
    }
}

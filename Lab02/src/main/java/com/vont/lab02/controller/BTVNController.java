package com.vont.lab02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BTVNController {
    @GetMapping("bai01")
    public String BaiTap01(@RequestParam("str1") String str1, @RequestParam("str2") String str2, Model model) {
        String trave = "";
        if(str1.length() > str2.length()) {
            model.addAttribute("message", str1);
        }else if(str1.length() < str2.length()){
            model.addAttribute("message", str2);
        }else {
            model.addAttribute("message", "Chuoi 1 va chuooi 2 bang nhau");
        }
        return "views/bai01";
    }

    @GetMapping("bai02")
    public String BaiTap02(@RequestParam("str") StringBuilder str, Model model) {
        model.addAttribute("str", str.toString());
        model.addAttribute("rts", str.reverse().toString());
        return "views/bai02";
    }

    @GetMapping("bai03")
    public String BaiTap03(@RequestParam("number") int number, Model model) {
        if(number < 2) {
            model.addAttribute("ngto", 2);
        }else {
            int ktra = number + 1;
            while (!ktrngto(ktra)) {
                ktra ++;
            }
            model.addAttribute("ngto", ktra);
        }
        model.addAttribute("number", number);
        return "views/bai03";
    }

    private Boolean ktrngto(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

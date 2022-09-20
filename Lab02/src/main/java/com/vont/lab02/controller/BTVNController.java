package com.vont.lab02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BTVNController {
    @GetMapping("bai01")
    public String BaiTap01(@RequestParam("str1") String str1, @RequestParam("str2") String str2, Model model) {
        StringBuilder traVe = new StringBuilder();
        if(str1.length() > str2.length()) {
            traVe.append(str1);
        }else if(str1.length() < str2.length()){
            traVe.append(str2);
        }else {
            traVe.append("Chuoi 1 va chuooi 2 bang nhau");
        }
        model.addAttribute("message", traVe.toString());
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
            model.addAttribute("ngTo", 2);
        }else {
            int soNgTo = number + 1;
            while (!kTrNgTo(soNgTo)) {
                soNgTo ++;
            }
            model.addAttribute("ngTo", soNgTo);
        }
        model.addAttribute("number", number);
        return "views/bai03";
    }

    private Boolean kTrNgTo(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

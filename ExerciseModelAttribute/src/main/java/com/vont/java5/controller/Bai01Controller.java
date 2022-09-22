package com.vont.java5.controller;

import com.vont.java5.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("login")
public class Bai01Controller {
    @GetMapping
    public String loginRequest(Model model, @ModelAttribute("user") User user) {
        model.addAttribute("user", new User());
        return "exercise01/login";
    }

    @PostMapping
    public String loginResponse(Model model, @ModelAttribute("user") User user) {
        Map<String, String> messages = new HashMap<>();
        String expression = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$";
        model.addAttribute("user", user);
        try {
            if (user.getName().trim().isEmpty()) {
                messages.put("messName", "Vui long nhap ten cua ban!");
            } else if (!user.getName().trim().matches(expression)) {
                messages.put("messName", "Vui long nhap dung dinh dang ten!");
            }
            if (user.getAddress().trim().isEmpty()) {
                messages.put("messAddress", "Vui long nhap dia chi cua ban!");
            } else if (user.getAddress().trim().length() < 10) {
                messages.put("messAddress", "Dia chi phai lon hon 10 ki tu!");
            }
            if (user.getYear().trim().isEmpty()) {
                messages.put("messYear", "Vui long nhap nam sinh cua ban!");
            } else {
                int year = Integer.parseInt(user.getYear());
                if (year >= LocalDate.now().getYear()) {
                    messages.put("messYear", "Nam sinh phai nho hon nam hien tai!");
                }
                int age = 2022 - year;
                model.addAttribute("age", age);
            }

        } catch (Exception e) {
            messages.put("messYear", "Nam sinh phai la so!");
        }
        if (!messages.isEmpty()) {
            messages.forEach(model::addAttribute);
            return "exercise01/login";
        }

        return "exercise01/info";
    }
}

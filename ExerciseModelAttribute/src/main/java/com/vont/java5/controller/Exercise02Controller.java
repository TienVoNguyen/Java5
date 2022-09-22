package com.vont.java5.controller;

import com.vont.java5.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("order")
public class Exercise02Controller {
    @GetMapping
    public String orderRequest(Model model, @ModelAttribute("product")Product product) {
        model.addAttribute("product", product);
        return "exercise02/order";
    }

    @PostMapping
    public String orderResponse(Model model, @Validated @ModelAttribute("product") Product product,
                                BindingResult result) {
        if(result.hasErrors()) {
            return "exercise02/order";
        }
        double total = product.getPrice() * product.getQuantity();
        model.addAttribute("total", total);
        model.addAttribute("date", LocalDate.now());
        return "exercise02/invoice";
    }
}

package com.vont.myshopping.controller;

import com.vont.myshopping.models.entity.Account;
import com.vont.myshopping.payload.request.SignupRequest;
import com.vont.myshopping.service.IAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("account")
public class AccountController {
    private final IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("login/form")
    public String loginForm(Model model) {
        model.addAttribute("message", "Vui lòng đăng nhập!");
        return "account/login";
    }

    @GetMapping("login/success")
    public String loginSuccess(Model model) {
        model.addAttribute("message", "Đăng nhập thành công");
        return "account/login";
    }

    @GetMapping("login/error")
    public String loginError(Model model) {
        model.addAttribute("message", "Lỗi đăng nhập");
        return "account/login";
    }


    @GetMapping("logout/success")
    public String logoffSuccess(Model model) {
        model.addAttribute("message", "Đăng xuất thành công");
        return "account/login";
    }

    @GetMapping("logoff/unauthoried")
    public String unAuthoried(Model model) {
        model.addAttribute("message", "Bạn không có quyền truy xuất");
        return "account/login";
    }

    @PostMapping("/signup")
    public String registerUser(Model model, @Valid @ModelAttribute SignupRequest signUpRequest) {
        model.addAttribute("message", accountService.registerUser(signUpRequest).getMessage());
        return "account/login";
    }
}

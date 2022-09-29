package com.example.demoslide.controller;

import com.example.demoslide.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    private final DeTaiService deTaiService;
    private final GiangVienService giangVienService;
    private final HuongDanService huongDanService;
    private final KhoaService khoaService;
    private final SinhVienService sinhVienService;

    public MyController(DeTaiService deTaiService, GiangVienService giangVienService, HuongDanService huongDanService, KhoaService khoaService, SinhVienService sinhVienService) {
        this.deTaiService = deTaiService;
        this.giangVienService = giangVienService;
        this.huongDanService = huongDanService;
        this.khoaService = khoaService;
        this.sinhVienService = sinhVienService;
    }

    @GetMapping("test")
    public String getAll(Model model) {
        model.addAttribute("tblDeTai", deTaiService.getAll());
        model.addAttribute("tblGiangVien", giangVienService.getAll());
        model.addAttribute("tblHuongDan", huongDanService.getAll());
        model.addAttribute("tblKhoa", khoaService.getAll());
        model.addAttribute("tblSinhVien", sinhVienService.getAll());
        return "index";
    }
}

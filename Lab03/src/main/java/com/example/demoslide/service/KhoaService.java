package com.example.demoslide.service;

import com.example.demoslide.dao.ITBLHuongDanDAO;
import com.example.demoslide.dao.ITBLKhoaDAO;
import com.example.demoslide.models.TBLHuongDan;
import com.example.demoslide.models.TBLKhoa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhoaService {
    final
    ITBLKhoaDAO khoaDAO;

    public KhoaService(ITBLKhoaDAO khoaDAO) {
        this.khoaDAO = khoaDAO;
    }

    public List<TBLKhoa> getAll() {
        return khoaDAO.findAll();
    }
}

package com.example.demoslide.service;

import com.example.demoslide.dao.ITBLHuongDanDAO;
import com.example.demoslide.dao.ITBLSinhVienDAO;
import com.example.demoslide.models.TBLHuongDan;
import com.example.demoslide.models.TBLSinhVien;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienService {
    final
    ITBLSinhVienDAO sinhVienDAO;

    public SinhVienService(ITBLSinhVienDAO sinhVienDAO) {
        this.sinhVienDAO = sinhVienDAO;
    }

    public List<TBLSinhVien> getAll() {
        return sinhVienDAO.findAll();
    }
}

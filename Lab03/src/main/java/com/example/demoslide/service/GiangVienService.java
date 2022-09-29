package com.example.demoslide.service;

import com.example.demoslide.dao.ITBLDeTaiDAO;
import com.example.demoslide.dao.ITBLGiangVienDAO;
import com.example.demoslide.models.TBLDeTai;
import com.example.demoslide.models.TBLGiangVien;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiangVienService {
    final
    ITBLGiangVienDAO giangVienDAO;

    public GiangVienService(ITBLGiangVienDAO giangVienDAO) {
        this.giangVienDAO = giangVienDAO;
    }

    public List<TBLGiangVien> getAll() {
        return giangVienDAO.findAll();
    }
}

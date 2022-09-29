package com.example.demoslide.service;

import com.example.demoslide.dao.ITBLHuongDanDAO;
import com.example.demoslide.models.TBLHuongDan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuongDanService {
    final
    ITBLHuongDanDAO huongDanDAO;

    public HuongDanService( ITBLHuongDanDAO huongDanDAO) {
        this.huongDanDAO = huongDanDAO;
    }

    public List<TBLHuongDan> getAll() {
        return huongDanDAO.findAll();
    }
}

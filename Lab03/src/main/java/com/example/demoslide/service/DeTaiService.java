package com.example.demoslide.service;

import com.example.demoslide.dao.ITBLDeTaiDAO;
import com.example.demoslide.models.TBLDeTai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeTaiService {
    final
    ITBLDeTaiDAO deTaiDAO;

    public DeTaiService(ITBLDeTaiDAO deTaiDAO) {
        this.deTaiDAO = deTaiDAO;
    }

    public List<TBLDeTai> getAll() {
        return deTaiDAO.selectAll();
    }
}

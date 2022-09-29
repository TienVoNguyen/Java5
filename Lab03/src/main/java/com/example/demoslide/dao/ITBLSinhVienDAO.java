package com.example.demoslide.dao;

import com.example.demoslide.models.TBLHuongDan;
import com.example.demoslide.models.TBLSinhVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITBLSinhVienDAO extends JpaRepository<TBLSinhVien, Integer> {

}

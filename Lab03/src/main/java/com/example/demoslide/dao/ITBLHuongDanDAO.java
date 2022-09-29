package com.example.demoslide.dao;

import com.example.demoslide.models.TBLGiangVien;
import com.example.demoslide.models.TBLHuongDan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITBLHuongDanDAO extends JpaRepository<TBLHuongDan, Integer> {

}

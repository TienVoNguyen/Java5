package com.example.demoslide.dao;

import com.example.demoslide.models.TBLDeTai;
import com.example.demoslide.models.TBLGiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITBLGiangVienDAO extends JpaRepository<TBLGiangVien, Integer> {

}

package com.example.demoslide.dao;

import com.example.demoslide.models.TBLHuongDan;
import com.example.demoslide.models.TBLKhoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITBLKhoaDAO extends JpaRepository<TBLKhoa, String> {

}

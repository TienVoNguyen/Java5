package com.example.demoslide.dao;

import com.example.demoslide.models.TBLDeTai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITBLDeTaiDAO extends JpaRepository<TBLDeTai, String> {
    @Query(value = "select * from TBLDeTai", nativeQuery = true)
    List<TBLDeTai> selectAll();
}

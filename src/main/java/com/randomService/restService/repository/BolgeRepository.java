package com.randomService.restService.repository;

import com.randomService.restService.entity.Bolge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BolgeRepository extends JpaRepository<Bolge, Long> {
    @Query("SELECT b FROM Bolge b")
    List<Bolge> getAllBolge();
}

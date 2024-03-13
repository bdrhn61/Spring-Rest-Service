package com.randomService.restService.repository;


import com.randomService.restService.entity.Sehir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SehirRepository extends JpaRepository<Sehir, Long> {
    @Query("SELECT s FROM Sehir s")
    List<Sehir> getAllSehir();


}

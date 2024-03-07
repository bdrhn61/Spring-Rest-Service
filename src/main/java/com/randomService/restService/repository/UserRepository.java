package com.randomService.restService.repository;


import com.randomService.restService.entity.Sehir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Sehir, Long> {
}

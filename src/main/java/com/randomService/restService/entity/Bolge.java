package com.randomService.restService.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="bolge" )
public class Bolge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="bolge_adi")
    private String bolgeAdi;


    public Long getId() {
        return id;
    }

    public String getBolgeAdi() {
        return bolgeAdi;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBolgeAdi(String bolgeAdi) {
        this.bolgeAdi = bolgeAdi;
    }


}

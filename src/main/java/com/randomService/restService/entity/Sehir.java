package com.randomService.restService.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="sehir" )
public class Sehir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;
    @Column(name ="plaka")
    private String plaka;



    public void setSehir(String sehir) {
        this.name = sehir;
    }


    @ManyToOne(optional = false)
    @JoinColumn(name = "bolge_id",nullable = false)
    private Bolge bolge;

}

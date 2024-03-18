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

    public void updateSehir(Sehir sehir) {
        this.name = sehir.name;
        this.plaka = sehir.plaka;
        this.bolge = sehir.bolge;
    }

    public void setSehir(String sehir,Long bolge_id) {
        this.name = sehir;
        this.bolge.setId(bolge_id);
    }


    @ManyToOne(optional = false)
    @JoinColumn(name = "bolge_id",nullable = false)
    private Bolge bolge;

}

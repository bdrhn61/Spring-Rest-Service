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


}

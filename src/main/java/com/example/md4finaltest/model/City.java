package com.example.md4finaltest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long area;
    private Long population;
    private Long gdp;
    private String description;

    @ManyToOne
    @JoinColumn(name="nation_id")
    private Nation nation;



}

package com.example.GaiNumbers.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Numbers {

    @Id
    @Column(name = "number_id")
    private int numberId;

    @Column(name = "number_values")
    private String numberValue;

}

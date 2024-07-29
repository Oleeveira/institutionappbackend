package com.example.institutionbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "visits")
@NoArgsConstructor
@AllArgsConstructor
public class VisitModel {
    @GeneratedValue
    @Id
    private Long id;

    private String name;
    private byte image;
}

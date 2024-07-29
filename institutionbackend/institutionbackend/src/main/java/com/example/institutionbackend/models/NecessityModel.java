package com.example.institutionbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "necessities")
public class NecessityModel {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private Integer quantity;
    @Column(nullable = false,updatable = false)
    private Timestamp created_at;
}

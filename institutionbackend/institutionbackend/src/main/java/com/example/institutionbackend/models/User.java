package com.example.institutionbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "institutions")
public class User {
    @GeneratedValue
    @Id
    private Long id;
    private String email;
    private String password;
    private String name;
    @ManyToOne
    @JoinColumn(name = "necessities")
    private NecessityModel necessities;
    @ManyToOne
    @JoinColumn(name = "visits")
    private VisitModel visits;
}

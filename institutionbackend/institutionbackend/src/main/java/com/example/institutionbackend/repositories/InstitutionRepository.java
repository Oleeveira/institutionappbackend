package com.example.institutionbackend.repositories;

import com.example.institutionbackend.models.InstitutionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstitutionRepository extends JpaRepository<InstitutionModel,Long> {

    Optional<InstitutionModel> findByEmail(String email);

}

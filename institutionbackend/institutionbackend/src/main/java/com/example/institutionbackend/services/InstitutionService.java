package com.example.institutionbackend.services;

import com.example.institutionbackend.models.InstitutionModel;
import com.example.institutionbackend.repositories.InstitutionRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService {
    @Autowired
    private InstitutionRepository institutionRepository;


}

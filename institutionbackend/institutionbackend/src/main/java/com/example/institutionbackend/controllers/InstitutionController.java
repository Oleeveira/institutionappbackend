package com.example.institutionbackend.controllers;

import com.example.institutionbackend.models.InstitutionModel;
import com.example.institutionbackend.services.InstitutionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/user")
public class InstitutionController {
    @Autowired
    private InstitutionService institutionService;
    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("sucessful");
    }

}

package com.example.institutionbackend.controllers;

import com.example.institutionbackend.dto.LoginRequestDTO;
import com.example.institutionbackend.dto.RegisterRequestDTO;
import com.example.institutionbackend.dto.ResponseDTO;
import com.example.institutionbackend.infra.TokenService;
import com.example.institutionbackend.models.InstitutionModel;
import com.example.institutionbackend.repositories.InstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final InstitutionRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        InstitutionModel user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), user.getPassword())){
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<InstitutionModel> user = this.repository.findByEmail(body.email());
        if(user.isEmpty()){
        InstitutionModel newUser = new InstitutionModel();
        newUser.setPassword(passwordEncoder.encode(body.password()));
        newUser.setEmail(body.email());
        newUser.setName(body.name());


        String token = this.tokenService.generateToken(newUser);
        return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));

        }
        return ResponseEntity.badRequest().build();
    }
}

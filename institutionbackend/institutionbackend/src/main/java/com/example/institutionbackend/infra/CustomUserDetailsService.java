package com.example.institutionbackend.infra;

import com.example.institutionbackend.models.InstitutionModel;
import com.example.institutionbackend.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private InstitutionRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        InstitutionModel user = this.repository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

}

package com.test.bob.Service;

import com.test.bob.DTO.RegisterDTO;
import com.test.bob.DTO.UserResponseDTO;
import com.test.bob.Entity.uzytkownik;
import com.test.bob.Repository.registerRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class authService {
    @Autowired
    private registerRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserResponseDTO register(RegisterDTO dto) {
        if (repository.existsByLogin(dto.getLogin())) {
            throw new RuntimeException("Istnieje już taki login");
        }
        if (repository.existsByLogin(dto.getEmail())) {
            throw new RuntimeException("Istnieje już taki email");
        }
        uzytkownik user = new uzytkownik();

        user.setLogin(dto.getLogin());
        user.setEmail(dto.getEmail());
        user.setHaslo(passwordEncoder.encode(dto.getHaslo()));
        user.setImie(dto.getImie());
        user.setNazwisko(dto.getNazwisko());
        user.setStatus(dto.getStatus());
        user.setWiek(dto.getWiek());
        user.setZdjecie(dto.getZdjecie());
        uzytkownik saved = repository.save(user);
        UserResponseDTO response = new UserResponseDTO();

        return response;
    }
}


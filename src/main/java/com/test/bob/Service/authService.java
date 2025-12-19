package com.test.bob.Service;

import com.test.bob.DTO.LoginDTO;
import com.test.bob.DTO.RegisterDTO;
import com.test.bob.DTO.UserResponseDTO;
import com.test.bob.Entity.uzytkownik;
import com.test.bob.Exception.UserNotFoundException;
import com.test.bob.Repository.registerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class authService {
    @Autowired
    private registerRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public UserResponseDTO register(RegisterDTO dto) {
        if (repository.existsByLogin(dto.getLogin())) {
            throw new RuntimeException("Istnieje już taki login");
        }
        if (repository.existsByEmail(dto.getEmail())) {
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

        return new UserResponseDTO(saved);
    }

    public UserResponseDTO login(LoginDTO dto){
        uzytkownik user = repository.
                findByLoginOrEmail(dto.getLogin(), dto.getHaslo())
                .orElseThrow(()-> new UserNotFoundException("Nieprawidłowy login lub hasło"));
        if(!passwordEncoder.matches(dto.getHaslo(), user.getHaslo())){
            throw new UserNotFoundException("Nieprawidłowe hasło");
        }
        return new UserResponseDTO(user);
    }

}


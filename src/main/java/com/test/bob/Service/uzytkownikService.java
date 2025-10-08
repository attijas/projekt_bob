package com.test.bob.Service;

import com.test.bob.Entity.uzytkownik;
import com.test.bob.Repository.uzytkownikRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class uzytkownikService {
    @Autowired
    private uzytkownikRepository repo;

    public List<uzytkownik> findAllUzytkownik() {
        List<uzytkownik> results = repo.findAllUzytkownik();
        return results;
    }

    @Transactional
    public void addNewUzytkownik(String login,
                                 String haslo,
                                 String email,
                                 String imie,
                                 String nazwisko,
                                 int wiek,
                                 String status,
                                 String opis) {
        repo.addNewUzytkownik(login, haslo, email, imie, nazwisko, wiek, status, opis);
    }

    public void editUzytkownik(String login,
                               String haslo,
                               String email,
                               String imie,
                               String nazwisko,
                               int wiek,
                               String status,
                               String opis){
        repo.editUzytkownik(login, haslo, email, imie, nazwisko, wiek, status, opis);
    }

}

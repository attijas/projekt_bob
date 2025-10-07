package com.test.bob.Service;

import com.test.bob.Entity.uzytkownik;
import com.test.bob.Repository.uzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class uzytkownikService {
    @Autowired
    private uzytkownikRepository repo;
    public List<uzytkownik> findAllUzytkownik(){
        List<uzytkownik> results=repo.findAllUzytkownik();
        return results;
    }
}

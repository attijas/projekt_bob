package com.test.bob.Controller;

import com.test.bob.Entity.uzytkownik;
import com.test.bob.Service.uzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/uzytkownicy")

public class uzytkownikController {
    @Autowired
    private uzytkownikService service;
    @GetMapping("/wildcard")
    public List<uzytkownik> wildcard(){
        return service.findAllUzytkownik();
    }
}

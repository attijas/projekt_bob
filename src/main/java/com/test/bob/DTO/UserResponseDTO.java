package com.test.bob.DTO;

import com.test.bob.Entity.uzytkownik;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponseDTO {
    private String login;
    private String haslo;
    private String email;
    private String imie;
    private String nazwisko;
    private String Status;
    private int wiek;
    private byte[] zdjecie;

    public UserResponseDTO(uzytkownik user) {
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.imie = user.getImie();
        this.nazwisko = user.getNazwisko();
        this.wiek = user.getWiek();
        this.zdjecie = user.getZdjecie();
        this.Status = user.getStatus();
        this.haslo = null;
    }
}

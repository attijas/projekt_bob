package com.test.bob.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String login;
    private String haslo;
    private String email;
    private String imie;
    private String nazwisko;
    private String Status;
    private int wiek;
    private byte[] zdjecie;
}

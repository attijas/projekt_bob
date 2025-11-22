package com.test.bob.Repository;

import com.test.bob.DTO.RegisterDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface registerRepository extends JpaRepository<RegisterDTO, Integer > {
    @Transactional
    @Modifying
    @Query(value="insert into uzytkownik (login, haslo, email, imie, nazwisko, wiek, status, zdjecie, opis) " +
            "values(:login, :haslo, :email, :imie, :nazwisko, :wiek, :status, :zdjecie);", nativeQuery = true)
    void registerUzytkownik(@Param("login")String login,
                          @Param("haslo")String haslo,
                          @Param("email")String email,
                          @Param("imie")String imie,
                          @Param("nazwisko")String nazwisko,
                          @Param("wiek")int wiek,
                          @Param("status")String status,
                          @Param("zdjecie")byte[] zdjecie);
//zmienic sql'a
    @Transactional
    @Modifying
    @Query(value="insert into uzytkownik (login, haslo, email, imie, nazwisko, wiek, status, zdjecie, opis) " +
            "values(:login, :haslo, :email, :imie, :nazwisko, :wiek, :status, :zdjecie);", nativeQuery = true)
    void changeToFachowiec(@Param("login")String login,
                            @Param("haslo")String haslo,
                            @Param("email")String email,
                            @Param("imie")String imie,
                            @Param("nazwisko")String nazwisko,
                            @Param("wiek")int wiek,
                            @Param("status")String status,
                            @Param("zdjecie")byte[] zdjecie);

    boolean existsByLogin(String login);
    boolean existsByEmail(String email);


}

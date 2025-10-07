package com.test.bob.Repository;

import com.test.bob.Entity.uzytkownik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface uzytkownikRepository extends CrudRepository<uzytkownik, Integer > {

    @Query(value="select * from uzytkownik", nativeQuery = true)
    List<uzytkownik> findAllUzytkownik();
}

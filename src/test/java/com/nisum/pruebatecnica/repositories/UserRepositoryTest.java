package com.nisum.pruebatecnica.repositories;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@DataJpaTest
@Sql("classpath:sql/data/data.sql")
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindEmail(){
        //given
        String email = "bryan@rodriguez.org";
        //when
        Optional userEntity= userRepository.findByEmail(email);
        //then
        assertTrue(userEntity.isPresent());
    }
}

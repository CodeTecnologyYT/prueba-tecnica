package com.nisum.pruebatecnica.repositories;

import com.nisum.pruebatecnica.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {

    public Optional<UserEntity> findByEmail(String email);
}

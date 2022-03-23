package com.nisum.pruebatecnica.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.nisum.pruebatecnica.constants.StatusEnum;
import com.nisum.pruebatecnica.exceptions.NoDataFoundException;
import com.nisum.pruebatecnica.models.entities.UserEntity;
import com.nisum.pruebatecnica.models.response.LoginResponse;
import com.nisum.pruebatecnica.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    private String TOKEN_SECRET;

    @Autowired
    public UserService(@Value("${jwt.password}") String TOKEN_SECRET,UserRepository userRepository){
        this.TOKEN_SECRET = TOKEN_SECRET;
        this.userRepository = userRepository;
    }

    public LoginResponse login(UserEntity userEntity){

        // Find User and if it is found get exception
        Optional userOptional = userRepository.findByEmail(userEntity.getEmail());
        if(userOptional.isPresent()) throw new NoDataFoundException("El correo ya fue registrado");

        // Setter parameter created UserEntity
        userEntity.setIsActive(StatusEnum.ACTIVE.getStatus());
        userEntity.setPhones(userEntity.getPhones().stream().map(phoneEntity -> {
            phoneEntity.setUser(userEntity);
            return phoneEntity;
        }).collect(Collectors.toSet()));

        // Save and Get UserEntity
        UserEntity userEntityCreate= userRepository.save(userEntity);
        userRepository.deleteAll();

        return LoginResponse.builder()
                .id(userEntityCreate.getId())
                .created(userEntityCreate.getDateCreated())
                .last_login(userEntityCreate.getDateLastLogin())
                .modified(userEntityCreate.getDateModified())
                .isactive(userEntityCreate.getIsActive())
                .token(createToken(userEntityCreate))
                .build();
    }

    public String createToken(UserEntity userEntity){
        Date now = new Date();
        Date expiryDate =  new Date(now.getTime() + (1000 * 60 * 60));
        return JWT.create()
                .withSubject(userEntity.getEmail())
                .withIssuedAt(new Date())
                .withExpiresAt(expiryDate)
                .sign(Algorithm.HMAC512(TOKEN_SECRET));
    }
}

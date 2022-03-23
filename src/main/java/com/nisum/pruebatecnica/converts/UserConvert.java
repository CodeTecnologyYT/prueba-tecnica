package com.nisum.pruebatecnica.converts;

import com.nisum.pruebatecnica.models.entities.UserEntity;
import com.nisum.pruebatecnica.models.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class UserConvert extends AbstractConvert<UserRequest,UserEntity>{
    @Autowired
    PhoneConvert phoneConvert;

    @Override
    public UserEntity fromRequest(UserRequest userRequest) {
        return UserEntity.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .phones(phoneConvert.fromRequest(userRequest.getPhones()))
                .build();
    }
}

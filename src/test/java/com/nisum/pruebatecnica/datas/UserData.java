package com.nisum.pruebatecnica.datas;

import com.nisum.pruebatecnica.constants.StatusEnum;
import com.nisum.pruebatecnica.models.entities.PhoneEntity;
import com.nisum.pruebatecnica.models.entities.UserEntity;
import com.nisum.pruebatecnica.models.requests.PhoneRequest;
import com.nisum.pruebatecnica.models.requests.UserRequest;
import com.nisum.pruebatecnica.models.response.LoginResponse;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.stream.Collectors;

public class UserData {

    public static UserEntity USER_ENTITY_RETURN = UserEntity.builder()
              .id("dasdasdasdas")
              .name("Juan Rodrigez")
              .email("juan@rodriguez.org")
              .password("zH123")
              .isActive(StatusEnum.ACTIVE.getStatus())
              .dateCreated(new Timestamp(1L))
              .dateModified(new Timestamp(1L))
              .dateLastLogin(new Timestamp(1L))
              .phones(Arrays.asList(PhoneEntity.builder()
                              .number("123143")
                              .cityCode("1")
                              .countryCode("52").build())
                      .stream()
                      .collect(Collectors.toSet()))
              .build();

    public static UserEntity USER_ENTITY_IN = UserEntity.builder()
            .name("Juan Rodrigez")
            .email("juan@rodriguez.org")
            .password("zH123")
            .phones(Arrays.asList(PhoneEntity.builder()
                            .number("123143")
                            .cityCode("1")
                            .countryCode("52").build())
                    .stream()
                    .collect(Collectors.toSet()))
            .build();

    public static LoginResponse LOGIN_RESPONSE = LoginResponse.builder()
            .id("dasdasdasdas")
            .isactive(StatusEnum.ACTIVE.getStatus())
            .modified(new Timestamp(1L))
            .created(new Timestamp(1L))
            .last_login(new Timestamp(1L))
            .build();

    public static UserRequest USER_REQUEST = UserRequest.builder()
            .name("Rodolfo el Reno")
            .email("bryan@nisum.com")
            .password("bA12345")
            .phones(Arrays.asList(PhoneRequest.builder()
                    .number("131451")
                    .citycode("1")
                    .countrycode("21")
                    .build()))
            .build();

    public static UserRequest USER_REQUEST_EMAIL_FIND = UserRequest.builder()
            .name("Rodolfo el Reno")
            .email("bryan@rodriguez.org")
            .password("bA12345")
            .phones(Arrays.asList(PhoneRequest.builder()
                    .number("131451")
                    .citycode("1")
                    .countrycode("21")
                    .build()))
            .build();

    public static UserRequest USER_REQUEST_PASSWORD_NOT_FORMAT = UserRequest.builder()
            .name("Rodolfo el Reno")
            .email("bryan@nisum.org")
            .password("1234")
            .phones(Arrays.asList(PhoneRequest.builder()
                    .number("131451")
                    .citycode("1")
                    .countrycode("21")
                    .build()))
            .build();

    public static UserRequest USER_REQUEST_EMAIL_NOT_FORMAT = UserRequest.builder()
            .name("Rodolfo el Reno")
            .email("bryan.org")
            .password("1234")
            .phones(Arrays.asList(PhoneRequest.builder()
                    .number("131451")
                    .citycode("1")
                    .countrycode("21")
                    .build()))
            .build();

    public static LoginResponse LOGIN_RESPONSE_REST = LoginResponse.builder()
            .last_login(new Timestamp(System.currentTimeMillis()))
            .created(new Timestamp(System.currentTimeMillis()))
            .modified(new Timestamp(System.currentTimeMillis()))
            .isactive(StatusEnum.ACTIVE.getStatus())
            .build();
}

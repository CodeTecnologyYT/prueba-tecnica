package com.nisum.pruebatecnica.controllers;

import com.nisum.pruebatecnica.datas.UserData;
import com.nisum.pruebatecnica.models.requests.UserRequest;
import com.nisum.pruebatecnica.models.response.LoginResponse;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql("classpath:sql/data/data.sql")
public class UserControllerTest {

    @Autowired
    private TestRestTemplate client;

    @Test
    public void testCreateUser(){
        //given
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
        UserRequest userRequest = UserData.USER_REQUEST;
        LoginResponse loginResponseExpect = UserData.LOGIN_RESPONSE_REST;
        //when
        ResponseEntity<LoginResponse> response = client.postForEntity("/user/login",userRequest, LoginResponse.class);
        //then
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        assertEquals(loginResponseExpect.getIsactive(), response.getBody().getIsactive());
        assertEquals(dateFormat.format(loginResponseExpect.getCreated()),dateFormat.format(response.getBody().getCreated()));
        assertEquals(dateFormat.format(loginResponseExpect.getLast_login()),dateFormat.format(response.getBody().getLast_login()));
        assertEquals(dateFormat.format(loginResponseExpect.getModified()),dateFormat.format(response.getBody().getModified()));
        assertTrue(response.getBody().getToken() instanceof String);
    }

    @Test
    public void testConflictEmail(){
        //given
        UserRequest userRequest = UserData.USER_REQUEST_EMAIL_FIND;
        String messageExpect = "El correo ya fue registrado";
        //when
        ResponseEntity<String> response = client.postForEntity("/user/login",userRequest, String.class);
        //then
        assertEquals(HttpStatus.CONFLICT,response.getStatusCode());
        assertTrue(response.getBody().contains(messageExpect));
    }

    @Test
    public void testPasswordNotFormat(){
        //given
        UserRequest userRequest = UserData.USER_REQUEST_PASSWORD_NOT_FORMAT;
        String messageExpect = "La contraseña no tiene el formato correcto";
        //when
        ResponseEntity<String> response = client.postForEntity("/user/login",userRequest, String.class);
        //then
        assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
        assertTrue(response.getBody().contains(messageExpect));
    }

    @Test
    public void testEmailNotFormat(){
        //given
        UserRequest userRequest = UserData.USER_REQUEST_EMAIL_NOT_FORMAT;
        String messageExpect = "Email no tiene el formato Correcto";
        //when
        ResponseEntity<String> response = client.postForEntity("/user/login",userRequest, String.class);
        //then
        assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
        assertTrue(response.getBody().contains(messageExpect));
    }


}

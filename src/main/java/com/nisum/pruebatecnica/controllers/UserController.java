package com.nisum.pruebatecnica.controllers;

import com.nisum.pruebatecnica.converts.UserConvert;
import com.nisum.pruebatecnica.models.entities.UserEntity;
import com.nisum.pruebatecnica.models.requests.UserRequest;
import com.nisum.pruebatecnica.models.response.LoginResponse;
import com.nisum.pruebatecnica.services.UserService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Servicios relacionados a usuario")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserConvert userConvert;

    @ApiResponses( value ={
        @ApiResponse(responseCode = "201",description = "Creacion y Login User",
            content = @Content(mediaType = "application/json",schema = @Schema(implementation = LoginResponse.class))),
        @ApiResponse(responseCode = "400",description = "Mal formato del json de entrada",content = @Content),
        @ApiResponse(responseCode = "409",description = "Email ya se encuentra registrado",content = @Content),
        @ApiResponse(responseCode = "500",description = "Error Interno de usuario",content = @Content),
    })
    @PostMapping("/login")
    public ResponseEntity login(@Valid  @RequestBody UserRequest userRequest){
        UserEntity userEntity = userConvert.fromRequest(userRequest);
        LoginResponse loginResponse =userService.login(userEntity);
        return new ResponseEntity(loginResponse, HttpStatus.CREATED);
    }
}

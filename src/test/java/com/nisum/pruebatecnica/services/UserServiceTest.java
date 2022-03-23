package com.nisum.pruebatecnica.services;

import com.nisum.pruebatecnica.datas.UserData;
import com.nisum.pruebatecnica.exceptions.NoDataFoundException;
import com.nisum.pruebatecnica.models.entities.UserEntity;
import com.nisum.pruebatecnica.models.response.LoginResponse;
import com.nisum.pruebatecnica.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import java.util.Optional;

@SpringBootTest
@TestPropertySource(locations = "/application.properties")
public class UserServiceTest {

    @Value("${jwt.password}")
    private String TOKEN;

    UserRepository userRepository;
    UserService userService;

    @BeforeEach
    void init (){
        userRepository = mock(UserRepository.class);
        userService = new UserService(TOKEN,userRepository);
    }

    @Test
    public void loginTestCaseSuccess(){
        //given
        UserEntity userEntity = UserData.USER_ENTITY_IN;
        UserEntity userEntityReturn = UserData.USER_ENTITY_RETURN;
        LoginResponse loginResponseExpect= UserData.LOGIN_RESPONSE;
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(userRepository.save(any())).thenReturn(userEntityReturn);
        //when
        LoginResponse loginResponseNow =userService.login(userEntity);
        //then
        assertEquals(loginResponseExpect.getId(),loginResponseNow.getId());
        assertEquals(loginResponseExpect.getIsactive(),loginResponseNow.getIsactive());
        assertEquals(loginResponseExpect.getModified(),loginResponseNow.getModified());
        assertEquals(loginResponseExpect.getLast_login(),loginResponseNow.getLast_login());
    }

    @Test
    public void loginTestThrowExceptionEmailFind(){
        //given
        UserEntity userEntity = UserData.USER_ENTITY_IN;
        //when
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.ofNullable(UserData.USER_ENTITY_RETURN));
        assertThrows(NoDataFoundException.class,()->{
            //then
            userService.login(userEntity);
        });
    }
}

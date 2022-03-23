package com.nisum.pruebatecnica.models.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Login Response")
public class LoginResponse {
    @Schema(description = "ID genero al registrar el usuario")
    private String id;
    @Schema(description = "Fecha creacion del usuario")
    private Date created;
    @Schema(description = "Fecha de modificacion")
    private Date modified;
    @Schema(description = "Fecha de la ultima actualizacion")
    private Date last_login;
    @Schema(description = "Token del jwt")
    private String token;
    @Schema(description = "El usuario esta activo")
    private String isactive;
}

package com.nisum.pruebatecnica.models.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "User Request")
public class UserRequest {
    @Schema(example = "Bryan Rosas Quispe", required = true)
    @NotBlank(message = "Nombre no puede ser vacio")
    private String name;

    @Schema(description = "Correo del usuario",example = "example@nisum.com", required = true)
    @NotBlank(message = "Correo no puede ser vacio")
    @Email(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9-]{2,}$", message = "Email no tiene el formato Correcto")
    private String email;

    @Schema(description = "Password del usuario",example = "Password123",required = true)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d{2})[a-zA-Z\\d]{2,}$", message = "La contraseña no tiene el formato correcto")
    @Size(min = 4,max = 100,message = "La contrasena como minimo tiene que tener 4 caracteres y como maximo 100 caracteres")
    @NotNull(message = "Contrasena no puede ser vacio")
    private String password;

    @Valid
    @NotEmpty(message = "Celulares no puede ser vacio")
    @Schema(description = "Telefonos del usuario")
    private List<PhoneRequest> phones;
}

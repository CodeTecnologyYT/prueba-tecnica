package com.nisum.pruebatecnica.models.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Schema(name = "Phone Request")
public class PhoneRequest {
    @Schema(description = "Numero de Telefono",example = "+511954206384",required = true)
    @NotBlank(message = "Numero no puede ser vacio")
    private String number;

    @Schema(description = "Codigo de Ciudad", example = "1",required = true)
    @NotBlank(message = " Codigo de ciudad no puede ser vacio")
    private String citycode;

    @Schema(description = "Codigo de Pais",example = "52",required = true)
    @NotBlank(message = "Codigo de pais no puede ser vacio")
    private String countrycode;
}

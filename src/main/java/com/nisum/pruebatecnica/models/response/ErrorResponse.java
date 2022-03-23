package com.nisum.pruebatecnica.models.response;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    Map<String,String> errors;
}

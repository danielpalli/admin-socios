package com.copal.gestion.domain.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DomicilioRequest {
    @NotBlank(message = "La provincia no puede estar vacía")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "La provincia debe contener solo letras y espacios")
    private String provincia;
    @NotBlank(message = "La localidad no puede estar vacía")
    private String localidad;
    @NotBlank(message = "La calle no puede estar vacía")
    private String calle;
    @NotBlank(message = "La altura no puede estar vacía")
    @Pattern(regexp = "\\d+", message = "La altura debe contener solo números")
    private String altura;
    @NotBlank(message = "El departamento no puede estar vacío")
    private String departamento;
    @NotBlank(message = "El piso no puede estar vacío")
    @Pattern(regexp = "\\d+", message = "El piso debe contener solo números")
    private String piso;
}

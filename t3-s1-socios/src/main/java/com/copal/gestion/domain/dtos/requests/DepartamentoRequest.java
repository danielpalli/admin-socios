package com.copal.gestion.domain.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoRequest {
    @NotNull(message = "El nombre del departamento no puede estar vacío")
    private String nombreDepartamento;
    @NotNull(message = "La jerarquia no puede estar vacío")
    private String jerarquia;
}

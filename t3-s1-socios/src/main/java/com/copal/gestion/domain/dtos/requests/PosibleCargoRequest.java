package com.copal.gestion.domain.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosibleCargoRequest {
    @NotNull(message = "El nombre del posible cargo no puede estar vacío")
    private String nombrePosibleCargo;
}

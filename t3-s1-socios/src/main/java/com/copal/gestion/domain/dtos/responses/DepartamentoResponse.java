package com.copal.gestion.domain.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartamentoResponse {
    private Long idDepartamento;
    private String nombreDepartamento;
    private String jerarquia;
}

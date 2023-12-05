package com.copal.gestion.domain.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PosibleCargoResponse {
    private Long idPosibleCargo;
    private String nombrePosibleCargo;
}

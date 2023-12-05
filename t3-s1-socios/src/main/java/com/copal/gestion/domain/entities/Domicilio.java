package com.copal.gestion.domain.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio {
    private String provincia;
    private String localidad;
    private String calle;
    private String altura;
    private String departamento;
    private String piso;
}

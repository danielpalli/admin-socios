package com.copal.gestion.domain.entities;

import groovy.transform.builder.Builder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posibles_cargos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PosibleCargo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idPosibleCargo;
    @Column(name = "nombre_posible_cargo", unique = true, nullable = false, length = 30)
    private String nombrePosibleCargo;
}

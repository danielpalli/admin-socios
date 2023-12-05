package com.copal.gestion.domain.entities;

import groovy.transform.builder.Builder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cargo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cargo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idCargo;
//
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//    @JoinColumn(name = "id_departamento")
//    private Departamento departamento;
//
//    @ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.MERGE)
//    @JoinColumn(name = "id_usuario")
//    private Usuario usuario;
//
//    @ManyToOne(fetch =FetchType.LAZY, cascade = CascadeType.MERGE)
//    @JoinColumn(name = "id_posiblecargo")
//    private PosibleCargo posiblecargo;
}

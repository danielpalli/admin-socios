package com.copal.gestion.domain.entities;

import groovy.transform.builder.Builder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "departamentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDepartamento;
    @Column
    private String nombreDepartamento;
    @Column
    private String jerarquia;
    //    @ManyToMany(fetch=FetchType.LAZY,cascade= CascadeType.MERGE)
//    @JoinTable(
//            name="departamento_usuario", joinColumns = @JoinColumn(name = "id_departamento", referencedColumnName = "idDepartamento"),
//            inverseJoinColumns = @JoinColumn(name = "id_usuario",referencedColumnName = "idUsuario"))
//    private List<Usuario> usuarios ;
//
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "departamento_posiblecargo",
        joinColumns = @JoinColumn(
            name = "id_departamento",
            referencedColumnName = "idDepartamento"),
        inverseJoinColumns = @JoinColumn(
            name = "id_posiblecargo",
            referencedColumnName = "idPosibleCargo"))
    private List<PosibleCargo> posiblesCargos;

}

package com.copal.gestion.domain.entities;

import com.copal.gestion.domain.enums.Area;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.copal.gestion.domain.enums.TipoSocio;

@Entity
@Table(name = "socios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSocio;
    @Column(name = "nombre_socio", unique = true, nullable = false, length = 30)
    private String nombreSocio;
    @Column(name = "cuit", unique = true, nullable = false)
    private String cuit;
    @Column(name = "email", unique = true, nullable = false, length = 50)
    private String email;
    @Column(name = "pagina_web", unique = true, length = 255)
    private String paginaWeb;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "provincia", column = @Column(name = "provincia", length = 30, nullable = false)),
            @AttributeOverride(name = "localidad", column = @Column(name = "localidad", length = 30, nullable = false)),
            @AttributeOverride(name = "calle", column = @Column(name = "calle", length = 12, nullable = false)),
            @AttributeOverride(name = "altura", column = @Column(name = "altura", length = 12, nullable = false)),
            @AttributeOverride(name = "departamento", column = @Column(name = "departamento", length = 12)),
            @AttributeOverride(name = "piso", column = @Column(name = "piso")),
    })
    private Domicilio domicilio;
    @Column(name = "tipo_socio", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private TipoSocio tipoSocio;
    @Column(name = "area", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Area area;
    @Column(name = "activo", columnDefinition = "boolean default true")
    private Boolean activo;
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
    @Column(name = "fecha_baja")
    private LocalDateTime fechaBaja;

    @PrePersist
    public void prePersist() {
        this.fechaAlta = LocalDateTime.now();
        this.fechaModificacion = LocalDateTime.now();
        this.activo = true;
    }

    @PostUpdate
    public void postUpdate() {
        this.fechaModificacion = LocalDateTime.now();
    }
}

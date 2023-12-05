package com.copal.gestion.domain.dtos.responses;

import java.time.LocalDateTime;

import com.copal.gestion.domain.entities.Domicilio;
import com.copal.gestion.domain.enums.Area;
import com.copal.gestion.domain.enums.TipoSocio;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SocioResponse {
    private Long idSocio;
    private String nombreSocio;
    private String cuit;
    private String email;
    private String paginaWeb;
    private Domicilio domicilio;
    private TipoSocio tipoSocio;
    private Area area;
    private Boolean activo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime fechaAlta;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime fechaModificacion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime fechaBaja;
}

package com.copal.gestion.domain.dtos.requests;

import com.copal.gestion.domain.dtos.validators.UniqueCuit;
import com.copal.gestion.domain.dtos.validators.UniqueEmail;
import com.copal.gestion.domain.dtos.validators.UniqueNombreSocio;
import com.copal.gestion.domain.dtos.validators.UniquePaginaWeb;
import com.copal.gestion.domain.enums.Area;
import com.copal.gestion.domain.enums.TipoSocio;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocioRequest {
    @NotBlank(message = "El nombre del socio no puede estar vacío")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El nombre del socio debe contener solo letras y espacios")
    @UniqueNombreSocio
    private String nombreSocio;
    @NotBlank(message = "El CUIT no puede estar vacío")
    @Pattern(regexp = "^[0-9]{11}$", message = "El CUIT debe tener 11 dígitos numéricos")
    @UniqueCuit
    private String cuit;
    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "Debe ser una dirección de correo electrónico válida")
    @UniqueEmail
    private String email;
    @NotBlank(message = "La web no puede estar vacía")
    @Pattern(regexp = "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*\\.[a-zA-Z]{2,}$", message = "Debe ser una dirección web válida")
    @UniquePaginaWeb
    private String paginaWeb;
    @Valid
    private DomicilioRequest domicilio;
    @NotNull(message = "El tipo de socio no puede estar vacío")
    @Enumerated(EnumType.STRING)
    private TipoSocio tipoSocio;
    @NotNull(message = "El area no puede estar vacío")
    @Enumerated(EnumType.STRING)
    private Area area;
}

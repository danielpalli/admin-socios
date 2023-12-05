package com.copal.gestion.domain.dtos.validators;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.copal.gestion.services.interfaces.ISocioService;

import jakarta.validation.ConstraintValidator;

import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UniqueNombreSocioValidator implements ConstraintValidator<UniqueNombreSocio, String> {

    private final ISocioService socioService;  

    @Override
    public void initialize(UniqueNombreSocio constraintAnnotation) {
    }

    @Override
    public boolean isValid(String nombreSocio, ConstraintValidatorContext context) {
        if (nombreSocio != null && !nombreSocio.isEmpty() && Objects.nonNull(this.socioService.findByNombreSocio(nombreSocio))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("El nombre del socio ya está registrado").addConstraintViolation();
            return false;
        }
        return true;
    }
}
package com.copal.gestion.domain.dtos.validators;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.copal.gestion.services.interfaces.ISocioService;

import jakarta.validation.ConstraintValidator;

import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UniquePaginaWebValidator implements ConstraintValidator<UniquePaginaWeb, String> {

    private final ISocioService socioService;  

    @Override
    public void initialize(UniquePaginaWeb constraintAnnotation) {
    }

    @Override
    public boolean isValid(String paginaWeb, ConstraintValidatorContext context) {
        if (paginaWeb != null && !paginaWeb.isEmpty() && Objects.nonNull(this.socioService.findByPaginaWeb(paginaWeb))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("El dominio ya está registrado").addConstraintViolation();
            return false;
        }
        return true;
    }
}
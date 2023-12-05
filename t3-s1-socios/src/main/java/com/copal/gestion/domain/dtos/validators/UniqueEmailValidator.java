package com.copal.gestion.domain.dtos.validators;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.copal.gestion.services.interfaces.ISocioService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final ISocioService socioService;  

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email != null && !email.isEmpty() && Objects.nonNull(this.socioService.findByEmail(email))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("El correo electrónico ya está registrado").addConstraintViolation();
            return false;
        }
        return true;
    }
}
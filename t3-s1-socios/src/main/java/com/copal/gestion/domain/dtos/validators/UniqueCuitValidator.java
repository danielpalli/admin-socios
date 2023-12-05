package com.copal.gestion.domain.dtos.validators;

import org.springframework.stereotype.Component;
import java.util.Objects;
import com.copal.gestion.services.interfaces.ISocioService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UniqueCuitValidator implements ConstraintValidator<UniqueCuit, String> {

    private final ISocioService socioService;  

    @Override
    public void initialize(UniqueCuit constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cuit, ConstraintValidatorContext context) {
        if (cuit != null && !cuit.isEmpty() && Objects.nonNull(this.socioService.findByCuit(cuit))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("El CUIT ya está registrado").addConstraintViolation();
            return false;
        }
        return true;
    }
}
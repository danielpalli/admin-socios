package com.copal.gestion.domain.dtos.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueNombreSocioValidator.class)
@Documented
public @interface UniqueNombreSocio {
    String message() default "El nombre del socio ya está registrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
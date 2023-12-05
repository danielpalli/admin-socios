package com.copal.gestion.domain.dtos.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCuitValidator.class)
@Documented
public @interface UniqueCuit {
    String message() default "El cuit ya está registrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
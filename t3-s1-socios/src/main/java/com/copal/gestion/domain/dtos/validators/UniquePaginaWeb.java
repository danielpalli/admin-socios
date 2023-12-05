package com.copal.gestion.domain.dtos.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniquePaginaWebValidator.class)
@Documented
public @interface UniquePaginaWeb {
    String message() default "El dominio ya está registrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
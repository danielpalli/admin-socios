package com.copal.gestion.domain.dtos.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
@Documented
public @interface UniqueEmail {
    String message() default "El correo electrónico ya está registrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
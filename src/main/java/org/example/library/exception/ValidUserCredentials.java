package org.example.library.exception;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserCredentialsValidator.class)
public @interface ValidUserCredentials {
    String message() default "Invalid user credentials";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
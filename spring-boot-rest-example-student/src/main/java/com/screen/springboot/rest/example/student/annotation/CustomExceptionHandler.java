package com.screen.springboot.rest.example.student.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Pavel Zeger
 * @implNote irm-example
 * @since 11/04/2021
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Qualifier
public @interface CustomExceptionHandler {
}

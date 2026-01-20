package com.idrive.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy=DateValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidDate {
	
	String message() default "Please enter valid date in the format YYYY/MM/DD";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	

}

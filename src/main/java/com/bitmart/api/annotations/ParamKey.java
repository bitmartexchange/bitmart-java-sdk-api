package com.bitmart.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamKey {

    // The parameter key.
    String value();

    // Whether the parameter is required.
    boolean required() default false;

}

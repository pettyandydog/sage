package com.access.annotation;

import java.lang.annotation.*;

/**
 * parameter
 * @author andy
 * @create 2017-05-09 15:48
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Param {
    String value() default "";
}

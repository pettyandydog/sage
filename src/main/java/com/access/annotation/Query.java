package com.access.annotation;

import java.lang.annotation.*;

/**
 * query statement
 * @author andy
 * @create 2017-05-10 14:14
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Query {
    String value() default "";
}

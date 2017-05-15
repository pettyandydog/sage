package com.access.annotation;

import java.lang.annotation.*;

/**
 * type
 * @author andy
 * @create 2017-05-09 15:48
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Type {
    String[] value() default "";
}

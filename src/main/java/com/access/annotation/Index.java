package com.access.annotation;

import java.lang.annotation.*;

/**
 * index
 * @author andy
 * @create 2017-05-09 15:48
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Index {
    String[] value() default "";
}

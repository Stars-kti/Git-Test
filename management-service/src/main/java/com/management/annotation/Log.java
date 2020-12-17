package com.management.annotation;


import com.management.annotation.type.LogActionType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用此注解需要一个切点实现持久化得功能
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    String value() default "";

    /**
     * 是否启用
     *
     * @return
     */
    boolean enable() default true;

    LogActionType type() default LogActionType.SELECT;
}

package com.hd.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来标记【推荐】的类或者写法
 *
 * @author HuaDong
 * @date 2019/9/10 16:12
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface Recommend {

    String value() default "";
}

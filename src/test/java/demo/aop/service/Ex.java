package demo.aop.service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 17-04-2013 23:47:27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Ex {
    boolean sendEmail() default false;
}

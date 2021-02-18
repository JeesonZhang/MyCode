package learn_ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 指定注入的 bean，当接口有多个实现类时用到
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface Qualifier {
    String value() default "";
}

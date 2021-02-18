package learn_ioc;

import java.lang.annotation.*;

/**
 * 定义注解来声明要被 IOC 容器管理
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
    // 声明一个注解参数，默认为空字符串
    String name() default "";
}

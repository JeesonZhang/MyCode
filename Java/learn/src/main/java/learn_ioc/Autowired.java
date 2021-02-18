package learn_ioc;

import java.lang.annotation.*;

/**
 * 定义自动装载注解
 */

// 使用位置：字段上
@Target(ElementType.FIELD)
// 声明周期：运行中
@Retention(RetentionPolicy.RUNTIME)
// 将注解信息包含在 Javadoc 中
@Documented
public @interface Autowired {
}

package learn_reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class LearnReflection {

    public static void main(String[] args) throws Exception{
        // 获取类字节码
        Class rc = Class.forName("learn_reflection.Robot");
        // 获取类名
        System.out.println("类名："+rc.getName());
        // 创建对象
        Robot robot = (Robot) rc.newInstance();
        // 获取属性
        Field name = rc.getDeclaredField("name");
        // 设置权限
        name.setAccessible(true);
        // 设置值
        name.set(robot, "更改了属性值");
        // 获取方法
        Method sayHi = rc.getDeclaredMethod("sayHi", String.class);
        // 设置权限
        sayHi.setAccessible(true);
        // 执行方法
        sayHi.invoke(robot, "执行反射方法");

    }

}

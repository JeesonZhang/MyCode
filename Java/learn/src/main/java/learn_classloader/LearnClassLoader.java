package learn_classloader;

import java.io.*;


public class LearnClassLoader {
    public static void main(String[] args) throws Exception{
        // 实例化一个加载器
        MyClassLoader myClassLoader = new MyClassLoader(
                "/Users/jeeson/IdeaProjects/",
                "learn_classloader.MyClassLoader");
        // 利用加载器加载一个类，这里的参数即为 findClass() 的参数
        Class classDemo = myClassLoader.loadClass("ClassDemo");
        // 打印该类的加载器
        System.out.println(classDemo.getClassLoader());
        // 实例化一个对象让静态代码执行
        classDemo.newInstance();
    }
}

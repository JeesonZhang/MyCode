package learn_classloader;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    // 字节码文件目录
    private String path;
    // 加载器名字
    private String classLoaderName;

    // 构造函数
    public MyClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    // 核心方法：查找类，即将字节码文件的二进制流复制到 defineClass 中
    @Override
    public Class findClass(String fileName) {
        byte[] bytes = loadClassData(fileName);
        return defineClass(fileName, bytes, 0, bytes.length);
    }
    // 根据文件名以二进制流方式读取字节码文件
    private byte[] loadClassData(String fileName) {
        // 字节码的完整路径
        String completePath = path + fileName + ".class";
        // 读入流
        InputStream in = null;
        // 输出流
        ByteArrayOutputStream out = null;
        // 实例化读写流
        try {
            in = new FileInputStream(new File(completePath));
            out = new ByteArrayOutputStream();
            int i = 0;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }
}

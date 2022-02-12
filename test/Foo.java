package test;

//类加载三步骤：加载、链接、初始化，从.class文件 -> 方法区内的类信息
//1 加载
//1.1 从.class文件到方法区内的数据结构
//1.2 创建一个Class对象，作为访问该类的入口
//2 链接
//2.1 验证字节码安全
public class Foo {
    static int a = 1;
    final static int b = 2;
    static {
        a = 10;
    }
    static void f(){
    }
    int c = 3;
    Bar bar = new Bar(1,2);
    public Foo(int c) {
        this.c = c;
    }
}

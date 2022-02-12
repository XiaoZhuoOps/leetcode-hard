package test;

public class Bar extends BarBase{
    //int a = 0; 父类实例变量初始化
    int b = 0; //子类实例变量先初始化
    public Bar(int a, int b) {
        super(a); //先调用父类构造器
        this.b = b; //再执行子类构造函数
    }
}

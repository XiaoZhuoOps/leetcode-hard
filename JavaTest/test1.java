package JavaTest;

// java是值传递还是引用传递
public class test1{
    void test(int a, int[] b){
        a++;
        b[0] = -1;
    }
    public static void main(String[] args){
        int a = 1;
        int[] b = new int[]{1};
        new test1().test(a,b);
        System.out.println(a + b[0]);
    }
}


package basic.bit;
/*
    1思路 char -> int 做或运算 判断不同字符个数
    2伪代码
    3实现
 */
public class B1525 {
    public int numSplits(String s) {
        int res = 0;
        int[] forward = new int[s.length()];
        int[] back = new int[s.length()];
        int fs = 0, bs = 0; //或运算的结果
        int fn = 0, bn = 0; //不同字符个数
        //构造不同字符个数数组
        for(int i = 0; i < forward.length; i++){
            //convert
            int hash = 1<<(s.charAt(i)-'a');
            //judge
            if((hash&fs)!=0) forward[i] = ++fn;
            else forward[i] = fn;
            //update fs
            fs|=hash;
        }
        for(int i = back.length-1; 0<=i; i--){
            int hash = 1<<(s.charAt(i)-'a');
            if((hash&bs)!=0) back[i] = ++bn;
            else back[i] = bn;
            bs|=hash;
        }
        //遍历
        for(int i = 0; i < forward.length-1; i++){
            if(forward[i] == back[i+1]) res++;
        }
        return res;
    }
}

package interview;

/*
    1思路 先异或 再统计结果中有多少个1
    2伪代码
        判断1的个数
    3实现
 */
public class I0506 {
    public int convertInteger(int A, int B) {
        int res = 0, xor = A^B;
        while(xor!=0){
            xor &= (xor-1); //消去低位的1
            res++;
        }
        return res;
    }
}

package offer;

/* 
    思路
    伪代码
*/
public class O17 {
    public int[] printNumbers(int n) {
        int temp = 9;
        int[] res = new int[(int)(Math.pow(10, n)-1)];
        while(0<(--n)){
            temp = 10*temp+9;
        }
        for(int i = 1; i <= temp; i++){
            res[i-1] = i;
        }
        return res;
    }
}

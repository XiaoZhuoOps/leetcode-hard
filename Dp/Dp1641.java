package Dp;

public class Dp1641 {
    //用m个字符组成长度为n的具有特定顺序的字符串，问可以有多少中组合方式
    //重叠子问题、组合问题->DP、递归或回溯
    //数组Num[i]代表以第i个元素结尾的在长度为n时刻的字符串的数目
    //Num[i] = ∑Num[j] j<=i 自下而上一直更新Num[i](n-1)次后累加得到最终结果
    public int countVowelStrings(int n) {
        int[] Num = new int[]{1,1,1,1,1};
        for(int i = 1; i < n; i++){
            for (int j = 4; j >= 0; j--) {
                for (int k = 0; k < j; k++) {
                    Num[j] += Num[k];
                }
            }
        }
        return Num[0]+Num[1]+Num[2]+Num[3]+Num[4];
    }
}

